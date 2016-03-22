package org.usfirst.frc.team295.robot.subsystems;


import org.usfirst.frc.team295.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Autonomous extends PIDSubsystem{
	
	
	AHRS ahrs = RobotMap.ahrs;
	public static double direction;
	public double startHeading;
	private double error;
	public Autonomous(){
		super("Drivetrain",.025, .0015, .035);
//		super("Drivetrain" , .02,0,0);
		setAbsoluteTolerance(3);
		getPIDController().setInputRange(0,360);
		getPIDController().setOutputRange(-.5, .5);
		getPIDController().setContinuous(true);
		LiveWindow.addActuator("Drive Base", "PID Controller", getPIDController());
		
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
//		setDefaultCommand(new Logger());
	}
	public void drive(double magnitude, double curve){
		 RobotMap.drivetrain.robotDrive.drive(magnitude, curve);
	}
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return ahrs.getAngle();
	}
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
//		System.out.println(direction);
		if(output<0){
			RobotMap.drivetrain.robotDrive.drive(-output, -1);
		}
		else if(output>0){
			RobotMap.drivetrain.robotDrive.drive(output, 1);
		}
		
		
	}
	public double getYaw(){
		return ahrs.getYaw();
	}
	public double getError() {
		return error;
	}
	public void setError(double error) {
		this.error = error;
	}
	public void disable(){
		RobotMap.drivetrain.drive(0, 0);
	}
	
}
