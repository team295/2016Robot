package org.usfirst.frc.team295.robot.utilities;

public class UtilityFunctions {
	
	private static final double deadbandValue = 0.20;
	
	public static double deadband(double input) {
		return (Math.abs(input) < deadbandValue) ? 0 : input;
	}
	
}
