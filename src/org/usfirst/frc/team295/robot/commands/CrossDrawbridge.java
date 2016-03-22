package org.usfirst.frc.team295.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossDrawbridge extends CommandGroup {

	public CrossDrawbridge() {
		addSequential(new AutoDrive(4, 0.25, 1));
		addSequential(new PIDTurnLeft(180));
	}
}
