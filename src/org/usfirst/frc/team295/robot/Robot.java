package org.usfirst.frc.team295.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	
	CANTalon _talon = new CANTalon(1);
	
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

/*package org.usfirst.frc.team295.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {

	
	public static final double P_ONE  = -170000 / 1.4;
	public static final double P_TWO = -95000 / 1.4;
	public static final double P_THREE  = 75000 / 1.4;
	public static final double P_FOUR  = 190000 / 1.4;
	
	CANTalon _talon = new CANTalon(11);
	Joystick driver = new Joystick(0);
	
	public void robotInit() {

	}
	
	boolean pressedA = false;
	boolean pressedB = false;
	
	boolean isSpeedMode = true;
	
	@Override
	public void teleopPeriodic() {	
		
		if(driver.getRawButton(5)) {
			if(!pressedA) {
				System.out.println("Button A pressed");
				pressedA = true;
				_talon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
				_talon.configPeakOutputVoltage(12, -12);
				isSpeedMode = true;
				_talon.setProfile(1);
				System.out.printf("P: %f | I: %f | D: %f\n", _talon.getP(), _talon.getI(), _talon.getD());
    		}
		} else {
			pressedA = false;
		}
		
		if(driver.getRawButton(6)) {
			if(!pressedB) {
				System.out.println("Button B pressed");
				isSpeedMode = false;
				pressedB = true;
				_talon.changeControlMode(CANTalon.TalonControlMode.Position);
				_talon.configPeakOutputVoltage(3, -3);
				_talon.setProfile(0);
				double value = _talon.getPosition() / 1.4;
				System.out.println("Position: " + value);
				_talon.set(value);
				System.out.printf("P: %f | I: %f | D: %f\n", _talon.getP(), _talon.getI(), _talon.getD());
    		}
		} else {
			pressedB = false;
		}
		
		System.out.println(_talon.getPosition() + " " + _talon.getSetpoint());
		
		if(isSpeedMode) {
			_talon.set(deadband(driver.getRawAxis(1))); //* 80000);
		} else {
			if(driver.getRawButton(1)) {
				_talon.set(P_ONE);
			} else if(driver.getRawButton(2)) {
				_talon.set(P_TWO);
			} else if(driver.getRawButton(3)) {
				_talon.set(P_THREE);
			} else if(driver.getRawButton(4)) {
				_talon.set(P_FOUR);
			}
		}
		//_talon.set(setPoint);
		//System.out.println(setPoint + " " + _talon.getSpeed() + " " + _talon.getError());
		//System.out.println(_talon.getOutputVoltage());
	}
	
	public double deadband(double input) {
		return (Math.abs(input) < 0.15) ? 0 : input;
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {

	}
	
	@Override
	public void teleopInit() {		
		_talon.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		_talon.changeControlMode(CANTalon.TalonControlMode.Speed);
		_talon.reverseSensor(false);

		_talon.configNominalOutputVoltage(+0.0f, -0.0f);
		_talon.configPeakOutputVoltage(+12.0f, -12.0f);
		//_talon.reverseOutput(true);
		//_talon.configEncoderCodesPerRev(1000);

		_talon.setProfile(0); //Position
		_talon.setF(0.1);
		_talon.setP(0.25);
		_talon.setI(0);
		_talon.setD(3.2);
		
		_talon.setProfile(1); //Speed
		_talon.setF(0.005);
		_talon.setP(0.02);
		_talon.setI(0); 
		_talon.setD(0.01);
		
		
		_talon.setEncPosition(0);
		_talon.enable();
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			
		}
	}
	
	@Override
	public void testPeriodic() {
		
	}

}
*/
