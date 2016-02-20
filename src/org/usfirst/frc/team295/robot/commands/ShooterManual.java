package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterManual extends Command {
	
	private Shooter shooter;
	private Joystick operatorJoystick;
	
	public ShooterManual() {
		shooter = RobotMap.shooter;
		operatorJoystick = RobotMap.oi.getOperatorJoystick();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		//arm.setElbowModeSpeed();
	}

	@Override
	protected void execute() {
		//arm.setShoulderAbsolute(-Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(5)), 3) * 40000);
		//arm.setElbowAbsolute(Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(1)), 3) * 80000);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		//arm.setShoulderAbsolute(0);
		//arm.setElbowAbsolute(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
