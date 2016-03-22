package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ZeroDrive extends Command{
	PIDTurnLeft turnLeft;
	double ddiff;
	PIDTurnRight turnRight;
	public ZeroDrive(){
		requires(RobotMap.autonomous);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
//		ddiff = RobotMap.ahrs.getAngle() - RobotMap.autonomous.startHeading;
//		System.out.println(ddiff);
//		if(ddiff < 0){
//			turnLeft = new PIDTurnLeft(ddiff);
//		}
//		else if(ddiff > 0){
//			turnRight = new PIDTurnRight(ddiff);
//		}
//		else{
//			System.out.println(ddiff);
//		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
//		if(turnLeft.isFinished()){
//			return true;
//		}
//		else if(turnRight.isFinished()){
//			return true;
//		}
//		return false;
		return true;
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
