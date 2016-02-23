package org.usfirst.frc.team295.robot.subsystems;

import org.usfirst.frc.team295.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Autonomous extends PIDSubsystem{

	
	AHRS ahrs = RobotMap.ahrs;
	Drivetrain drivetrain = RobotMap.drivetrain;
	public static double direction;
	public Autonomous(){
		super("Autonomous",.025, .0015, .035);
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
		drivetrain.drive(magnitude, curve);
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
			drivetrain.drive(-output, -1);
		}
		else if(output>0){
			drivetrain.drive(output, 1);
		}
		
		
	}
}
