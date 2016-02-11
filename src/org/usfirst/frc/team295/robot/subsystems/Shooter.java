package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private static final short LEFT_SHOOTER_PORT = 17; //TODO: REMEMBER TO SWITCH BACK @@@@ !OIUI(UDIHJD
	private static final short RIGHT_SHOOTER_PORT = 15;
	private static final short ANGLE_MOTOR_PORT = 22;
	
	public CANTalon leftShooter;
	public CANTalon rightShooter;
	private CANTalon angleMotor;
	
	public Shooter(double p, double i, double d) {
		leftShooter = new CANTalon(LEFT_SHOOTER_PORT);
		leftShooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		leftShooter.setPID(p, i, d); //TODO: Get real values
		leftShooter.configEncoderCodesPerRev(4000);
		leftShooter.reverseSensor(true);
		leftShooter.enable();
		
		rightShooter = new CANTalon(RIGHT_SHOOTER_PORT);
		rightShooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightShooter.configNominalOutputVoltage(0, 0);
		rightShooter.configPeakOutputVoltage(+12f, -12f);

		rightShooter.configEncoderCodesPerRev(4000);
		rightShooter.setProfile(0);
		rightShooter.setF(5);
		rightShooter.setP(0.1);
		rightShooter.setI(0);
		rightShooter.setD(1); //TODO: Get real values
		//rightShooter.setVoltageRampRate(1);
		
		//rightShooter.reverseSensor(false);
		//rightShooter.reverseOutput(false);
		//rightShooter.setEncPosition(0);
		//rightShooter.enable();

		rightShooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		
		angleMotor = new CANTalon(ANGLE_MOTOR_PORT);
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		angleMotor.setPID(p, i, d); //TODO: Get real values
	}
	
	public void setShooterSpeed(double speed) {
		//leftShooter.set(speed);
		rightShooter.set(speed);
	}
	
	public double getLeftShooterSpeed() {
		return leftShooter.getSpeed(); 
	}
	
	public double getRightShooterSpeed() {
		return rightShooter.getSpeed();
	}
	
	public void zeroEncoders() {
		//TODO: Find way to zero
	}
	
	public void rotateAbsolute(double position) {
		angleMotor.set(position);
	}
	
	public void rotateRelative(double amount) {
		angleMotor.set(angleMotor.getPosition() + amount);
	}
	
	public double getAnglePosition() {
		return angleMotor.getPosition();
	}
	
	@Override
	protected void initDefaultCommand() {}
}

