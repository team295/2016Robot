package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

public class SetShooterAngleRelative extends Command {

	private Shooter shooter;
	private double angle;
	
	public SetShooterAngleRelative(double angle) {
		shooter = RobotMap.shooter;
		requires(shooter);
		this.angle = angle;
		
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		shooter.setAngleRelative(angle);		
	}

	@Override
	protected boolean isFinished() {
		return true;//Math.abs(shooter.getAngleRelative() - angle) < UtilityFunctions.encoderFinish;
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
