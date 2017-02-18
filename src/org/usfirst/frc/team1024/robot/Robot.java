
package org.usfirst.frc.team1024.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

		/*chooser.addDefault("Default Auto", new GearOnMiddlePeg());
		chooser.addObject("", new command); */

		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		NetworkTable.globalDeleteAll();
		shooter.initDashboard();
		drivetrain.initDashboard();
		SmartDashboard.putBoolean("Logi Drive?", false);
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
		//autonomousCommand = new Pos2GearOnMiddlePeg();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		*/
		
		
		SmartDashboard.getNumber("Position:", position);
		SmartDashboard.getString("Peg", peg);
		
	}
	
	@SuppressWarnings("deprecation")
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
				// run pos2pegW auto
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
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		outputTheThings();
		// Drivetrain
		//if (SmartDashboard.getBoolean("Drivetrain GO", false) == true) {
		//} else {
			//if (SmartDashboard.getBoolean("Logi Drive?", true) == true) {
				//drivetrain.drive(-oi.logi.getRawAxis(1), -oi.logi.getRawAxis(3));
			//} else {
		drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
		drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
				drivetrain.drive(-oi.lJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM),
								 -oi.rJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM));
				// Blender
				blender.blend(oi.logi.getRawAxis(1));
				// Climber
				climber.climb(-Math.abs(oi.logi.getRawAxis(3)));
			
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
