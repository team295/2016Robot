package org.usfirst.frc.team295.robot.utilities;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera {

	Image frame;
	
	int currentCamera;
	int shooterCamera;
	int armCamera;
	
	public Camera() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//Find from Roborio web interface         vvvvvv
		shooterCamera = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		//armCamera = NIVision.IMAQdxOpenCamera("cam2", NIVision.IMAQdxCameraControlMode.CameraControlModeController);

		currentCamera = shooterCamera;

		NIVision.IMAQdxConfigureGrab(currentCamera);
	}
	
	public void pushImage() {
		NIVision.IMAQdxGrab(currentCamera, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
	
	public void switchCamera() {
		
	}
	
}
