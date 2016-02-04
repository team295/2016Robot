package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.Utilities.FlightRecorder;
import org.usfirst.frc.team295.robot.subsystems.Drivetrain;
import org.usfirst.frc.team295.robot.subsystems.OI;

public class RobotMap {

	public static Drivetrain drivetrain;
	public static OI oi;
	public static FlightRecorder flightRecorder;
	
	public static void init() {
		drivetrain = new Drivetrain();
		oi = new OI();
		flightRecorder = new FlightRecorder();
	}
	
}
