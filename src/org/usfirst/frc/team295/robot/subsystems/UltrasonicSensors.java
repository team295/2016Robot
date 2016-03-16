package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.I2C;

public class UltrasonicSensors {

	private I2C i2c;
	private AnalogInput analogInput;
	
	public UltrasonicSensors() {
		//i2c = new I2C(I2C.Port.kOnboard, 0x1E);
		//analogInput = new AnalogInput(3);
	}
	
	public void read() {
		//System.out.println(analogInput.getAverageValue());
	}
	
}
