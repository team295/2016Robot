package org.usfirst.frc.team295.robot.utilities;

import org.usfirst.frc.team295.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Camera {
	
	CameraServer shooterCamera;
	int armCamera;
	public USBCamera cameraFront;
	public USBCamera cameraBack;
	boolean cameraDirection;
	public Camera() {        
		cameraDirection = true; //front = true || back = false
//		cameraFront = new USBCamera("cam0");
//		cameraFront.openCamera();
//		cameraFront.setFPS(30);
//		cameraFront.updateSettings();
//		cameraFront.startCapture();
		
//		cameraBack = new USBCamera("cam1");
//		cameraBack.openCamera();
//		cameraBack.setFPS(30);
//		cameraBack.updateSettings();
		
		
	}
	
}
