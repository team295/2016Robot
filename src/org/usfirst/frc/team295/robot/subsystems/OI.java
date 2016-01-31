package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	private Joystick driver;
	private Joystick operator;
	
	public OI() {
		driver = new Joystick(0);
		operator = new Joystick(1);
	}
	
	public void processInputs() {
		//Arcade RobotMap.drivetrain.tankDrive(driver.getRawAxis(1), driver.getRawAxis(5));
		RobotMap.drivetrain.tankDrive(-driver.getRawAxis(1), -driver.getRawAxis(5));
	}
	
}
