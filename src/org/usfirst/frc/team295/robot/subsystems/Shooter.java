package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private static final short LEFT_SHOOTER_PORT = 15;
	private static final short RIGHT_SHOOTER_PORT = 22;
	private static final short ANGLE_MOTOR_PORT = 17;
	
	private CANTalon leftShooter;
	private CANTalon rightShooter;
	private CANTalon angleMotor;
	
	public Shooter(double p, double i, double d) {
		leftShooter = new CANTalon(LEFT_SHOOTER_PORT);
		leftShooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		leftShooter.setPID(7, 0, 0.2); //TODO: Get real values
		
		rightShooter = new CANTalon(RIGHT_SHOOTER_PORT);
		rightShooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		rightShooter.setPID(7, 0, 0.2); //TODO: Get real values
		
		angleMotor = new CANTalon(ANGLE_MOTOR_PORT);
		angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		angleMotor.setPID(7, 0, 0.2); //TODO: Get real values
	}
	
	public void setShooterSpeed(double speed) {
		leftShooter.set(speed);
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

