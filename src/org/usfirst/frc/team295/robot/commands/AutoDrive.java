package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.Robot;
import org.usfirst.frc.team295.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDrive extends Command{
	double dTime;
	double dSpeed;
	double Kp = .03;
	double dDirection;
	boolean done;
	static double startTime;
	AHRS ahrs;
	double dFront;
	double dDiff;
	double dKpDiff;
	public AutoDrive(double time, double speed, double direction){
		dTime = time;
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
		System.out.println("Drive Started");
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
		System.out.println("Error : " + dDiff + "Error*KP : " + dKpDiff + "dSpeed : " + dSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub3
		System.out.println("Driving");
		if(Timer.getFPGATimestamp() > startTime + dTime){
			System.out.println("Drive ended");
			return true;
		}
		else{
			return false;
		}
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
