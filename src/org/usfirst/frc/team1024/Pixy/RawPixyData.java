package org.usfirst.frc.team1024.Pixy;

public class RawPixyData {
	byte[] rawData;
	public RawPixyData(byte[] rawData) {
		this.rawData = rawData;
	}
	
	public String toString() {
		String data = "";
		int counter = 0;
		for(int i = 0; i < rawData.length; i +=2) {
			data += doubleByteToInt(rawData[i+1], rawData[i] ) + "|"; 
			counter += 1;
			if(counter % 8 == 0) {
				data += "*****";
				if(counter == 40) {
					counter = 0;
					data += "\n";
				}
			}
		}
		return data;
	}
	
	private int doubleByteToInt(byte upper, byte lower) {
		return (((int)upper & 0xff) << 8) | ((int)lower & 0xff);
	}
}
