package org.usfirst.frc.team295.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	public void robotInit() {
		RobotMap.init();
	}

	public void autonomousInit() {
		
	}

	public void autonomousPeriodic() {
		
	}
	
	@Override
	public void teleopInit() {
		
	}
	
	public void teleopPeriodic() {
		RobotMap.oi.processInputs();
	}

	public void testPeriodic() {

	}

}
