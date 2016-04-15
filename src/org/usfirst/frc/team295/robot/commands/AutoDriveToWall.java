package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoDriveToWall extends Command{
	int dDistance;
	double dSpeed;
	double Kp = .03;
	double dDirection;
	boolean done;
	static double startTime;
	AHRS ahrs;
	double dFront;
	double dDiff;
	double dKpDiff;
	public AutoDriveToWall(int distance, double speed, double direction){
		dDistance = distance;
		dSpeed = speed;
		dDirection = direction;
		requires(RobotMap.autonomous);
		
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		startTime = Timer.getFPGATimestamp();
		ahrs = RobotMap.ahrs;
		dFront = ahrs.getYaw();
//		System.out.println("Drive Started");
//		System.out.println("Angle Initial : " + ahrs.getAngle());
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		dDiff = dFront - ahrs.getYaw();
		if(dDirection > 0){
			dKpDiff = (dDiff)*Kp;
			RobotMap.autonomous.drive(dSpeed, dKpDiff);
		}
		else if(dDirection < 0){
			dKpDiff = -(dDiff)*Kp;
			RobotMap.autonomous.drive(-dSpeed, dKpDiff);	
		}
//		System.out.println("Error : " + dDiff + "Error*KP : " + dKpDiff + "dSpeed : " + dSpeed);
	}

	@Override
	protected boolean isFinished() {
		int value = RobotMap.usSensor.getValue();
		
		if(value == 0) {
			return false;
		}
		
		return value <= dDistance;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		RobotMap.autonomous.drive(0, 0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		end();
	}

}
