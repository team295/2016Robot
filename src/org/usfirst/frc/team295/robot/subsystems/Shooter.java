package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.ShooterManual;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	public static final int LEFT_SHOOTER_PORT = 17;
	public static final int RIGHT_SHOOTER_PORT = 22; //17
	public static final int ANGLE_MOTOR_PORT = 15; //22
	public static final int WEDGE_MOTOR_PORT = 6;

	public static final int PICKUP = 90000; //105000
	public static final int LOW_SHOOT = 80000; //95000
	public static final int HIGH_SHOOT = 25500; //25500
	public static final int CASTLE_SHOOT = 19400; //19400
	public static final int STORE = 10000; //10000
	
	private static double ANGLE_REVERSE_LIMIT = 0;
	private static double ANGLE_FORWARD_LIMIT = 0;
	
	private CANTalon leftShooter;
	private CANTalon rightShooter;
	public CANTalon angleMotor;
	private VictorSP wedgeMotor;
	
	public double shooterAngle = 0;
	
	public DigitalInput wedgeSensor;
	
	private double angleOffset;
	
	public Shooter() {
		wedgeSensor = new DigitalInput(4);
		
		leftShooter = new CANTalon(LEFT_SHOOTER_PORT);
		leftShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftShooter.enableBrakeMode(true);
		leftShooter.enable();

		rightShooter = new CANTalon(RIGHT_SHOOTER_PORT);
		rightShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightShooter.enableBrakeMode(true);
		rightShooter.enable();
		
		angleMotor = new CANTalon(ANGLE_MOTOR_PORT);
		angleMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		angleMotor.configPeakOutputVoltage(5.8, -2.2); //2.5, -4.4
			
		//_talon.configEncoderCodesPerRev(4000);
		angleMotor.setProfile(0);
		angleMotor.setF(0.1);
		angleMotor.setP(0.25);
		angleMotor.setI(0);
		angleMotor.setD(3.2);
		
		angleMotor.setProfile(1); //Speed
		angleMotor.setF(0.005);
		angleMotor.setP(0.02);
		angleMotor.setI(0); 
		angleMotor.setD(0.01);
		
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		angleMotor.configPeakOutputVoltage(12, -12);
		angleMotor.setProfile(1);

		angleMotor.enableForwardSoftLimit(false);
		angleMotor.enableReverseSoftLimit(false);
		
		angleMotor.reverseOutput(false);
		
		angleMotor.setEncPosition(0);
		angleMotor.enable();
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			
		}
		angleMotor.set(0);

		wedgeMotor = new VictorSP(WEDGE_MOTOR_PORT);
		
		angleOffset = angleMotor.getPosition();

		ANGLE_FORWARD_LIMIT = angleOffset + 35;
		ANGLE_REVERSE_LIMIT = angleOffset + 2;
		
		System.out.println(angleOffset);
		
		//angleMotor.setForwardSoftLimit(ANGLE_FORWARD_LIMIT);
		//angleMotor.setReverseSoftLimit(ANGLE_REVERSE_LIMIT);
	}	
	
	
	//TODO: FIX!!!! EVERYHASDKJSA !!!!
	public void setElbowModePosition() {
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		angleMotor.configPeakOutputVoltage(3, -3);
		angleMotor.setProfile(0);
		angleMotor.set(angleMotor.getPosition() / 1.4);
	}
	
	public void setElbowModeSpeed() {
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
		angleMotor.configPeakOutputVoltage(12, -12);
		angleMotor.setProfile(1);
	}
	
	public void setSpeed(double left, double right) {
		leftShooter.set(UtilityFunctions.deadband(left));
		rightShooter.set(UtilityFunctions.deadband(right));
	}
	
	public void setAngleRelative(double revolutions) {
		/*if(angleMotor.getPosition() + revolutions > ANGLE_FORWARD_LIMIT) {
			angleMotor.set(ANGLE_FORWARD_LIMIT - 0.5);
		} else if(angleMotor.getPosition() - revolutions < ANGLE_REVERSE_LIMIT) {
			angleMotor.set(ANGLE_REVERSE_LIMIT + 0.5);
		} else {*/

		//System.out.println(angleMotor.getPosition() + " " + (angleMotor.getPosition() + revolutions));
		angleMotor.set(angleMotor.getPosition() / 1.4 + revolutions);
		//}
		//System.out.println(getAngleRelative());
		//System.out.println(angleMotor.getPosition() + " " + (angleMotor.getPosition() + revolutions));
	}
	
	public void setAngleAbsolute(double angle) {
		angleMotor.set(angle);
		//System.out.println(angleMotor.getPosition() + " | " + angleMotor.getOutputVoltage());
	}
	
	public void setWedgeSpeed(double speed) {
		wedgeMotor.set(speed);
	}
	
	public void zeroAngle() {
		angleMotor.setEncPosition(0);
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			
		}
	}
	
	public CANTalon getAngleMotor() {
		return angleMotor;
	}
	
	public double getAngleRelative() {
		return angleMotor.getPosition();
	}
	
	public double getAngleAbsolute() {
		return angleMotor.getPosition();
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShooterManual());
	}
}