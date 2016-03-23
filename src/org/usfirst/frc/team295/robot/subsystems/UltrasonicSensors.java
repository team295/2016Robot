package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;

public class UltrasonicSensors {

	private DigitalInput sensor;
	
	public UltrasonicSensors() {
		//sensor = new DigitalInput(0)
	}
	
	public boolean read() {
		return true;//sensor.get();
	}
	
}
