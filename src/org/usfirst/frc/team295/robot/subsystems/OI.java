package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.SpinUpShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	private Joystick driver;
	private Joystick operator;
	
	private Button spinUpShooter;
	
	public OI() {
		driver = new Joystick(0);
		operator = new Joystick(1);
		
		spinUpShooter = new JoystickButton(driver, 1);
		spinUpShooter.whenPressed(new SpinUpShooter(0.2));
	}
	
	public Joystick getDriverJoystick() {
		return driver;
	}
	
	public Joystick getOperatorJoystick() {
		return operator;
	}
	
}
