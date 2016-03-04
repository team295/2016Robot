package org.usfirst.frc.team295.robot.utilities;

public class UtilityFunctions {
	
	public static final int encoderFinish = 100;
	
	private static final double deadbandValue = 0.025;
	
	public static double deadband(double input) {
		return (Math.abs(input) < deadbandValue) ? 0 : input;
	}
}
