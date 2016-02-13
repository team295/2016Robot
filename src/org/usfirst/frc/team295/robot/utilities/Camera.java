package org.usfirst.frc.team295.robot.utilities;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
	
	CameraServer shooterCamera;
	int armCamera;
	
	public Camera() {        
		shooterCamera = CameraServer.getInstance();
		shooterCamera.setQuality(50);
		shooterCamera.startAutomaticCapture("cam0");
	}
	
}
