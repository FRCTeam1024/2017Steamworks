
package org.usfirst.frc.team1024.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1024.robot.commands.auto.Pos1ShootNPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos1ShootSPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos1ShootWPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos2ShootNPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos2ShootSPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos2ShootWPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos3ShootSPeg;
import org.usfirst.frc.team1024.robot.commands.auto.Pos3ShootWPeg;

import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyI2C;
import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.Pixy.PixyPacket;
import org.usfirst.frc.team1024.robot.commands.auto.Pos1Shoot;

// import org.usfirst.frc.team1024.robot.commands.auto.Pos2GearOnMiddlePeg;

import org.usfirst.frc.team1024.robot.subsystems.Blender;
import org.usfirst.frc.team1024.robot.subsystems.Climber;
import org.usfirst.frc.team1024.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1024.robot.subsystems.Gear;
import org.usfirst.frc.team1024.robot.subsystems.Hopper;
import org.usfirst.frc.team1024.robot.subsystems.Shooter;

import com.ctre.CANTalon.TalonControlMode;

import org.usfirst.frc.team1024.robot.subsystems.REVDigitBoard;

/**
 * @author team1024
 * Change Log
 * 1/26/17: 
 */
public class Robot extends IterativeRobot {
	//Might need to make these not final later and move initialization to robotInit()
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter = new Shooter();
	public static final Climber climber = new Climber();
	public static final Blender blender = new Blender();
	public static final Gear gear = new Gear();
	public static final Hopper hopper = new Hopper();
	public static final REVDigitBoard autoChooser = new REVDigitBoard();
	
	public PixyI2C pixy;
	public PixyPacket test;
	public DigitalOutput pixyPower;
	public static int[] pixyValues;
	
	int position = 0;
	String peg = "";
	
	public static OI oi;
	public int autoSelected;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	public boolean shooterSetState = false;

	@Override
	public void robotInit() {
		oi = new OI();
		
		//All Auto underneath shoot before executing their auto
		chooser.addDefault("Position 1, Shoot, West Peg", new Pos1ShootWPeg());
		chooser.addObject("Position 1, Shoot, North Peg", new Pos1ShootNPeg());
		chooser.addObject("Position 1, Shoot, South Peg", new Pos1ShootSPeg());
		chooser.addObject("Position 2, Shoot, West Peg", new Pos2ShootWPeg());
		chooser.addObject("Position 2, Shoot, North Peg", new Pos2ShootNPeg());
		chooser.addObject("Position 2, Shoot, South Peg", new Pos2ShootSPeg());
		chooser.addObject("Position 3, Shoot, West Peg", new Pos3ShootWPeg());
		chooser.addObject("Position3, Shoot, South Peg", new Pos3ShootSPeg());
		
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);
		NetworkTable.globalDeleteAll();
		//shooter.initDashboard();
		//drivetrain.initDashboard();
		SmartDashboard.putBoolean("Logi Drive?", false);
		drivetrain.frontLeftDrive.setEncPosition(0);
		drivetrain.frontRightDrive.setEncPosition(0);
		
