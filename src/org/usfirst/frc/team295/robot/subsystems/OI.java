package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

	private Joystick driver;
	private Joystick operator;
	
	public OI() {
		driver = new Joystick(0);
		operator = new Joystick(1);
		
		//spinUpShooter = new JoystickButton(driver, 1);
		//spinUpShooter.whenPressed(new SpinUpShooter(0.4));
	}
	
	public Joystick getDriverJoystick() {
		return driver;
	}
	
	public Joystick getOperatorJoystick() {
		return operator;
	}
	
}
