package org.usfirst.frc.team295.robot.commands;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Shooter;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SetShooterAngleAbsolute extends Command {

	private Shooter shooter;

	private double angle;
	private double startTime;
	
	public SetShooterAngleAbsolute(double angle) {
		shooter = RobotMap.shooter;
		requires(shooter);
		this.angle = angle;		
		
	}
	
	@Override
	protected void initialize() {
		startTime = Timer.getFPGATimestamp();
		
		shooter.angleMotor.configPeakOutputVoltage(10, -12); //2.5, -4.4
		shooter.angleMotor.changeControlMode(CANTalon.TalonControlMode.Position);
		shooter.angleMotor.setProfile(0);
	}

	@Override
	protected void execute() {
		shooter.setAngleAbsolute(angle);
		shooter.shooterAngle = shooter.getAngleAbsolute();
	}

	@Override
	protected boolean isFinished() {
		//return true; //TODO: CHANGE
		//return (Timer.getFPGATimestamp()- 2 > startTime);
		//return (Math.abs(RobotMap.shooter.getAngleAbsolute()) - angle < UtilityFunctions.encoderFinish);
		//System.out.println("Not done");
		//return Math.abs(RobotMap.shooter.getAngleAbsolute() - (angle * 1.4)) < UtilityFunctions.encoderFinish;
		return Timer.getFPGATimestamp() - 1.8 >= startTime;
	}

	@Override
	protected void end() {
		//shooter.setAngleRelative(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
