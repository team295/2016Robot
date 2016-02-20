package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.Robot;
import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveShiftShooter extends Command{

	public DriveShiftShooter() {

	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		RobotMap.drivetrain.setDirection(-1);
		System.out.println("DriveBack : " + RobotMap.drivetrain.getDirection());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
