package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.commands.AutonomousOver;
import org.usfirst.frc.team295.robot.subsystems.UltrasonicSensors;
import org.usfirst.frc.team295.robot.utilities.Camera;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;
import org.usfirst.frc.team295.robot.utilities.Server;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Robot extends IterativeRobot {

	private static FlightRecorder logger = null;
	private static Timer sessionTimer = null;
	private static long sessionIteration = 0;
	
	boolean cameraDirection = true; //true = front false = back
	USBCamera cameraFront;
	USBCamera cameraBack;
	Image frame;
	CameraServer server;
	Camera camera;
	
	Thread ServerThread; 
	UltrasonicSensors us = new UltrasonicSensors();
	CommandGroup autonomousOver;
	Command driveStraight;
	Command turnRight;
	
	static {
		logger = FlightRecorder.getInstance();
	}
	
	public void robotInit() {
		sessionTimer = new Timer();
		RobotMap.init();
		autonomousOver =  new AutonomousOver();
		//driveStraight = new AutoDrive(4, .5, 1);
		//turnRight = new PIDTurnRight(90);
		//RobotMap.drivetrain.isTeleop = false;
		camera = RobotMap.camera;
//		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//		server = CameraServer.getInstance();
//        server.setQuality(30);
//        cameraBack = RobotMap.camera.cameraBack;
//        cameraFront = RobotMap.camera.cameraFront;
//        cameraFront.startCapture();
	}
	
	public void enabledInit() {
		sessionTimer.start();
    	//RobotMap.arm.shoulder.setEncPosition(0);
	}
	
	@Override
	public void disabledInit() {
		// End the current log and prepare a new one for the next enable
		logger.endLog();
		
		// Reset session stats for logger
		sessionTimer.reset();
		sessionIteration = 0;
		if(ServerThread!=null)
		ServerThread.interrupt();
	}
	
	public void enabledPeriodic() {
		sessionIteration++;
		log();
//		System.out.println(RobotMap.shooter.getAngleAbsolute());
		System.out.println(RobotMap.shooter.getAngleMotor().get());
		//TODO: ADD BUTTON 5 & 6
		
//		cameraBack.startCapture();
//    	cameraBack.getImage(frame);
//    	server.setImage(frame);
//    	
    	
	}
	
    @Override
    public void teleopPeriodic() {
    	enabledPeriodic();
    	Scheduler.getInstance().run();
    	camera.loop();
//    	if(RobotMap.oi.getDriverJoystick().getRawButton(5)){ 
//    		cameraDirection = !cameraDirection;
//    		if(cameraDirection){
//    			cameraBack.stopCapture();
//    			cameraFront.startCapture();
//    		}
//    		else{
//    			cameraFront.stopCapture();
//    			cameraBack.startCapture();
//    		}
//    	}
//    	if(cameraDirection){
//    		cameraFront.getImage(frame);
//    	}
//    	else{
//    		cameraBack.getImage(frame);
//    	}
//    	server.setImage(frame);
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
		RobotMap.drivetrain.isTeleop = false;
		enabledInit();
//		if (autonomousCommand != null) autonomousCommand.start();
		if(autonomousOver!= null) autonomousOver.start();
//		if(driveStraight !=null) driveStraight.start();
//		if(turnRight !=null) turnRight.start();
	}

	@Override
	public void autonomousPeriodic() {
    	enabledPeriodic();
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
		RobotMap.drivetrain.isTeleop = true;
		enabledInit();
		//Move to Auto Init
		
//		 ServerThread = new Thread(new Server(RobotMap.serversocket));
//		 ServerThread.start();
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