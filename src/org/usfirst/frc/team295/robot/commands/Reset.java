package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;

public class Reset extends Command{
	AHRS ahrs;
	public Reset(){
	
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		ahrs = RobotMap.ahrs;
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		ahrs.reset();
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
