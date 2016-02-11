package org.usfirst.frc.team295.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	CANTalon rightShooter = new CANTalon(15);
	
	int x = 0;
	
	@Override
	public void robotInit() {
		//RobotMap.init();
		rightShooter.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightShooter.configNominalOutputVoltage(0, 0);
		rightShooter.configPeakOutputVoltage(+12f, -12f);

		rightShooter.reverseSensor(true);
		rightShooter.setProfile(0);
		rightShooter.setF(0.2);
		rightShooter.setP(0.2);
		rightShooter.setI(0);
		rightShooter.setD(1);
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
	public void teleopPeriodic() {
		//Scheduler.getInstance().run();
		
		rightShooter.set(0.05);
		
		if((x++) % 10 == 0) {
			x-= 10;
			System.out.println(rightShooter.getEncPosition() + " | " +
					rightShooter.getClosedLoopError() + " | " +
					rightShooter.getOutputVoltage() + " | " +
					rightShooter.getOutputCurrent() + " | " +
					rightShooter.getSpeed());
		}
	}
	
	@Override
	public void testPeriodic() {

	}

}
