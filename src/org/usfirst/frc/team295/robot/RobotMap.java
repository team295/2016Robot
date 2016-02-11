package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.subsystems.Drivetrain;
import org.usfirst.frc.team295.robot.subsystems.OI;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.Camera;
import org.usfirst.frc.team295.robot.utilities.FlightRecorder;

public class RobotMap {

	public static Drivetrain drivetrain;
	public static Shooter shooter;
	public static OI oi;
	public static FlightRecorder flightRecorder;
	
	public static void init() {
		//drivetrain = new Drivetrain();
		shooter = new Shooter(0, 0, 0); //TODO: Get real values (previously 7, 0, 0.2)
		oi = new OI();
		//flightRecorder = new FlightRecorder();
		//Camera camera = new Camera();
	}
	
	//Never gets called, find a function to put this in
	public static void dispose() {
		flightRecorder.dispose();
	}
	
}
