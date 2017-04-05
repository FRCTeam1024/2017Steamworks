//package org.usfirst.frc.team1024.robot.util;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.usfirst.frc.team1024.robot.Robot;
//
//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
//
//public class Logger {
//	DriverStation driverStation = DriverStation.getInstance();
//	public File logStream = new File("/media/sda1/loggedDataTest1.xlsx");
//	PowerDistributionPanel pdp = new PowerDistributionPanel();
//	Map<String, Object[]> data = new TreeMap<String, Object[]>();
//	public XSSFWorkbook workbook = new XSSFWorkbook();
//	public XSSFSheet sheet = workbook.createSheet("FRC Log");
//
//	public FileOutputStream out;
//	// Coppied code:
//	int numLoops = 6;
//
//	public Logger() {
//
//		try {
//			out = new FileOutputStream(logStream);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		// Blank workbook
//
//		// Create a blank sheet
//
//		// This data needs to be written (Object[])
//
//		data.put("1", new Object[] { "SystemTime", "Alliance", "Position" });
//		data.put("2", new Object[] { getSystemTime(), driverStation.getAlliance().toString(),
//				driverStation.getLocation() });
//		data.put("3", new Object[] {""});
//		data.put("4", new Object[] {""});
//		data.put("5",
//				new Object[] { "MatchTime", "BatteryVoltage", "AValue", "BValue", "XValue", "YValue", "LBumperValue",
//						"RBumper1Value", "LTriggerValue", "RTriggerValue", "LXAxisValue", "RXAxisValue", "LYAxisValue",
//						"RYAxisValue", "Port1Current", "Port2Current", "Port3Current", "Port4Current", "Port5Current",
//						"Port6Current", "Port7Current", "Port8Current", "Port9Current", "Port10Current",
//						"Port11Current", "Port12Current", "Port13Current", "Port14Current", "Port15Current", "" });
//
//		// Iterate over data and write to sheet
//		Set<String> keyset = data.keySet();
//		int rownum = 0;
//		for (String key : keyset) {
//			Row row = sheet.createRow(rownum++);
//			Object[] objArr = data.get(key);
//			int cellnum = 0;
//			for (Object obj : objArr) {
//				Cell cell = row.createCell(cellnum++);
//				if (obj instanceof String) {
//					cell.setCellValue((String) obj);
//				} else if (obj instanceof Integer) {
//					cell.setCellValue((Integer) obj);
//				}
//			}
//		}
//		/*try {
//			// Write the workbook in file system
//			workbook.write(out);
//			//out.close();
//			System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//
//	}
//
//	public void logButtons() {
//
//	}
//
//	public void logOutput() {
//
//	}
//
//	public void logSensors() {
//
//	}
//
//	public void logAll() {
//		data.put("" + numLoops,
//				new Object[] { ""+driverStation.getMatchTime(), ""+driverStation.getBatteryVoltage(), "" + Robot.oi.logi.getRawButton(2), "" + Robot.shooter.shooter.getSpeed()/*,
//						"Robot.oi.getButtonB()", "Robot.oi.getButtonX()", "Robot.oi.getButtonY()", "Robot.oi.getLB()",
//						"Robot.oi.getRB()", "Robot.oi.getLT()", "Robot.oi.getRT()", "Robot.oi.getLXAxis()",
//						"Robot.oi.getRXAxis()", "Robot.oi.getLYAxis()", "Robot.oi.getRYAxis()"*/,""+pdp.getCurrent(12),/*
//						"pdp.getCurrent(2)", "pdp.getCurrent(3)", "pdp.getCurrent(4)", "pdp.getCurrent(5)",
//						"pdp.getCurrent(6)", "pdp.getCurrent(7)", "pdp.getCurrent(8)", "pdp.getCurrent(9)",
//						"pdp.getCurrent(10)", "pdp.getCurrent(11)", "pdp.getCurrent(12)", "pdp.getCurrent(13)",
//						"pdp.getCurrent(14)", "pdp.getCurrent(15)", ""*/});
//		numLoops++;
//		// Iterate over data and write to sheet
//		Set<String> keyset = data.keySet();
//		int rownum = 0;
//		for (String key : keyset) {
//			Row row = sheet.createRow(rownum++);
//			Object[] objArr = data.get(key);
//			int cellnum = 0;
//			for (Object obj : objArr) {
//				Cell cell = row.createCell(cellnum++);
//				if (obj instanceof String) {
//					cell.setCellValue((String) obj);
//				} else if (obj instanceof Integer) {
//					cell.setCellValue((Integer) obj);
//				}
//			}
//		}
//		/*try {
//			// Write the workbook in file system
//			workbook.write(out);
//			out.close();
//			System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}*/
//	}
//
//	public String getTimeStamp() { // I want these in match time format
//									// so we can better diagnose with video
//		String matchTime = driverStation.getMatchTime() + "";
//		return getSystemTime() + " MatchTime: " + matchTime;
//	}
//
//	public String getSystemTime() {
//		String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
//		return timeStamp;
//		// do some integrated time java stuff
//	}
//
//	public String initMatchInfo() {
//		return null;
//		// Current hour: <0-23>
//		// current minutes: <0-59>
//		// current seconds: <0-59>
//		// current milliseconds: <000-999>
//		// Match
//		// Alliance station: <red,blue,null>
//		// Station position: <1,2,3,null>
//
//	}
//
//}
