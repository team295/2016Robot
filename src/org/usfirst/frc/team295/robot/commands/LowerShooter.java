package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class LowerShooter extends Command {

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		RobotMap.shooter.angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		RobotMap.shooter.angleMotor.configPeakOutputVoltage(12.0, -12.0);
		RobotMap.shooter.angleMotor.setProfile(0);
		RobotMap.shooter.setAngleAbsolute(70000);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
