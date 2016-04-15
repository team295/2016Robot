package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.commands.Auto5Low;
import org.usfirst.frc.team295.robot.commands.AutonomousOver;
import org.usfirst.frc.team295.robot.subsystems.UltrasonicSensors;
import org.usfirst.frc.team295.robot.utilities.Camera;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	I2C i2c;
	Thread ServerThread; 
	UltrasonicSensors us = new UltrasonicSensors();
	CommandGroup autonomousOver;
	Command driveStraight;
	Command turnRight;
	Command autonomousCommand;
	SendableChooser chooser;	
	static {
		logger = FlightRecorder.getInstance();
	}
	
	public void robotInit() {
		sessionTimer = new Timer();
		RobotMap.init();
		
		autonomousOver =  new AutonomousOver();
		camera = RobotMap.camera;
		
		chooser = new SendableChooser();
		chooser.addDefault("Drive Straight", new AutonomousOver());
		chooser.addObject("5-Low", new Auto5Low());
		SmartDashboard.putData("Auto Chooser",chooser);
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
		System.out.println(RobotMap.shooter.getAngleAbsolute());
//		System.out.println(RobotMap.shooter.getAngleMotor().ge04iot());
		//TODO: ADD BUTTON 5 & 6
		
//		cameraBack.startCapture();
//    	cameraBack.getImage(frame);
//    	server.setImage(frame);
//    	
//    	System.out.println("Shooter Angle : " + RobotMap.shooter.getAngleAbsolute());
	}
	
    @Override
    public void teleopPeriodic() {
    	System.out.println(RobotMap.usSensor.getValue());
    	enabledPeriodic();
    	Scheduler.getInstance().run();
    	camera.loop();
//    	System.out.println(RobotMap.shooter.getAngleAbsolute());
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
    	
//    	RobotMap.shooter.setWedgeSpeed(RobotMap.oi.getOperatorJoystick().getRawAxis(1));
    	
    	logger.log();
	}
    
	@Override
	public void autonomousInit() {
		RobotMap.drivetrain.isTeleop = false;
		enabledInit();
		  autonomousCommand = new Auto5Low();//(Command) chooser.getSelected();
//        
		
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
//		if (autonomousCommand != null) autonomousCommand.start();
//		if(autonomousOver!= null) autonomousOver.start();
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
//		System.out.println(i2c.);
//		 RobotMap.drivetrain.tankDrive(-1 * RobotMap.oi.getDriverJoystick().getRawAxis(1), -1 * RobotMap.oi.getDriverJoystick().getRawAxis(5)); //Might need to flip
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