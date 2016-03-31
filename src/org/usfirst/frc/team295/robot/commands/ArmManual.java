package org.usfirst.frc.team295.robot.commands;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.usfirst.frc.team295.robot.RobotMap;
import org.usfirst.frc.team295.robot.subsystems.Arm;
import org.usfirst.frc.team295.robot.utilities.UtilityFunctions;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArmManual extends Command {
	
	private Arm arm;
	private Joystick operatorJoystick;
	
	public ArmManual() {
		arm = RobotMap.arm;
		operatorJoystick = RobotMap.oi.getOperatorJoystick();
		requires(arm);
	}
	
	@Override
	protected void initialize() {
		arm.setElbowModeSpeed();
	}

	@Override
	protected void execute() {
		//arm.setShoulderAbsolute(-Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(5)), 1) * 30000);
		//arm.setElbowAbsolute(Math.pow(UtilityFunctions.deadband(operatorJoystick.getRawAxis(1)), 3) * 40000);
		
		if(operatorJoystick.getRawButton(3)) {
			arm.setShoulderAbsolute(-15000);
		} else if(operatorJoystick.getRawButton(2)) {
			arm.setShoulderAbsolute(15000);
		} else {
			arm.setShoulderAbsolute(0);
		}
		
		if(operatorJoystick.getRawButton(15)) {
			arm.setElbowAbsolute(20000);
		} else if(operatorJoystick.getRawButton(14)) {
			arm.setElbowAbsolute(-20000);
		} else {
			arm.setElbowAbsolute(0);
		}
		
		/*arm.currentAngleS = operatorJoystick.getRawAxis(0);
		if(arm.currentAngleS > 0.75 && arm.previousAngleS < -0.75) {
			arm.angleS--;
		} else if(arm.currentAngleS < -0.75 && arm.previousAngleS > 0.75) {
			arm.angleS++;
		}
		
		arm.currentAngleE = operatorJoystick.getRawAxis(1);
		if(arm.currentAngleE > 0.75 && arm.previousAngleE < -0.75) {
			arm.angleE--;
		} else if(arm.currentAngleE < -0.75 && arm.previousAngleE > 0.75) {
			arm.angleE++;
		}
		
		arm.setElbowAbsolute((arm.currentAngleS + arm.angleS) * 50000);
		arm.setShoulderAbsolute((arm.currentAngleE + arm.angleE) * 50000);
		
		System.out.println(operatorJoystick.getRawAxis(1) + " " + arm.getShoulderPosition());*/
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		arm.setShoulderAbsolute(0);
		arm.setElbowAbsolute(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
