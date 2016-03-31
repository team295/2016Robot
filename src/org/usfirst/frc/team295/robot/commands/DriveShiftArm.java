package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveShiftArm extends Command{
	
	public DriveShiftArm(){

	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		RobotMap.drivetrain.setDirection(-1);
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
