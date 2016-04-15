package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.PWM;

public class UltrasonicSensors {

	private PWM sensor;
	
	public UltrasonicSensors() {
		try {
			//sensor = new PWM(8);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int read() {
		return sensor.getRaw();
	}
	
}
