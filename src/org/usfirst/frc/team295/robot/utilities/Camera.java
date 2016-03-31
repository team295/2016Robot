package org.usfirst.frc.team295.robot.utilities;

import org.usfirst.frc.team295.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

public class Camera {
	
	CameraServer shooterCamera;
	int armCamera;
//	public USBCamera cameraFront;
//	public USBCamera cameraBack;
	boolean direction = true;
	
	int currSession;
	int sessionfront;
	int sessionback;
	Image frame;    
	
	public Camera() {        
		//cameraDirection = true; //front = true || back = false
		//cameraFront =  NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//		cameraFront.openCamera();
//		cameraFront.setFPS(20);
//		cameraFront.updateSettings();
//		cameraFront.startCapture();
		
		//cameraBack = new USBCamera("cam2");
//		cameraBack.openCamera();
//		cameraBack.setFPS(20);
//		cameraBack.updateSettings();frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//		sessionfront = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		sessionback = NIVision.IMAQdxOpenCamera("cam2", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		currSession = sessionback;
		NIVision.IMAQdxConfigureGrab(currSession); 
	}
	
	public void loop() {
//		if(RobotMap.oi.getDriverJoystick().getRawButton(1)){
//			direction = !direction;
//		    if(direction){
//		        NIVision.IMAQdxStopAcquisition(currSession);
//		        currSession = sessionfront;
//		        NIVision.IMAQdxConfigureGrab(currSession);
//		    }else{
//		        NIVision.IMAQdxStopAcquisition(currSession);
//		        currSession = sessionback;
//		        NIVision.IMAQdxConfigureGrab(currSession);
//		    }
//		}
		
		NIVision.IMAQdxGrab(currSession, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
	
}
