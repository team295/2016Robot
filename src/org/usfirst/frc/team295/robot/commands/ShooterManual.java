package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterManual extends Command {
	
	private Shooter shooter;
	private Joystick operatorJoystick;
	private double triggerValue;
	
	public ShooterManual() {
		shooter = RobotMap.shooter;
		operatorJoystick = RobotMap.oi.getOperatorJoystick();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(UtilityFunctions.deadband(triggerValue = operatorJoystick.getRawAxis(2)) > 0) {
			//triggerValue = (triggerValue - 0.5) * 2;
			shooter.setSpeed(-triggerValue, -triggerValue);
		} else if(UtilityFunctions.deadband(triggerValue = operatorJoystick.getRawAxis(3)) > 0) {
			//triggerValue = (triggerValue - 0.5) * 2;
			shooter.setSpeed(triggerValue, triggerValue);
		} else {
			shooter.setSpeed(0, 0);
		}
		//System.out.println(triggerValue);
		
		if(operatorJoystick.getRawButton(5)) {
			shooter.setWedgeSpeed(0.8);
		} else if(operatorJoystick.getRawButton(6)) {
			shooter.setWedgeSpeed(-0.8);
		} else {
			shooter.setWedgeSpeed(0);
		}
		
		//shooter.setAngleAbsolute(Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(1)), 1) * 30000);
		//shooter.setAngleAbsolute(operatorJoystick.getRawAxis(1) * 500 + shooter.getAngleAbsolute());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
