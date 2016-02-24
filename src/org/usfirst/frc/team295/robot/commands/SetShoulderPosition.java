package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Arm;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class SetShoulderPosition extends Command {
	
	private Arm arm;
	private double position;
	private Joystick operatorJoystick;
	
	public SetShoulderPosition(double position) {
		arm = RobotMap.arm;
		requires(arm);
		this.position = position;
		try {
			operatorJoystick = new Joystick(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void initialize() {
		arm.setShoulderModePosition();
	}

	@Override
	protected void execute() {
		arm.setShoulderAbsolute(position);
		System.out.println(position);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(UtilityFunctions.deadband(operatorJoystick.getRawAxis(5))) > 0.2;
	}

	@Override
	protected void end() {
		//arm.rotateShoulderRelative(0);//ShoulderModeSpeed();
		arm.setShoulderModeSpeed();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
