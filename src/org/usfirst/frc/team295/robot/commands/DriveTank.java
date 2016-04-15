package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.Robot;
import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class DriveTank extends Command {
	
	private Drivetrain drivetrain;
	private Joystick driverJoystick;
	
	public DriveTank() {
		drivetrain = RobotMap.drivetrain;
		driverJoystick = RobotMap.oi.getDriverJoystick();
		requires(drivetrain);
		
	}
	
	@Override
	protected void initialize() {}

	@Override
	protected void execute() {
		if(RobotMap.drivetrain.isTeleop) {
			if(driverJoystick.getRawAxis(2) > 0) {
				drivetrain.arcadeDrive(0, -Math.pow(driverJoystick.getRawAxis(2) * 0.7, 1));
			} else if(driverJoystick.getRawAxis(3) > 0) {
				drivetrain.arcadeDrive(0, Math.pow(driverJoystick.getRawAxis(3) * 0.7, 1));
			} else {
				drivetrain.arcadeDrive(-Math.pow(driverJoystick.getRawAxis(1), 1), Math.pow(driverJoystick.getRawAxis(4), 1));
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
//		drivetrain.setSpeed(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
