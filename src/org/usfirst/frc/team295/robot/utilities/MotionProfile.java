package org.usfirst.frc.team295.robot.utilities;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.MotionProfileStatus;
import edu.wpi.first.wpilibj.CANTalon.TrajectoryPoint;
import edu.wpi.first.wpilibj.Notifier;

public class MotionProfile {

	private CANTalon talon;
	private MotionProfileStatus status;
	private Notifier notifier;
	
	public MotionProfile(CANTalon talon, double[][] points) {
		this.talon = talon;
		status = new MotionProfileStatus();
		notifier = new Notifier(new PeriodicRunnable());
		fillBuffer(points);
		
		talon.changeMotionControlFramePeriod(5);
		notifier.startPeriodic(0.005);
	}
	
	public void reset() {
		talon.clearMotionProfileTrajectories();
	}
	
	public void fillBuffer(double[][] points) {
		reset();
		
		TrajectoryPoint point = new TrajectoryPoint();
		
		for(int x = 0; x < points.length; x++) {
			point.position = points[x][0];
			point.velocity = points[x][1];
			point.timeDurMs = (int)points[x][2];
			
			point.profileSlotSelect = 0;
			point.velocityOnly = false;
			point.zeroPos = false;

			if(x == points.length - 1) {
				point.isLastPoint = true;
			}
			talon.pushMotionProfileTrajectory(point);
		}
	}
	
	//public static double[][] generateMotionProfile(int time) {
		
	//}
	
	private class PeriodicRunnable implements Runnable {
		@Override
		public void run() {
			talon.processMotionProfileBuffer();
		}
	}
	
}
