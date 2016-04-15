package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class UltrasonicSensor extends Command {
	
	private int distance;
	
	public UltrasonicSensor(int distance) {
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
		if(RobotMap.usSensor.getValue() == 0) {
			return false;
		}
		return RobotMap.usSensor.getValue() <= distance;
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
