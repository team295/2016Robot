package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterManual extends Command {
	
	private Shooter shooter;
	private Joystick operatorJoystick;
	private double triggerValue;
	
	public ShooterManual() {
		shooter = RobotMap.shooter;
		operatorJoystick = RobotMap.oi.getOperatorJoystick();
		requires(shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		/*if(UtilityFunctions.deadband(triggerValue = operatorJoystick.getRawAxis(2)) > 0) {
			//triggerValue = (triggerValue - 0.5) * 2;
			shooter.setSpeed(-triggerValue, -triggerValue);
		} else if(UtilityFunctions.deadband(triggerValue = operatorJoystick.getRawAxis(3)) > 0) {
			//triggerValue = (triggerValue - 0.5) * 2;
			shooter.setSpeed(triggerValue, triggerValue);
		} else {
			shooter.setSpeed(0, 0);
		}
		//System.out.println(triggerValue);
		
		if(operatorJoystick.getRawButton(5)) {
			shooter.setWedgeSpeed(0.8);
		} else if(operatorJoystick.getRawButton(6)) {
			shooter.setWedgeSpeed(-0.8);
		} else {
			shooter.setWedgeSpeed(0);
		}*/
		
		if(operatorJoystick.getRawButton(10)) {
			shooter.setSpeed(-1, -1);
		} else if(operatorJoystick.getRawButton(13)) {
			shooter.setSpeed(1, 1);
		} else {
			shooter.setSpeed(0, 0);
		}
		
		//shooter.setSpeed(1, 1);
		
		if(operatorJoystick.getRawButton(11)) {
			shooter.angleMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooter.angleMotor.configPeakOutputVoltage(12, -12);
			shooter.angleMotor.setProfile(1);
			shooter.shooterAngle = shooter.getAngleAbsolute();
			if(operatorJoystick.getRawButton(3)) {
				shooter.setAngleAbsolute(4000);
			} else {
				shooter.setAngleAbsolute(10000);
			}
		} else if(operatorJoystick.getRawButton(12)) {
			shooter.angleMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
			shooter.angleMotor.configPeakOutputVoltage(12, -12);
			shooter.angleMotor.setProfile(1);
			shooter.shooterAngle = shooter.getAngleAbsolute();
			if(operatorJoystick.getRawButton(3)) {
				shooter.setAngleAbsolute(-12000);
			} else {
				shooter.setAngleAbsolute(-20000);
			}
		} else {
			shooter.angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
			shooter.angleMotor.configPeakOutputVoltage(12.0, -12.0);
			shooter.angleMotor.setProfile(0);
			shooter.setAngleAbsolute(shooter.shooterAngle / 1.4);
		}
		
		if(operatorJoystick.getRawButton(9)) {
			shooter.setWedgeSpeed(-1);
		} else if(RobotMap.shooter.wedgeSensor.get()) {
			shooter.setWedgeSpeed(0.3);
		} else {
			shooter.setWedgeSpeed(0);
		}
		
//		System.out.println(RobotMap.shooter.wedgeSensor.get());
		
		/*if(operatorJoystick.getRawButton(13)) {
			shooter.setWedgeSpeed(-0.8);
		} else if(!RobotMap.shooter.wedgeSensor.get()) {
			shooter.setWedgeSpeed(0.4);
		} else {
			shooter.setWedgeSpeed(0);
		}*/
 		
		//shooter.setAngleAbsolute(Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(1)), 1) * 30000);
		//shooter.setAngleAbsolute(operatorJoystick.getRawAxis(1) * 500 + shooter.getAngleAbsolute());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
