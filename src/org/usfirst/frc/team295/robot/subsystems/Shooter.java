package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	public static final int LEFT_SHOOTER_PORT = 15;
	public static final int RIGHT_SHOOTER_PORT = 17;
	public static final int ANGLE_MOTOR_PORT = 22;
	public static final int WEDGE_MOTOR_PORT = 6;
	
	private CANTalon leftShooter;
	private CANTalon rightShooter;
	private CANTalon angleMotor;
	private VictorSP wedgeMotor;
	
	private double angleOffset;
	
	public Shooter() {
		leftShooter = new CANTalon(LEFT_SHOOTER_PORT);
		leftShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftShooter.enable();

		rightShooter = new CANTalon(RIGHT_SHOOTER_PORT);
		rightShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightShooter.enable();
		
		angleMotor = new CANTalon(ANGLE_MOTOR_PORT);
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		angleMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		angleMotor.configPeakOutputVoltage(2, 2);
		angleMotor.configEncoderCodesPerRev(1000);
		angleMotor.setCloseLoopRampRate(0.1);
		angleMotor.setProfile(0);
		angleMotor.setF(0.1);
		angleMotor.setP(0.25);
		angleMotor.setI(0);
		angleMotor.setD(3.2);
		angleMotor.enable();
		
		wedgeMotor = new VictorSP(WEDGE_MOTOR_PORT);
		wedgeMotor.enableDeadbandElimination(true);
		
		angleOffset = angleMotor.getPosition();
	}
	
	public void setSpeed(double left, double right) {
		leftShooter.set(UtilityFunctions.deadband(left));
		rightShooter.set(UtilityFunctions.deadband(-right));
	}
	
	public void setAngleRelative(double revolutions) {
		angleMotor.set(angleMotor.getPosition() + revolutions);
		System.out.println(getAngleRelative());
		System.out.println(angleMotor.getPosition() + " " + (angleMotor.getPosition() + revolutions));
	}
	
	public void setAngleAbsolute(double angle) {
		angleMotor.set(angle);
	}
	
	public void setWedgeSpeed(double speed) {
		wedgeMotor.set(speed);
	}
	
	public void zeroAngle() {
		angleOffset = angleMotor.getPosition();
	}
	
	public double getAngleRelative() {
		return angleMotor.getPosition() - angleOffset;
	}
	
	public double getAngleAbsolute() {
		return angleMotor.getPosition();
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}