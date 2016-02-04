package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.Commands.DriveTank;
import org.usfirst.frc.team295.robot.Utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	//Speed controller PWM pins, change based on pins
	private static final int SC_BACK_LEFT = 0;
	private static final int SC_FRONT_LEFT = 1;
	private static final int SC_BACK_RIGHT = 2;
	private static final int SC_FRONT_RIGHT = 3;
	
	private VictorSP[] speedControllers;
	private SpeedController[] motors;
	private RobotDrive robotDrive;
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveTank());
	}
	
	public Drivetrain() {
		speedControllers = new VictorSP[4];
		speedControllers[BACK_LEFT] = new VictorSP(SC_BACK_LEFT);
		speedControllers[BACK_RIGHT] = new VictorSP(SC_BACK_RIGHT);
		speedControllers[FRONT_LEFT] = new VictorSP(SC_FRONT_LEFT);
		speedControllers[FRONT_RIGHT] = new VictorSP(SC_FRONT_RIGHT);
		
		motors = new SpeedController[4];
		
		for(int x = 0; x < 4; x++) {
			motors[x] = speedControllers[x];
		}
		
		robotDrive = new RobotDrive(motors[FRONT_LEFT], motors[BACK_LEFT], 
				motors[FRONT_RIGHT], motors[BACK_RIGHT]);
		
		for(SpeedController sc : motors) {
			sc.setInverted(true);
		}
	}
	
	public void setSpeed(double left, double right) {
		robotDrive.setLeftRightMotorOutputs(UtilityFunctions.deadband(left), UtilityFunctions.deadband(right));
	}
	
	public void tankDrive(double left, double right) {
		robotDrive.tankDrive(UtilityFunctions.deadband(left), UtilityFunctions.deadband(right));
	}	
	
	/*public void arcadeDrive(double move, double rotation) {
		robotDrive.arcadeDrive(UtilityFunctions.deadband(move), UtilityFunctions.deadband(-rotation));
	}*/
	
	//Used for motor & speed controller positions, do not change
	private static final int BACK_LEFT = 0;
	private static final int BACK_RIGHT = 1;
	private static final int FRONT_LEFT = 2;
	private static final int FRONT_RIGHT = 3;
	
}
