package org.usfirst.frc.team295.robot.commands;


import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousSequence extends CommandGroup {

	double dZeroTurn;
	double dZeroAngle;
	public AutonomousSequence(){
		
		RobotMap.ahrs.reset();
		dZeroAngle = RobotMap.ahrs.getAngle();
		addSequential(new SetShooterAngleAbsolute(50000));
		addSequential(new AutoDrive(2, .5, 1));
//		addSequential(new ZeroDrive());
//		dZeroTurn = dZeroAngle - RobotMap.ahrs.getAngle();
//		if(dZeroTurn > 0){
//			addSequential(new PIDTurnRight(dZeroTurn));
//		} 
//		else if(dZeroTurn < 0 ){
//			addSequential(new PIDTurnLeft(dZeroTurn));
//		}
		addSequential(new PIDTurnRight(45));
		
//		addSequential(new SetShooterAngleAbsolute(Shooter.HIGH_SHOOT));
//		System.out.println("1");
//		addSequential(new SpinUpShooter(1));
//		System.out.println("2");
//		addSequential(new SetWedge(1));
//		System.out.println("3");
//		addSequential(new SpinUpShooter(0));
//		System.out.println("4");
//		addSequential(new SetWedge(-1));
//		System.out.println("5");
//		addSequential(new SetShooterAngleAbsolute(Shooter.STORE));
//		System.out.println("6");
//		
//		dZeroAngle = RobotMap.ahrs.getAngle();
//		RobotMap.ahrs.reset();
//		dZeroAngle = RobotMap.ahrs.getAngle();
//		SmartDashboard.putNumber("dzeroangle", dZeroAngle);
////		addSequential(new AutoDrive(1, .35,1));
////		addSequential(new PIDTurn(180));
////		addSequential(new AutoDrive(1,.35,1));
//		addSequential(new AutoDrive(.5, .6,1));
//		
//		System.out.println(dZeroTurn + " Dzeroturn");
////		SmartDashboard.putNumber("Dzero", value);
//		if(dZeroTurn > 0){
//			addSequential(new PIDTurnRight(dZeroTurn));
//		}
//		else if(dZeroTurn < 0 ){
//			addSequential(new PIDTurnLeft(dZeroAngle));
//		}
//
//		addSequential(new PIDTurnRight(180));
	}
}
