package org.usfirst.frc.team1024.Pixy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
/**
 * 
 * @author 2B || !2B from https://www.chiefdelphi.com/forums/showpost.php?p=1443536&postcount=7
 * This class stores values into the PixyPacket class through the Serial port on the RoboRIO
 */
//Warning: if the pixy is plugged in through mini usb, this code WILL NOT WORK b/c the pixy is smart and detects where it should send data
public class PixyI2C{
	
	// 30 bytes works for when we are expecting 2 objects;
	// if we read 64, the next frame might be in the latter half of those 64 bytes,
	// and then we'll lose that frame, and the next read will be in the middle of that frame`
	
	// what happens when there's only 1 object and we read 30 bytes?
	final int BYTES_TO_READ = 30; 
	final int SYNCWORD = 0xaa55;

	
	I2C pixy;
	Port port = Port.kOnboard; //
	public PixyI2C() {
		pixy = new I2C(port, 0x54); //this initializes the I2C interface to accept data
	}
	
	//This method parses raw data from the pixy into readable integers
	private int doubleByteToInt(byte upper, byte lower) {
		return (((int)upper & 0xff) << 8) | ((int)lower & 0xff);
	}

	//This method gathers data, then parses that data	
	public List<PixyObject> readFrame(int signature) throws Exception { //The signature should be which number object in 

		ArrayList<PixyObject> pixyObjectList = new ArrayList<PixyObject>();
		byte[] rawData = new byte[BYTES_TO_READ];
		try{
			pixy.readOnly(rawData, BYTES_TO_READ);
			RawPixyData rpd = new RawPixyData(rawData);
			System.out.println("Raw Data: " + rpd.toString());
		} catch (RuntimeException e){
			throw new PixyException("pixy read failure");
		}
		if(rawData.length < BYTES_TO_READ){
			DriverStation.reportError("pixy stream to small", false);
			throw new PixyException("pixy stream to small ???");
		}
		for (int i = 0; i <= BYTES_TO_READ - 13; i++) {
			int firstWord = doubleByteToInt(rawData[i+1], rawData[i+0]); //Parse first 2 bytes
			System.out.println("first word: " + firstWord + " at i = " + Integer.toString(i));
			if (firstWord == SYNCWORD) {
				System.out.println("found SyncWord");
				int secondWord = doubleByteToInt(rawData[i+3], rawData[i+2]); //Parse next 2 bytes
				int pixyObjectStart = i + 2;
				int pixyObjectEnd = i + 14;
				if (secondWord == SYNCWORD) {
					System.out.println("found SyncWord #2");
					pixyObjectStart += 2;
					pixyObjectEnd += 2;
				}
				PixyObject pixyObject = new PixyObject(Arrays.copyOfRange(rawData, pixyObjectStart, pixyObjectEnd));
			    System.out.println("pixyObject created: " + pixyObject);
	
				if(pixyObject.isValid() ) {
					System.out.println("pixyObject is valid");
					if(pixyObject.signature == signature) {
						System.out.println("pixyObject is the right signature");
						pixyObjectList.add(pixyObject);
						i += 15; //was 16 changed because we get 1 more at the end of the loop
					}
				}
			}
		}
		Collections.sort(pixyObjectList, new PixyObjectComparator());
		return pixyObjectList;
	}
	
	// do this so the left object is always the first object
	class PixyObjectComparator implements Comparator<PixyObject> {
		
		//return -1 for less than, 0 for equals, and 1 for more than
		@Override
		public int compare(PixyObject object1, PixyObject object2) {
			if(object1.getX() == object2.getX()) {
				return object1.getY() < object2.getY() ? -1 : 1;
			} else {
				return object1.getX() < object2.getX() ? -1 : 1;
			}
		}
	}
}