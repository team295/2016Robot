package org.usfirst.frc.team295.robot.Commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTank extends Command {

	public DriveTank() {
		requires(RobotMap.drivetrain);
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		RobotMap.drivetrain.tankDrive(RobotMap.oi.getDriverJoystick().getRawAxis(1),
				RobotMap.oi.getDriverJoystick().getRawAxis(5));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.drivetrain.setSpeed(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}


}
