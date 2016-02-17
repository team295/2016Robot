package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	
	private static final short SHOULDER_PORT = 10;
	private static final short ELBOW_PORT = 11;
	
	public CANTalon shoulder;
	public CANTalon elbow;
	
	public Arm() {
		shoulder = new CANTalon(SHOULDER_PORT);
		shoulder.setProfile(0);
		shoulder.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		shoulder.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		shoulder.configNominalOutputVoltage(+0.0f, -0.0f);
		shoulder.configPeakOutputVoltage(+6.0f, -6.0f);
		shoulder.configEncoderCodesPerRev(1000);
		
		shoulder.setForwardSoftLimit(15);
		shoulder.setReverseSoftLimit(-15);
		shoulder.enableForwardSoftLimit(true);
		shoulder.enableReverseSoftLimit(true);

		shoulder.setF(0.005);
		shoulder.setP(0.02);
		shoulder.setI(0); 
		shoulder.setD(0.01);
		
		elbow = new CANTalon(ELBOW_PORT);
		elbow.setProfile(0);
		elbow.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		elbow.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		elbow.configNominalOutputVoltage(+0.0f, -0.0f);
		elbow.configPeakOutputVoltage(+6.0f, -6.0f);
		elbow.configEncoderCodesPerRev(1000);
		
		elbow.setForwardSoftLimit(15);
		elbow.setReverseSoftLimit(-15);
		elbow.enableForwardSoftLimit(true);
		elbow.enableReverseSoftLimit(true);

		elbow.setF(0.005);
		elbow.setP(0.02);
		elbow.setI(0); 
		elbow.setD(0.01);
	}
	
	public void rotateShoulderAbsolute(double position) {
		shoulder.set(position);
	}
	
	public void rotateShoulderRelative(double amount) {
		shoulder.set(shoulder.getPosition() + amount);
	}
	
	public void rotateElbowAbsolute(double position) {
		elbow.set(position);
	}
	
	public void rotateElbowRelative(double amount) {
		elbow.set(elbow.getPosition() + amount);
	}
	
	public void zeroEncoders() {
		
	}
	
	@Override
	public void initDefaultCommand() {}
	
}

