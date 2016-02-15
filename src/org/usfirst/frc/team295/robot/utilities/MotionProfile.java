package org.usfirst.frc.team295.robot.utilities;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.MotionProfileStatus;

public class MotionProfile {

	private CANTalon talon;
	private MotionProfileStatus status;
	
	public MotionProfile(CANTalon talon) {
		this.talon = talon;
		status = new MotionProfileStatus();
	}
	
}
