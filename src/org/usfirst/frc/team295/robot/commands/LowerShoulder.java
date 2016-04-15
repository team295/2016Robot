package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LowerShoulder extends Command {

	private Arm arm;

	//private double angle;
	private double startTime;
	
	public LowerShoulder(double angle) {
		arm = RobotMap.arm;
		requires(arm);
		//this.angle = angle;		
		
	}
	
	@Override
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		
		arm.shoulder.configPeakOutputVoltage(5, -2.5); //2.5, -4.4
		arm.shoulder.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}

	@Override
	protected void execute() {
		arm.setShoulderAbsolute(0.4);
	}

	@Override
	protected boolean isFinished() {
		//return true; //TODO: CHANGE
		//return (Timer.getFPGATimestamp()- 2 > startTime);
		//return (Math.abs(RobotMap.shooter.getAngleAbsolute()) - angle < UtilityFunctions.encoderFinish);
		//System.out.println("Not done");
		//return Math.abs(RobotMap.shooter.getAngleAbsolute() - (angle * 1.4)) < UtilityFunctions.encoderFinish;
		return Timer.getFPGATimestamp() - 3 >= startTime;
	}

	@Override
	protected void end() {
		arm.shoulder.configPeakOutputVoltage(12f, -12f); //2.5, -4.4
		arm.shoulder.changeControlMode(CANTalon.TalonControlMode.Speed);
		arm.shoulder.setProfile(1);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
