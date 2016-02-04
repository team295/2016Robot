package org.usfirst.frc.team295.robot.Utilities;

import java.io.FileWriter;

public class FlightRecorder {

	private static final String filename = "/home/lvuser/frc/PID.txt";
	
	private FileWriter fstream;
	
	public FlightRecorder() {
		try {
			fstream = new FileWriter(filename);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void write(String input) {
		try {
			fstream.write(input + "\n");
			fstream.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() {
		try {
			fstream.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
