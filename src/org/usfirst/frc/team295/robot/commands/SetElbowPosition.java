package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Arm;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.command.Command;

public class SetElbowPosition extends Command {
	
	private Arm arm;
	private double position;
	
	public SetElbowPosition(double position) {
		arm = RobotMap.arm;
		requires(arm);
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		arm.setElbowModePosition();
	}

	@Override
	protected void execute() {
		arm.setElbowAbsolute(position);
	}

	@Override
	protected boolean isFinished() {
		return true;//Math.abs(arm.getElbowPosition() - position) < UtilityFunctions.encoderDeadband;
	}

	@Override
	protected void end() {
		arm.rotateElbowRelative(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
