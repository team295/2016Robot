package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetWedge extends Command {
	
	private double startTime;
	private double speed;
	
    public SetWedge(double speed) {
    	this.speed = speed;
    	requires(RobotMap.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		startTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.shooter.setWedgeSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return Timer.getFPGATimestamp() - .18 >= startTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