		pixyPower = new DigitalOutput(4);
		pixyPower.set(true);
		pixy = new PixyI2C();
		pixyValues = new int[10];
	}
	
	@Override
	public void disabledInit() {
		autoChooser.display("1024");
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//Copied from last year
		if(!autoChooser.getButtonA()){
			autoSelected++;
			Timer.delay(.2);
			while(!autoChooser.getButtonA());
			if(autoSelected > 9) autoSelected = 0;
		}
		if(!autoChooser.getButtonB()){
			/*position++;
			Timer.delay(.2);
			while(!autoChooser.getButtonB());
			if(position > 5) position = 0;*/
		}
		//Wrap around vvv
		/*
		if(autoSelected < 10){
			autoChooser.display("" + autoDelay + position + "0" + autoSelected);
		}else if(autoSelected >= 10){
			autoChooser.display("" + autoDelay + position + autoSelected);
		}else{
			autoChooser.display("NULL");
		}
		autonomousCommand = new StateAndWorldsAuto(autoSelected, position); */

	}
	
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		autonomousCommand = new Pos1Shoot();

		
//		 String autoSelected = SmartDashboard.getString("Auto Selector",
//		 "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
//		 = new MyAutoCommand(); break; case "Default Auto": default:
//		 autonomousCommand = new ExampleCommand(); break; }
		 

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		
		
		SmartDashboard.getNumber("Position:", position);
		SmartDashboard.getString("Peg", peg);
		Robot.drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.Position);
		Robot.drivetrain.frontRightDrive.changeControlMode(TalonControlMode.Position);
		
	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		String finalpeg = peg.toUpperCase();
		
		if (position == 1) {
			if (finalpeg == "N") {
				
				// run pos1pegN auto
			} else if (finalpeg == "S") {
				
				// run pos1pegS auto
			} else if (finalpeg == "W") {
				// run pos1pegW auto
			} else {
				
			}
		} else if (position == 2) {
			if (finalpeg == "N") {
				// run pos2pegN auto
			} else if (finalpeg == "S") {
				// run pos2pegS auto
			} else if (finalpeg == "W") {
				
			} else {
				
			}
		} else if (position == 3) {
			if (finalpeg == "N") {
				// run pos3pegN auto
			} else if (finalpeg == "S") {
				// run pos3pegS auto
			} else if (finalpeg == "W") {
				// run pos3pegW auto
			} else {
				
			}
		} 
	}
	
	
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		shooter.shooter.updateTable();
		drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
		drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//outputTheThings();
		// Drivetrain

		// if (SmartDashboard.getBoolean("Drivetrain GO", false) == true) {
		// } else {
		// if (SmartDashboard.getBoolean("Logi Drive?", true) == true) {
		// drivetrain.drive(-oi.logi.getRawAxis(1), -oi.logi.getRawAxis(3));
		// } else {
		//drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
		drivetrain.drive(-oi.lJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM),
						 -oi.rJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM));
		// Blender
		blender.blend(oi.logi.getRawAxis(1));
		// Climber
		climber.climb(Math.abs(oi.logi.getRawAxis(3)));

		/*
		 * if (oi.logi.getRawButton(4) == true) { gear.push(true); } else if
		 * (oi.logi.getRawButton(4) == false) { gear.push(false); }
		 */
		if (oi.logi.getRawButton(1) == true) {
			gear.clamper.set(Value.kOff);
		}
		if (oi.logi.getPOV() == 0) {
			shooter.shooterSetSpeed += 5.0;
		} else if (oi.logi.getPOV() == 180) {
			shooter.shooterSetSpeed -= 5.0;

		//if (SmartDashboard.getBoolean("Drivetrain GO", false) == true) {
		//} else {
			//if (SmartDashboard.getBoolean("Logi Drive?", true) == true) {
				//drivetrain.drive(-oi.logi.getRawAxis(1), -oi.logi.getRawAxis(3));
			//} else {
		//drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
				drivetrain.drive(-oi.lJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM), oi.rJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM));
				// Blender
				blender.blend(oi.logi.getRawAxis(1));
				hopper.agitator.set(oi.logi.getRawAxis(1));
				hopper.agitate(oi.logi.getRawAxis(1));
				// Climber
				climber.climb(Math.abs(oi.logi.getRawAxis(3)));
			
			/*
			 * if (oi.logi.getRawButton(4) == true) { gear.push(true); } else if
			 * (oi.logi.getRawButton(4) == false) { gear.push(false); }
			 */
			if (oi.logi.getRawButton(1) == true) {
				gear.clamper.set(Value.kOff);
			}
			if (oi.logi.getPOV() == 0) {
				shooter.shooterSetSpeed += 5.0;
			} else if (oi.logi.getPOV() == 180) {
				shooter.shooterSetSpeed -= 5.0;
			}
			if (oi.lJoy.getRawButton(7) || oi.rJoy.getRawButton(7)) {
				drivetrain.shifter.set(false);
			} 
			if (oi.lJoy.getRawButton(10) || oi.rJoy.getRawButton(10)) {
				drivetrain.shifter.set(true);
			}

		}
		
		List<PixyObject> pixyObjectList = getPixyObjects();
		if (pixyObjectList != null) {
			printPixyStuff(pixyObjectList);
			System.out.println("Got " + pixyObjectList.size() + " objects from the pixy");
			//for (int i = 0; i < pixyObjectList.size(); i++) {
			//	DriverStation.reportError(pixyObjectList.get(i).toString(), false);
			//}
		}
	}
	
	public List<PixyObject> getPixyObjects() {
		//pixy values are saved and read like PixyPacket.(x,y,width,height)
		try {
			return pixy.readFrame(1);
		} catch ( Exception e) {
			DriverStation.reportError(e.getMessage(), true);
			// e.printStackTrace();
			return null;
		}
	}
	
	public static void printPixyStuff(List<PixyObject> pol){
		for(int i = 0; i < pol.size(); i++) {
		PixyObject po1 = pol.get(i);
		SmartDashboard.putNumber(String.format("Pixy %1$d X", i), po1.getX());
		SmartDashboard.putNumber(String.format("Pixy %1$d Y", i), po1.getY());
		SmartDashboard.putNumber(String.format("Pixy %1$d Width", i), po1.getWidth());
		SmartDashboard.putNumber(String.format("Pixy %1$d Height", i), po1.getHeight());
		}
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	public void outputTheThings() {
		shooter.outputToSmartDashboard();
		drivetrain.outputToSmartDashboard();
		//gear.outputToSmartDashboard();
		//climber.outputToSmartDashboard();
		//blender.outputToSmartDashboard();
	}
}
