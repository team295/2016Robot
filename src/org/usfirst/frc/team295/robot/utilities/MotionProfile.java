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
	
	public static double[][] generateMotionProfile(double distance, double totalTime, double interval) {
		double maxSpeed = (distance * 3) / (2 * totalTime);
		
		int times = (int)(totalTime / interval - 4);
		double[][] points = new double[times][3];
		
		int offset = 1;
		
		//Very beginning
		points[0][0] = 0;
		points[0][1] = 0;
		points[0][2] = interval;
		
		//First slope
		for(int x = 0; x < times/3; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = (1.0 / (x+1)) * maxSpeed;
			points[x+offset][0] = 0.5 * (x+1) * points[x+offset][1];
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		times -= times/3;
		System.out.println("-----");
		
		for(int x = 0; x < times/2; x++) {
			
		}
		times -= times/2;
		
		for(int x = 0; x < times; x++) {
			
		}
		
		return points;
	}
	
	private class PeriodicRunnable implements Runnable {
		@Override
		public void run() {
			talon.processMotionProfileBuffer();
		}
	}
	
}
