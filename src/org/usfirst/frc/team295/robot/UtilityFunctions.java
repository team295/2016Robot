package org.usfirst.frc.team295.robot;

public class UtilityFunctions {
	
	private static final double deadbandValue = 0.15;
	
	public static double deadband(double input) {
		return (Math.abs(input) < deadbandValue) ? 0 : input;
	}
	
}
