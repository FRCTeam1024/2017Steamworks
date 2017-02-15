
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

import org.usfirst.frc.team1024.robot.commands.auto.Pos2GearOnMiddlePeg;
import org.usfirst.frc.team1024.robot.subsystems.Blender;
import org.usfirst.frc.team1024.robot.subsystems.Climber;
import org.usfirst.frc.team1024.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1024.robot.subsystems.Gear;
import org.usfirst.frc.team1024.robot.subsystems.Shooter;
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
	public static final REVDigitBoard autoChooser = new REVDigitBoard();
	
	public static OI oi;
	public int autoSelected;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new Pos2GearOnMiddlePeg());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		NetworkTable.globalDeleteAll();
		shooter.initDashboard();
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
		autonomousCommand = new Pos2GearOnMiddlePeg();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
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
		//Blender
		blender.blend(oi.logi.getRawAxis(1));
		//Climber
		climber.climb(-Math.abs(oi.logi.getRawAxis(3)));
		//Drivetrain
		drivetrain.drive(-oi.lJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM),
						 -oi.rJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM));
		/*if (oi.logi.getRawButton(4) == true) {
			gear.push(true);
		} else if (oi.logi.getRawButton(4) == false) {
			gear.push(false);
		}*/
		if (oi.logi.getRawButton(1) == true) {
			gear.clamper.set(Value.kOff);
		}
		shooter.outputToSmartDashboard();
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
