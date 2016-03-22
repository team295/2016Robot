package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SpinUpShooter extends Command {
	
	private Shooter shooter;
	
	private double speed;
	private double startTime;
	
	public SpinUpShooter(double speed) {
		shooter = RobotMap.shooter;
		requires(shooter);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
	}

	@Override
	protected void execute() {
		shooter.setSpeed(speed, speed);
	}

	@Override
	protected boolean isFinished() {
		return Timer.getFPGATimestamp() - 1 >= startTime;
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
