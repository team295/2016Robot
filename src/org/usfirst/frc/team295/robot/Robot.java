package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	private static FlightRecorder logger = null;
	private static Timer sessionTimer = null;
	private static long sessionIteration = 0;
	
	static {
		logger = FlightRecorder.getInstance();
	}
	
	public void robotInit() {
		sessionTimer = new Timer();
		RobotMap.init();
	}
	
	public void enabledInit() {
		sessionTimer.start();
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
	}
	
    @Override
    public void teleopPeriodic() {
    	enabledPeriodic();
    	Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		enabledInit();
	}

	@Override
	public void autonomousPeriodic() {
    	enabledPeriodic();
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		enabledInit();
	}
	
	@Override
	public void testPeriodic() {
		
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