package org.usfirst.frc.team295.robot;

import java.io.IOException;
import java.net.ServerSocket;

import org.usfirst.frc.team295.robot.subsystems.Arm;
import org.usfirst.frc.team295.robot.subsystems.Autonomous;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;
import org.usfirst.frc.team295.robot.subsystems.OI;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.subsystems.UltrasonicSensors;
import org.usfirst.frc.team295.robot.utilities.Camera;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class RobotMap {

	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static Arm arm;
	public static OI oi;
	public static FlightRecorder flightRecorder;
	public static Camera camera;
	public static Autonomous autonomous;
	public static AHRS ahrs;

	public static ServerSocket serversocket;

	public static UltrasonicSensors us;
	
	public static void init() {
		ahrs = new AHRS(SPI.Port.kMXP);
		autonomous = new Autonomous();
		shooter = new Shooter();
		arm = new Arm();
		drivetrain = new Drivetrain();
		oi = new OI();
		us = new UltrasonicSensors();
		
		// flightRecorder = new FlightRecorder();
		 camera = new Camera();
//		 try {
//				serversocket = new ServerSocket(5800);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
