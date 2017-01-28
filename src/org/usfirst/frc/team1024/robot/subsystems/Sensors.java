package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * @author team1024
 * Change Log:
 * 1/26/17: added both drive encoders and gyro, added Livewindow stuff
 * 1/28/2017: Added the reset command
 */
public class Sensors extends Subsystem {
		public final Encoder leftDrivetrainEncoder  = new Encoder(RobotMap.LEFT_DRIVETRAIN_ENCODER_PORT_A,  RobotMap.LEFT_DRIVETRAIN_ENCODER_PORT_B);
		public final Encoder rightDrivetrainEncoder = new Encoder(RobotMap.RIGHT_DRIVETRAIN_ENCODER_PORT_A, RobotMap.RIGHT_DRIVETRAIN_ENCODER_PORT_B);
		public final Encoder shooterEncoder 	    = new Encoder(RobotMap.SHOOTER_ENCODER_PORT_A, 			RobotMap.SHOOTER_ENCODER_PORT_B);
		public final AnalogGyro gyro = new AnalogGyro(RobotMap.GYRO_PORT);
		public Sensors() {
			LiveWindow.addSensor("Sensors", "Left Drive Encoder",  leftDrivetrainEncoder);
			LiveWindow.addSensor("Sensors", "Right Drive Encoder", rightDrivetrainEncoder);
			LiveWindow.addSensor("Sensors", "Shooter Encoder", 	   shooterEncoder);
			LiveWindow.addSensor("Sensors", "Gyro", 			   gyro);
		}
		
    public void initDefaultCommand() {
    
    }
    
    public void reset() {
    	
    }
}

