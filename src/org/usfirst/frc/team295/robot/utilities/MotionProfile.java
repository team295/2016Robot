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
	
	//WARNING: totalPoints is bugged, only works when it's a multiple of 3, starting from 10 (ex. 10, 13, 16...)
	public static double[][] generateMotionProfile(double distance, double totalTime, int totalPoints) {
		double maxSpeed = (distance * 3) / (2 * totalTime);
		 
		int tempPoints = (int) (totalPoints - 4);
		double interval = (double)totalTime / (totalPoints-1.0);
		System.out.println(tempPoints);
		
		double[][] points = new double[totalPoints][3];
		
		int offset = 1;
		
		//First point at base
		points[0][0] = 0;
		points[0][1] = 0;
		points[0][2] = 0.1;
		
		System.out.println(points[0][0] + " " + points[0][1] + " " + points[0][2]);
		System.out.println("-----");
		
		//First slope
		for(int x = 0; x < tempPoints/3; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = (interval * (x+1) * maxSpeed / (totalTime / 3.0));
			points[x+offset][0] = 0.5 * points[x+offset][1] * interval * (x+1);
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		
		//First high vertex
		points[tempPoints/3 + 1][2] = interval; 
		points[tempPoints/3 + 1][1] = maxSpeed;
		points[tempPoints/3 + 1][0] = 0.5 * totalTime / 3.0 * maxSpeed;
		
		System.out.println("-----");
		System.out.println(points[tempPoints/3 + 1][0] + " " + points[tempPoints/3 + 1][1] + " " + points[tempPoints/3 + 1][2]);
		
		offset += tempPoints/3 + 1;
		tempPoints -= tempPoints/3;
		System.out.println("-----");
		
		//Constant velocity
		for(int x = 0; x < tempPoints/2 + 1; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = maxSpeed;
			points[x+offset][0] = points[x+offset-1][0] + maxSpeed * interval;
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		offset += tempPoints/2 + 1;
		tempPoints -= tempPoints/2;
		
		System.out.println("-----");
		
		for(int x = 0; x < tempPoints + 1; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = (maxSpeed + -interval * (x+1) * maxSpeed / (totalTime / 3.0));
			points[x+offset][0] = points[(totalPoints-4)/3 + (totalPoints-4)/3 + 2][0] + 0.5 * (maxSpeed + points[x+offset][1]) * interval * (x+1);
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
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
/*	//WARNING: totalPoints is bugged, only works when it's a multiple of 3, starting from 10 (ex. 10, 13, 16...)
	public static double[][] generateMotionProfile(double distance, double totalTime, int totalPoints) {
		double maxSpeed = (distance * 3) / (2 * totalTime);
		 
		int tempPoints = (int) (totalPoints - 4);
		double interval = (double)totalTime / (totalPoints-1.0);
		System.out.println(tempPoints);
		
		double[][] points = new double[totalPoints][3];
		
		int offset = 1;
		
		//First point at base
		points[0][0] = 0;
		points[0][1] = 0;
		points[0][2] = 0.1;
		
		System.out.println(points[0][0] + " " + points[0][1] + " " + points[0][2]);
		System.out.println("-----");
		
		//First slope
		for(int x = 0; x < tempPoints/3; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = (interval * (x+1) * maxSpeed / (totalTime / 3));
			points[x+offset][0] = 0.5 * points[x+offset][1] * interval * (x+1);
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		
		//First high vertex
		points[tempPoints/3 + 1][2] = interval; 
		points[tempPoints/3 + 1][1] = maxSpeed;
		points[tempPoints/3 + 1][0] = 0.5 * totalTime / 3.0 * maxSpeed;
		
		System.out.println("-----");
		System.out.println(points[tempPoints/3 + 1][0] + " " + points[tempPoints/3 + 1][1] + " " + points[tempPoints/3 + 1][2]);
		
		offset += tempPoints/3 + 1;
		tempPoints -= tempPoints/3;
		System.out.println("-----");
		
		//Constant velocity
		for(int x = 0; x < tempPoints/2 + 1; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = maxSpeed;
			points[x+offset][0] = points[x+offset-1][0] + maxSpeed * interval;
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		offset += tempPoints/2 + 1;
		tempPoints -= tempPoints/2;
		
		System.out.println("-----");
		
		for(int x = 0; x < tempPoints + 1; x++) {
			points[x+offset][2] = interval;
			points[x+offset][1] = (maxSpeed + -interval * (x+1) * maxSpeed / (totalTime / 3.0));
			points[x+offset][0] = points[(totalPoints-4)/3 + (totalPoints-4)/3 + 2][0] + 0.5 * (maxSpeed + points[x+offset][1]) * interval * (x+1);
			System.out.println(points[x+offset][0] + " " + points[x+offset][1] + " " + points[x+offset][2]);
		}
		
		return points;
	}
	*/
