package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class RotateShooter extends Command {

	private Shooter shooter;
	
	private double position;
	
	public RotateShooter(double position) {
		shooter = RobotMap.shooter;
		requires(shooter);
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;//(Math.abs(RobotMap.shooter.getAnglePosition()) - position < ???);
	}

	@Override
	protected void end() {
		//shooter.setShooterSpeed(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}
