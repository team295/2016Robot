package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetFast extends Command{
	public SetFast(){
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		RobotMap.drivetrain.setFast(true);
		//System.out.println("DriveForward : " + RobotMap.drivetrain.getDirection());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
