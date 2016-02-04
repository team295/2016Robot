package org.usfirst.frc.team295.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Shooter extends PIDSubsystem {

	public Shooter(double p, double i, double d) {
		super(p, i, d);
	}

	public void initDefaultCommand() {
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}

