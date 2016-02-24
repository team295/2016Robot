package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.command.Command;

public class SetShoulderPosition extends Command {
	
	private Arm arm;
	private double position;
	
	public SetShoulderPosition(double position) {
		arm = RobotMap.arm;
		requires(arm);
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		arm.setShoulderModePosition();
	}

	@Override
	protected void execute() {
		arm.setShoulderAbsolute(position);
		System.out.println("Moving");
	}

	@Override
	protected boolean isFinished() {
		return true;//Math.abs(arm.getElbowPosition() - position) < UtilityFunctions.encoderDeadband;
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
