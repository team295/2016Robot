package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.SetShooterAngleAbsolute;
import org.usfirst.frc.team295.robot.commands.SetShooterAngleRelative;
import org.usfirst.frc.team295.robot.commands.SpinUpShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private Joystick driver;
	private Joystick operator;
	
	private JoystickButton buttonA;
	private JoystickButton buttonB;
	private JoystickButton buttonX;
	private JoystickButton buttonY;
	
	public OI() {
		driver = new Joystick(0);
		operator = new Joystick(1);
		
		buttonA = new JoystickButton(driver, 1);
		buttonA.whenPressed(new SetShooterAngleAbsolute(Shooter.STORE));

		buttonB = new JoystickButton(driver, 2);
		buttonB.whenPressed(new SetShooterAngleAbsolute(Shooter.HIGH_SHOOT));

		buttonX = new JoystickButton(driver, 3);
		buttonX.whenPressed(new SetShooterAngleAbsolute(Shooter.LOW_SHOOT));

		buttonY = new JoystickButton(driver, 4);
		buttonY.whenPressed(new SetShooterAngleAbsolute(Shooter.PICKUP));
	}
	
	public Joystick getDriverJoystick() {
		return driver;
	}
	
	public Joystick getOperatorJoystick() {
		return operator;
	}
	
}
