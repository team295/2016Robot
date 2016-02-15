package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.subsystems.Arm;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;
import org.usfirst.frc.team295.robot.subsystems.OI;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.Camera;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

public class RobotMap {

	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static Arm arm;
	public static OI oi;
	public static FlightRecorder flightRecorder;
	public static Camera camera;
	
	public static void init() {
		//drivetrain = new Drivetrain();
		//shooter = new Shooter();
		arm = new Arm();
		oi = new OI();
		//flightRecorder = new FlightRecorder();
		//camera = new Camera();
	}
	
	//TODO: Never gets called, find a function to put this in
	public static void dispose() {
		flightRecorder.dispose();
	}
	
}
