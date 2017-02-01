package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
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
	
    public void initDefaultCommand() {
    
    }
    
    public void displayRPM() {
    	shooter.getSpeed();
    }
    
    public void shoot(double power) {
    	shooter.set(power);
    }
    
    public void shoot() {
    	shooter.set(1.0); // Set this later
    }

	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Shooter", shooter);
	}

	@Override
	public void stop() {
	}

	@Override
	public void resetSensors() {
		
	}
    
}

