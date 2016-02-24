package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.ArmManual;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	
	private static final short SHOULDER_PORT = 10;
	private static final short ELBOW_PORT = 11;

	public static final double P_ONE  = 10000 / 1.4; //-30000
	public static final double P_TWO = -10000 / 1.4; //-250000
	public static final double P_THREE  = 75000 / 1.4;
	public static final double P_FOUR  = 190000 / 1.4;
	
	public CANTalon shoulder;
	private CANTalon elbow;

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ArmManual());
	}
	
	public Arm() {
		shoulder = new CANTalon(SHOULDER_PORT);
		shoulder.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		shoulder.changeControlMode(CANTalon.TalonControlMode.Speed);

		shoulder.configNominalOutputVoltage(+0.0f, -0.0f);
		shoulder.configPeakOutputVoltage(+12.0f, -12.0f);
		shoulder.enableForwardSoftLimit(false);
		shoulder.enableReverseSoftLimit(false);
		//_talon.reverseOutput(true);
		//_talon.configEncoderCodesPerRev(1000);

		shoulder.setProfile(0); //Position
		shoulder.setF(0.1);
		shoulder.setP(0.25);
		shoulder.setI(0);
		shoulder.setD(3.2);
		shoulder.reverseSensor(false);
		shoulder.reverseOutput(true);
		
		shoulder.setProfile(1); //Speed
		shoulder.setF(0.005);
		shoulder.setP(0.02);
		shoulder.setI(0); 
		shoulder.setD(0.01);
		shoulder.reverseSensor(false);
		shoulder.reverseOutput(false);
		
		shoulder.setEncPosition(0);
		shoulder.enable();
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			
		}
		
		elbow = new CANTalon(ELBOW_PORT);
		elbow.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		elbow.changeControlMode(CANTalon.TalonControlMode.Speed);
		elbow.reverseSensor(false);

		elbow.configNominalOutputVoltage(+0.0f, -0.0f);
		elbow.configPeakOutputVoltage(+12.0f, -12.0f);
		//_talon.reverseOutput(true);
		//_talon.configEncoderCodesPerRev(1000);

		elbow.setProfile(0); //Position
		elbow.setF(0.1);
		elbow.setP(0.25);
		elbow.setI(0);
		elbow.setD(3.2);
		
		elbow.setProfile(1); //Speed
		elbow.setF(0.005);
		elbow.setP(0.02);
		elbow.setI(0); 
		elbow.setD(0.01);
		
		elbow.setEncPosition(0);
		elbow.enable();
		try {
			Thread.sleep(100);
		} catch(Exception e) {
			
		}
	}
	
	public void setElbowModePosition() {
		elbow.changeControlMode(CANTalon.TalonControlMode.Position);
		elbow.configPeakOutputVoltage(3, -3);
		elbow.setProfile(0);
		elbow.set(elbow.getPosition() / 1.4);
	}
	
	public void setElbowModeSpeed() {
		elbow.changeControlMode(CANTalon.TalonControlMode.Speed);
		elbow.configPeakOutputVoltage(12, -12);
		elbow.setProfile(1);
	}
	
	public void setShoulderModePosition() {
		shoulder.changeControlMode(CANTalon.TalonControlMode.Position);
		shoulder.configPeakOutputVoltage(8, -8);
		shoulder.setProfile(0);
		shoulder.reverseSensor(false);
		shoulder.reverseOutput(true);
		//shoulder.set(elbow.getPosition() / 1.4);
	}
	
	public void setShoulderModeSpeed() {
		shoulder.changeControlMode(CANTalon.TalonControlMode.Speed);
		shoulder.configPeakOutputVoltage(12, -12);
		shoulder.setProfile(1);
	}
	
	public void setShoulderAbsolute(double position) {
		shoulder.set(position);
	}
	
	public void rotateShoulderRelative(double amount) {
		shoulder.set(shoulder.getPosition() + amount);
	}
	
	public void setElbowAbsolute(double position) {
		elbow.set(position);
	}
	
	public void rotateElbowRelative(double amount) {
		elbow.set(elbow.getPosition() + amount);
	}
	
	public double getElbowPosition() {
		return elbow.getPosition();
	}
	
	public double getShoulderPosition() {
		return shoulder.getPosition();
	}
	
	public void zeroEncoders() {
		
	}	
}

