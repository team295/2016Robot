package org.usfirst.frc.team295.robot;

import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	//CANTalon _talon = new CANTalon(1);
	//CANTalon tal1 = new CANTalon(10);
	//CANTalon tal2 = new CANTalon(11);
	
	public void robotInit() {
		RobotMap.init();
		
		//angleSpeed = RobotMap.shooter.getAngleAbsolute();
		
		//tal1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		//tal1.enable();
		//tal2.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		//tal2.enable();
		
		/*_talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		_talon.changeControlMode(CANTalon.TalonControlMode.Speed);
		_talon.reverseSensor(false);

		_talon.configNominalOutputVoltage(+0.0f, -0.0f);
		_talon.setCloseLoopRampRate(rampRate);
		_talon.configEncoderCodesPerRev(1000);

		_talon.setProfile(0);
		_talon.setF(0.005);
		_talon.setP(0.02);
		_talon.setI(0); 
		_talon.setD(0.01);*/
	}
	
	double angleSpeed;
	boolean justPressed = false;
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
		double rotation = UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(1));
		RobotMap.arm.rotateShoulderRelative(rotation * 0.5);
		
		/*RobotMap.shooter.setSpeed(UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(1)), 
			UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(5)));
		
		/*angleSpeed = 0;
		if(Math.abs((angleSpeed = UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(2)))) > 0) {
			RobotMap.shooter.setAngleSpeed(-angleSpeed * 0.8);
		} else if(Math.abs((angleSpeed = UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(3)))) > 0){
			RobotMap.shooter.setAngleSpeed(angleSpeed * 0.8);
		}*/
		
		/*if(RobotMap.oi.getDriverJoystick().getRawButton(7)) {
			RobotMap.shooter.zeroAngle();
		}
		
		//angleSpeed = 0;
		if(RobotMap.oi.getDriverJoystick().getRawButton(1)) {
			if(!justPressed) {
				RobotMap.shooter.setAngleRelative(10);
				justPressed = true;
			}
		} else {
			justPressed = false;
		}
		
		/*double setPoint = UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(1)) * 1500; 
		_talon.set(setPoint);
		System.out.println(setPoint + " " + _talon.getSpeed() + " " + _talon.getError());*/
		//tal1.set(UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(1))); 
		//TODO: Change algorithm. Cube it!
		//tal2.set(UtilityFunctions.deadband(RobotMap.oi.getDriverJoystick().getRawAxis(5)));
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

