package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Change Log:
 * 1/26/17: added shooter motor and Livewindow stuff
 * 1/28/2017: Added displayRPM, shoot, and preset shoot commands
 */
public class Shooter implements Subsystem {
    public final CANTalon shooter        = new CANTalon(RobotMap.SHOOTER_PORT);
	public Shooter() {
		LiveWindow.addActuator("Shooter", "Shooter Motor", shooter);
	}

	/**
	 * The preset value of the shooter's power
	 */
    public void shoot() {
    	shoot(1.0); // Set this later
    }
    

	/**
	 * Sets the parameters of shooter
	 */
    public void shoot(double power) {
    	shooter.set(power);
    }
    

	/**
	 * Displays the RPM of the shooter's wheel
	 */
    public void displayRPM() {
    	SmartDashboard.putNumber("Shooter RPM", shooter.getSpeed());
    }
    

	/**
	 * Outputs the shooter's values to the SmartDashboard
	 */
	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Shooter", shooter);
	}
	
	/**
	 * Stops the shooter 
	 */
	@Override
	public void stop() {
		shooter.set(0.0);
	}

	/**
	 * Resets the sensors 
	 */
	@Override
	public void resetSensors() {
		
	}
}