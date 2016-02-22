package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.DriveShiftArm;
import org.usfirst.frc.team295.robot.commands.DriveShiftShooter;
import org.usfirst.frc.team295.robot.commands.SetShooterAngleAbsolute;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	private Joystick driver;
	private Joystick operator;
	
	private JoystickButton driverButtonA;
	private JoystickButton driverButtonB;
	private JoystickButton driverButtonX;
	private JoystickButton driverButtonY;
	private JoystickButton driverButtonLB;
	private JoystickButton driverButtonRB;
	
	private JoystickButton operatorButtonA;
	private JoystickButton operatorButtonB;
	private JoystickButton operatorButtonX;
	private JoystickButton operatorButtonY;
	
	public OI() {
		driver = new Joystick(1);
		operator = new Joystick(0);		
		
		/*buttonA = new JoystickButton(driver, 1);
		buttonA.whenPressed(new SetShooterAngleAbsolute(Shooter.STORE));

		buttonB = new JoystickButton(driver, 2);
		buttonB.whenPressed(new SetShooterAngleAbsolute(Shooter.HIGH_SHOOT));

		buttonX = new JoystickButton(driver, 3);
		buttonX.whenPressed(new SetShooterAngleAbsolute(Shooter.LOW_SHOOT));

		buttonY = new JoystickButton(driver, 4);
		buttonY.whenPressed(new SetShooterAngleAbsolute(Shooter.PICKUP));
		
		if(driver.getRawButton(1)) {
			_talon.set(P_ONE);
		} else if(driver.getRawButton(2)) {
			_talon.set(P_TWO);
		} else if(driver.getRawButton(3)) {
			_talon.set(P_THREE);
		} else if(driver.getRawButton(4)) {
			_talon.set(P_FOUR);
		}*/
		
		/*operatorButtonA = new JoystickButton(operator, 1);
		operatorButtonA.whenPressed(new SetArmPosition(Arm.P_ONE));
		
		operatorButtonB = new JoystickButton(operator, 2);
		operatorButtonB.whenPressed(new SetArmPosition(Arm.P_TWO));
		
		operatorButtonX = new JoystickButton(operator, 3);
		operatorButtonX.whenPressed(new SetArmPosition(Arm.P_THREE));
		
		operatorButtonY = new JoystickButton(operator, 4);
		operatorButtonY.whenPressed(new SetArmPosition(Arm.P_FOUR));*/
		
		driverButtonA = new JoystickButton(driver, 1); //TODO: Change names
		driverButtonA.whenPressed(new SetShooterAngleAbsolute(Shooter.STORE));
		
		driverButtonB = new JoystickButton(driver, 2);
		driverButtonB.whenPressed(new SetShooterAngleAbsolute(Shooter.CASTLE_SHOOT)); //TODO: DriveShiftArm
		
		driverButtonX = new JoystickButton(driver,3);
		driverButtonX.whenPressed(new DriveShiftShooter());
		
		driverButtonY = new JoystickButton(driver,4);
		driverButtonY.whenPressed(new SetShooterAngleAbsolute(Shooter.HIGH_SHOOT));
		
		driverButtonLB = new JoystickButton(driver,5);
		driverButtonLB.whenPressed(new SetShooterAngleAbsolute(Shooter.LOW_SHOOT));
		
		driverButtonRB = new JoystickButton(driver,6);
		driverButtonRB.whenPressed(new SetShooterAngleAbsolute(Shooter.PICKUP));
	}
	
	public Joystick getDriverJoystick() {
		return driver;
	}
	
	public Joystick getOperatorJoystick() {
		return operator;
	}
	
}
