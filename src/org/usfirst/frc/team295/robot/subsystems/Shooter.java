package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private CANTalon leftShooter;
	private CANTalon rightShooter;
	private CANTalon rotationMotor;
	private CANTalon wedgeMotor;
	
	public Shooter() {
		leftShooter = new CANTalon(15);
		leftShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftShooter.enable();

		rightShooter = new CANTalon(17);
		rightShooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightShooter.enable();
	}
	
	public void setSpeed(double left, double right) {
		leftShooter.set(UtilityFunctions.deadband(left));
		rightShooter.set(UtilityFunctions.deadband(right));
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}