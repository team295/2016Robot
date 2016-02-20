package org.usfirst.frc.team295.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	CANTalon _talon = new CANTalon(11);
	CANTalon _talon2 = new CANTalon(10);
	Joystick driver = new Joystick(1);
	
	boolean pressedA = false;
	boolean pressedB = false;
	
	boolean isSpeedMode = true;
	
	public void robotInit() {
		RobotMap.init();
	}
	
    @Override
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void teleopInit() {
	}
	
	@Override
	public void testPeriodic() {
		
	}

}