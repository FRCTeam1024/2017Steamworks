
package org.usfirst.frc.team1024.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1024.robot.commands.ExampleCommand;
import org.usfirst.frc.team1024.robot.subsystems.Blender;
import org.usfirst.frc.team1024.robot.subsystems.Climber;
import org.usfirst.frc.team1024.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1024.robot.subsystems.Gear;
import org.usfirst.frc.team1024.robot.subsystems.Shooter;

/**
 * @author team1024
 * Change Log
 * 1/26/17: 
 */
public class Robot extends IterativeRobot {
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter = new Shooter();
	public static final Climber climber = new Climber();
	public static final Blender blender = new Blender();
	public static final Gear gear = new Gear();
	public static OI oi;
	public static double shooterPower = 0.0; //preset shooter power

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
	}
	
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

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
	}
	
	@Override
	public void teleopPeriodic() {
		boolean Open = true; 
		
		Scheduler.getInstance().run();	 
		
		if (oi.getGearPush() == true) {
			gear.pusher.set(true);
		} else {
			gear.pusher.set(false);
		}
		
		if (oi.getGearClampClose() == true) {
			Open = !Open;
		}
		
		if (Open == true) {
			gear.clamp.set(true);
		} else if (Open == false) {
			gear.clamp.set(false);
		}
		
		/* if (oi.getGearClampClose() == true) {
			gear.clamp.set(true);
			//close gear clamp
		} else if(oi.getGearClampOpen() == true) {
			gear.clamp.set(false);
			//open gear clamp
		} */
		
		if (oi.getShooterSpeedIncrease() == true) {
			shooterPower = shooterPower + 0.001;
		} else if (oi.logi.getDPadWest() == true) {
			shooterPower = shooterPower - 0.001;
		}
		blender.blend(oi.logi.getLeftY());
		climber.climb(Math.abs(oi.logi.getRightY()));
		if (oi.logi.getButtonRT() == true) {
			shooter.shoot(shooterPower);
	  /*} else {
			shooter.shoot(0);
		}
		*/
		}
		
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
