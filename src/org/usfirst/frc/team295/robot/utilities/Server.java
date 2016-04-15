package org.usfirst.frc.team295.robot.utilities;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.CharBuffer;

import org.usfirst.frc.team295.robot.RobotMap;

public class Server implements Runnable{
	Socket s;
	ServerSocket server;
	int increment = 0;
	String delimiter = ";";
	double angle;
	public Server(ServerSocket s){
		server = s;
	}
	int i ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				Socket s = server.accept();
//				if(s.isConnected()){
//					RobotMap.clientSocket = s;
//					RobotMap.clientConnected = true;
//				}
//				
				DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());
				do{
			//	//				dataOutputStream.writeChars("bearing"+delimiter+RobotMap.ahrs.getAngle()+ delimiter +
//						"shooter" + delimiter + RobotMap.shooter.getAngleAbsolute() + delimiter + "arm1" + delimiter+ RobotMap.arm.currentAngleS
//						+ delimiter + "arm2" + delimiter + RobotMap.arm.currentAngleE + delimiter + "chassis" + delimiter+ RobotMap.ahrs.getPitch() + delimiter);
				i++;
				angle = RobotMap.ahrs.getAngle();
				dataOutputStream.writeUTF(Double.toString(RobotMap.ahrs.getAngle()) + delimiter);

				System.out.println("Sent Line : " + i + " : " + angle);
				Thread.sleep(100);
				}while(s.isConnected());
				
				s.close();
				System.out.println("Sent Line");
					
				System.out.println("Socket Closed ");
				
				
				
			}catch (SocketTimeoutException s){
				System.out.println("Timed Out");
				break;
			}
			catch(IOException e){
				System.out.println("Client Closed");
				e.printStackTrace();
//				break;
			}
			catch(Exception e){
				System.out.println("Was not able to Read");
				e.printStackTrace();
			}
			
		}
	}

}
