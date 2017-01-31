package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Change Log:
 * 1/26/17: added shooter motor and Livewindow stuff
 * 1/28/2017: Added displayRPM, shoot, and preset shoot commands
 */
public class Shooter implements Subsystem {
    public final CANTalon shooter        = new CANTalon(RobotMap.SHOOTER_PORT);
	public final Encoder  shooterEncoder = new Encoder(RobotMap.SHOOTER_ENCODER_PORT_A, 
													   RobotMap.SHOOTER_ENCODER_PORT_B);
	public Shooter() {
		LiveWindow.addActuator("Shooter", "Shooter Motor", shooter);
		LiveWindow.addSensor("Sensors", "Shooter Encoder", 	   shooterEncoder);
	}
	
    public void initDefaultCommand() {
    
    }
    
    public void displayRPM() {
    	
    }
    
    public void shoot(double power) {
    	shooter.set(power);
    }
    
    public void shoot() {
    	shooter.set(1.0); // Set this later
    }

	@Override
	public void outputToSmartDashboard() {
		
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void resetSensors() {
		shooterEncoder.reset();
		
	}
    
}

