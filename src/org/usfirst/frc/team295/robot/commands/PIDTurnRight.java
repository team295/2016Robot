package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.Robot;
import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Autonomous;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;

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
		
//		Logger.getInstance().log("PIDTurnRight", 
//				Double.toString(Timer.getFPGATimestamp() - startTimeForTimer),
//				Double.toString(Robot.drivetrain.getPIDController().get()),
//				Double.toString(dAngle),
//				Double.toString(ahrs.getRawAccelX()),
//				Double.toString(ahrs.getRawAccelY()),
//				Double.toString(Robot.drivetrain.getPIDController().getP()),
//				Double.toString(Robot.drivetrain.getPIDController().getI()),
//				Double.toString(Robot.drivetrain.getPIDController().getD())
//		);
		System.out.println(
				"Error : " + " " + 
				"Speed : " +RobotMap.autonomous.getPIDController().get()
				+ " DiffAngle : " + (dpointAngle - dAngle) + " DiffTotal : " + (dendAngle - dAngle) + " Current Angle : " + dAngle + " End Angle: " 
				+ dendAngle + " dpointAngle : " + dpointAngle);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		if(done && RobotMap.autonomous.onTarget() || Math.abs(ahrs.getAngle() - dendAngle) <1){
//			Globals.dError = dendAngle-ahrs.getAngle();
			return true;
		}
		return false;

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
