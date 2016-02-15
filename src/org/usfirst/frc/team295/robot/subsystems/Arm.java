package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	
	private static final short SHOULDER_PORT = 10;
	private static final short ELBOW_PORT = 11;
	
	private CANTalon shoulder;
	private CANTalon elbow;
	
	public Arm() {
		shoulder = new CANTalon(SHOULDER_PORT);
		shoulder.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		//shoulder.setPID(7, 0, 0.2); //TODO: Get real values
		
		elbow = new CANTalon(ELBOW_PORT);
		elbow.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		//elbow.setPID(7, 0, 0.2); //TODO: Get real values
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

