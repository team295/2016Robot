package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousSequence extends CommandGroup{

	double dZeroTurn;
	double dZeroAngle;
	public AutonomousSequence(){
//		dZeroAngle = RobotMap.ahrs.getAngle();
		RobotMap.ahrs.reset();
		dZeroAngle = RobotMap.ahrs.getAngle();
		SmartDashboard.putNumber("dzeroangle", dZeroAngle);
//		addSequential(new AutoDrive(1, .35,1));
//		addSequential(new PIDTurn(180));
//		addSequential(new AutoDrive(1,.35,1));
		addSequential(new AutoDrive(.5, .6,1));
		dZeroTurn =dZeroAngle - RobotMap.ahrs.getAngle();
		System.out.println(dZeroTurn + " Dzeroturn");
//		SmartDashboard.putNumber("Dzero", value);
		if(dZeroTurn > 0){
			addSequential(new PIDTurnRight(dZeroTurn));
		}
		else if(dZeroTurn < 0 ){
			addSequential(new PIDTurnLeft(dZeroAngle));
		}

		addSequential(new PIDTurnRight(180));
	}
}
