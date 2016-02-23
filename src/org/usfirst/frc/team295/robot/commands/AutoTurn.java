
package org.usfirst.frc.team295.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;

import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class AutoTurn extends Command {
	private double dyawAverage;
	private double dmagnitude;
	private double ddiff;
	private double dpointAngle;
	private double dprojectedAngle;
	private double dnextTime;
	public static double Kp = .05;
	private double dturnAmount;
	private double ddirection;
	private double dfinishDiff;
	private double dYaw;
	Drivetrain drivetrain;
	AHRS ahrs;
	PIDController pidController;
	boolean needadjust;
    public AutoTurn(double turnAmount, double direction) {
        // Use requires() here to declare subsystem dependencies
        ddirection = direction;
        dturnAmount=turnAmount;
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    	drivetrain = RobotMap.drivetrain;
    	ahrs = RobotMap.ahrs;
    	dYaw = ahrs.getAngle();
    	dpointAngle = ahrs.getAngle();
    	dnextTime = Timer.getFPGATimestamp();
//    	if(dpointANgle + dturnAmount)
    	if(ddirection > 0){
    		ddirection = 1;
    		dprojectedAngle = dpointAngle + dturnAmount;
    		if(dprojectedAngle > 360){
    			dprojectedAngle = dturnAmount -(360-dprojectedAngle); 
    			needadjust = true;
    		}
    	}
    	else if(ddirection < 0){
    		ddirection = -1;
    		dprojectedAngle = dpointAngle - dturnAmount;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	dYaw = ahrs.getAngle();
    	dfinishDiff = dprojectedAngle - dYaw;
//    	if(needadjust){
//    		if((360-dYaw)+dprojectedAngle > 1){
//    			dpointAngle+=1;
//    		}
//    		else if(dpointAngle < dprojectedAngle){
//    			dpointAngle+=1;
//    		}
//    		else if(dpointAngle > 360){
//    			dpointAngle = 1;
//    		}
//    	}

    	if(Timer.getFPGATimestamp() > dnextTime){
			dnextTime +=0.005;
			if(dpointAngle<dprojectedAngle){
				dpointAngle += 1;
			}
			else if(dpointAngle > (dprojectedAngle + dturnAmount))
			{
				dpointAngle += 1;
			}
		}
    	ddiff = dpointAngle - dYaw;
    	
//    	if(dprojectedAngle < 0 && dYaw > 0){
//    		dfinishDiff = (180-(-dprojectedAngle))+(180-dYaw);
//    	}
    	dmagnitude = ddiff * Kp;
    	if(dmagnitude > .5){
    		dmagnitude = .5;
    	}
    	drivetrain.drive(dmagnitude,ddirection);

    	System.out.println("dmagnitude: "+ dmagnitude + " dDiff : " + ddiff + " dfinishDiff : " + dfinishDiff + " dYaw : " + dYaw + " dpointAngle : " + dpointAngle + " dfinish : " + dprojectedAngle);
//    	Logger.log(exception);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Math.abs(dfinishDiff) < 5){
    		System.out.println("Turn Done");
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
