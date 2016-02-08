package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

	private Drivetrain drivetrain;
	
	private double distance;
	
	public Drive(double distance) {
		drivetrain = RobotMap.drivetrain;
		requires(drivetrain);
		this.distance = distance;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
 	}

	@Override
	protected void end() {
		drivetrain.setSpeed(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
