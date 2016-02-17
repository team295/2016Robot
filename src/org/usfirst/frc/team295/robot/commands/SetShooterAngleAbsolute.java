package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SetShooterAngleAbsolute extends Command {

	private Shooter shooter;
	
	private double angle;
	
	public SetShooterAngleAbsolute(double angle) {
		shooter = RobotMap.shooter;
		requires(shooter);
		this.angle = angle;		
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		shooter.setAngleAbsolute(angle);		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(shooter.getAngleAbsolute() - angle) < 1;
	}

	@Override
	protected void end() {
		shooter.setAngleRelative(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
