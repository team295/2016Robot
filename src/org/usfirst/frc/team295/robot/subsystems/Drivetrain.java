package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.commands.DriveTank;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {
	
	//Speed controller PWM pins, change based on pins
	private static final short BACK_LEFT_PORT = 2;
	private static final short FRONT_LEFT_PORT = 1;
	private static final short BACK_RIGHT_PORT = 4;
	private static final short FRONT_RIGHT_PORT = 3;

	public static VictorSP victorLeftBack;
	public static VictorSP victorLeftFront;
	public static VictorSP victorRightFront;
	public static VictorSP victorRightBack;
	
	private VictorSP[] speedControllers;
	private SpeedController[] motors;
	public RobotDrive robotDrive;
	private int direction = 1; //1 = arm front; -1 = shooter front
	
	@Override
	protected void initDefaultCommand() {
//		setDefaultCommand(new DriveTank());
	}
	
	public Drivetrain() {
		victorLeftBack = new VictorSP(BACK_LEFT_PORT);
    	victorLeftFront = new VictorSP(FRONT_LEFT_PORT);
    	victorRightFront = new VictorSP(FRONT_RIGHT_PORT);
    	victorRightBack = new VictorSP(BACK_RIGHT_PORT);
    	robotDrive = new RobotDrive(
    	        	victorLeftBack,
    	        	victorLeftFront,
    	        	victorRightFront,
    	        	victorRightBack
    	  		); 
    	robotDrive.setSafetyEnabled(false);
//		speedControllers = new VictorSP[4];
//		speedControllers[BACK_LEFT] = new VictorSP(BACK_LEFT_PORT);
//		speedControllers[BACK_RIGHT] = new VictorSP(BACK_RIGHT_PORT);
//		speedControllers[FRONT_LEFT] = new VictorSP(FRONT_LEFT_PORT);
//		speedControllers[FRONT_RIGHT] = new VictorSP(FRONT_RIGHT_PORT);
//		
//		motors = new SpeedController[4];
//		
//		for(int x = 0; x < 4; x++) {
//			motors[x] = speedControllers[x];
//		}
//		
//		robotDrive = new RobotDrive(motors[FRONT_LEFT], motors[BACK_LEFT], 
//				motors[FRONT_RIGHT], motors[BACK_RIGHT]);
		
//		for(SpeedController sc : motors) {
//			sc.setInverted(true);
//		}
	}
	
	public void setSpeed(double left, double right) {
		robotDrive.setLeftRightMotorOutputs(UtilityFunctions.deadband(left), UtilityFunctions.deadband(right));
	}
	
	public void tankDrive(double left, double right) {
		if(direction == -1) {
			robotDrive.tankDrive(direction * UtilityFunctions.deadband(right), direction * UtilityFunctions.deadband(left));
		} else {
			robotDrive.tankDrive(direction * UtilityFunctions.deadband(left), direction * UtilityFunctions.deadband(right));
		}
	}	
	
	public void drive(double magnitiude, double curve){
		robotDrive.drive(magnitiude, curve);
	}
	
	public void arcadeDrive(double move, double rotation) {
		robotDrive.arcadeDrive(UtilityFunctions.deadband(move), UtilityFunctions.deadband(-rotation));
	}
	public void setDirection(int direction){
		this.direction = direction;
	}
	public double getDirection(){
		return this.direction;
	}
	//Used as constants for motor & speed controller positions, do not change
	private static final short BACK_LEFT = 0;
	private static final short BACK_RIGHT = 1;
	private static final short FRONT_LEFT = 2;
	private static final short FRONT_RIGHT = 3;
	
}
