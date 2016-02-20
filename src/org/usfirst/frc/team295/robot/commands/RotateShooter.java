package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

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
		shooter.setAngleAbsolute(position);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return (Math.abs(RobotMap.shooter.getAngleAbsolute()) - position < UtilityFunctions.encoderDeadband);
	}

	@Override
	protected void end() {
		shooter.setAngleAbsolute(0);
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}