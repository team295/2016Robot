package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.commands.AutoDrive;
import org.usfirst.frc.team295.robot.commands.AutonomousSequence;
import org.usfirst.frc.team295.robot.subsystems.UltrasonicSensors;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	private static FlightRecorder logger = null;
	private static Timer sessionTimer = null;
	private static long sessionIteration = 0;
	
	
	UltrasonicSensors us = new UltrasonicSensors();
	CommandGroup autosequence;
	Command driveStraight;
	
	static {
		logger = FlightRecorder.getInstance();
	}
	
	
	public void robotInit() {
		sessionTimer = new Timer();
		RobotMap.init();
		autosequence =  new AutonomousSequence();
		driveStraight = new AutoDrive(1, .5, 1);
	}
	
	public void enabledInit() {
		sessionTimer.start();
		RobotMap.autonomous.startHeading = RobotMap.ahrs.getAngle();
    	//RobotMap.arm.shoulder.setEncPosition(0);
	}
	
	@Override
	public void disabledInit() {
		// End the current log and prepare a new one for the next enable
		logger.endLog();
		
		// Reset session stats for logger
		sessionTimer.reset();
		sessionIteration = 0;

	}
	
	public void enabledPeriodic() {
		sessionIteration++;
		log();
//		System.out.println(RobotMap.shooter.getAngleMotor().get());
	}
	
    @Override
    public void teleopPeriodic() {
    	enabledPeriodic();
    	Scheduler.getInstance().run();
    	
    	//System.out.println(RobotMap.arm.getShoulderPosition() + " " + RobotMap.arm.getElbowPosition());
    	
    	//System.out.println(RobotMap.us.read());
//    	System.out.println(RobotMap.arm.getShoulderPosition() + " " + RobotMap.arm.getElbowPosition());
    	
//    	System.out.println(RobotMap.shooter.getAngleAbsolute());
    	//us.read();
    	//System.out.println(RobotMap.shooter.getAngleAbsolute());
    	//System.out.println(RobotMap.arm.getShoulderPosition());
//    	System.out.println(RobotMap.shooter.getAngleAbsolute());
    	logger.log();
	}

	@Override
	public void autonomousInit() {
		enabledInit();
//		if (autonomousCommand != null) autonomousCommand.start();
//		if(autosequence != null) autosequence.start();
		if(driveStraight !=null) driveStraight.start(); driveStraight.cancel(); driveStraight.start();
	}

	@Override
	public void autonomousPeriodic() {
    	enabledPeriodic();
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		enabledInit();
		//Move to Auto Init
		
		
//		System.out.println("Start Heading : " + RobotMap.autonomous.startHeading);
	}
	@Override
	public void testInit(){
		
	}
	@Override
	public void testPeriodic() {
		 RobotMap.drivetrain.tankDrive(-1 * RobotMap.oi.getDriverJoystick().getRawAxis(1), -1 * RobotMap.oi.getDriverJoystick().getRawAxis(5)); //Might need to flip
	}
	
	/**
	 * Logs information to all logging agents. Currently, it logs to the EventLogger and the
	 * DataLogger.
	 * 
	 * @param message the primary message to be logged
	 * @param tokens additional string(s) that will be logged in the EventLogger
	 */
	public static void log() {
		logger.log();
	}
	
	public static long getSessionIteration() {
		return sessionIteration;
	}
	
	public static double getTimerValue() {
		return sessionTimer.get();
	}

}