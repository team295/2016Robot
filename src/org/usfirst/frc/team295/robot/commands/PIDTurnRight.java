package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.Robot;
import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Autonomous;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class PIDTurnRight extends Command{
	double dstartTime;
	double dpointAngle;
	double dendAngle;
	double dturnAmount;
	double dAngle;
	double dEndDiff;
	AHRS ahrs;
	boolean done = false;
	double dCurrentTime;
	double startTimeForTimer;
	/* Feature to make front the zero*/
	
	public PIDTurnRight(double amount){
		requires(RobotMap.autonomous);
		dturnAmount = amount;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		Autonomous.direction = 1;
		RobotMap.autonomous.enable();
		ahrs = RobotMap.ahrs;
		dpointAngle = ahrs.getAngle();
		dendAngle = dturnAmount + ahrs.getAngle();
		dstartTime = Timer.getFPGATimestamp();
		startTimeForTimer = Timer.getFPGATimestamp();
    		if(dendAngle> 360){
    			dendAngle = dturnAmount -(360-ahrs.getAngle()); 
    		}
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		dAngle = ahrs.getAngle();
		dCurrentTime = Timer.getFPGATimestamp();
		if(dCurrentTime>dstartTime){
			dstartTime += 0.025;
			if(dpointAngle < dendAngle){
				dpointAngle +=.5;
			}
			else if(dpointAngle > (dendAngle + dturnAmount))
			{
				dpointAngle += .5;
				if(dpointAngle > 360){
					dpointAngle = dpointAngle - 360;
				}
			}
			else{
				done = true;
			}
		}
		RobotMap.autonomous.setSetpoint(dpointAngle);
		
		
		System.out.println("Right " +" Time: " + (Robot.getTimerValue()-startTimeForTimer) +  
				 " Done ? : " + done + " Error : " 
				+ RobotMap.autonomous.getError() + " " + "Speed : "
				+ RobotMap.autonomous.getPIDController().get()
				+ " DiffAngle : " + (dpointAngle - dAngle) + " DiffTotal : " 
				+ (dendAngle - dAngle) + " Current Angle : " + dAngle + " End Angle: " 
				+ dendAngle + " dpointAngle : " + dpointAngle + " PID C Pos. : " + RobotMap.autonomous.getPosition());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		System.out.println("Turning");
		if(done || RobotMap.autonomous.onTarget() || Math.abs(ahrs.getAngle() - dendAngle) <2){
			RobotMap.autonomous.setError(dendAngle-ahrs.getAngle());
			System.out.println("This turn is done");
			return true;
		}
		return false;
//		return Robot.drivetrain.onTarget();
//		return Robot.drivetrain.onTarget();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		RobotMap.autonomous.disable();
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
