package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;

public class UltrasonicSensors {

	private AnalogInput sensor;
	
	public UltrasonicSensors() {
		sensor = new AnalogInput(3);
	}
	
	public int read() {
		return sensor.getValue();
	}
	
}
