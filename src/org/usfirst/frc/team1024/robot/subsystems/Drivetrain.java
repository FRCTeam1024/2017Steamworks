package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * @author team1024
 * Change Log:
 * 1/26/17: added all motors, added drive and stop commands, added shifter
 * 1/28/2017: Added commands for full drive, preset drive, and driveForTime
 * 1/30/2017: Added javadocs
 * 1/31/2017: Now implements our subsystem interface
 */
public class Drivetrain implements Subsystem {
	public final CANTalon frontLeftDrive   		= new CANTalon(RobotMap.FRONT_LEFT_DRIVETRAIN_PORT);
	public final CANTalon middleLeftDrive  		= new CANTalon(RobotMap.MIDDLE_LEFT_DRIVETRAIN_PORT);
	public final CANTalon rearLeftDrive    		= new CANTalon(RobotMap.REAR_LEFT_DRIVETRAIN_PORT);
	public final CANTalon frontRightDrive  		= new CANTalon(RobotMap.FRONT_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon middleRightDrive 		= new CANTalon(RobotMap.MIDDLE_RIGHT_DRIVETRAIN_PORT);
	public final CANTalon rearRightDrive   		= new CANTalon(RobotMap.REAR_RIGHT_DRIVETRAIN_PORT);
	
	public final Solenoid shifter 		   		= new Solenoid(RobotMap.DRIVETRAIN_SHIFTER_PORT);
	
	public final AnalogGyro gyro 				= new AnalogGyro(RobotMap.GYRO_PORT);
	
	public Drivetrain() {
		LiveWindow.addActuator("Drivetrain", "FrontLeft Motor",   frontLeftDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleLeft Motor",  middleLeftDrive);
		LiveWindow.addActuator("Drivetrain", "RearLeft Motor",    rearLeftDrive);
		LiveWindow.addActuator("Drivetrain", "FrontRight Motor",  frontRightDrive);
		LiveWindow.addActuator("Drivetrain", "MiddleRight Motor", middleRightDrive);
		LiveWindow.addActuator("Drivetrain", "RearRight Motor",   rearRightDrive);
		
		LiveWindow.addSensor("Sensors", "Gyro", 			   gyro);
		
		setMotorConfig(frontLeftDrive);
		setMotorConfig(frontRightDrive);
		
		setFollowerMode(frontLeftDrive, middleLeftDrive);
		setFollowerMode(frontLeftDrive, rearLeftDrive);
		setFollowerMode(frontRightDrive, middleRightDrive);
		setFollowerMode(frontRightDrive, rearRightDrive);
	}
	/**
	 * Configures the motors settings
	 * @param motor that is being configured
	 */
	public void setMotorConfig(CANTalon motor) {
		motor.enableBrakeMode(true);
		motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		motor.configEncoderCodesPerRev(250);
		motor.configNominalOutputVoltage(+0.0f, -0.0f);
        motor.configPeakOutputVoltage(+12.0f, 0.0f);
        motor.changeControlMode(TalonControlMode.Position);
		motor.setPIDSourceType(PIDSourceType.kDisplacement);
		motor.setProfile(0);
		motor.setF(0.15);
		motor.setP(0.3);
		motor.setI(0.0);
		motor.setD(0.0);
	}
	/**
	 * Sets a motor to follow another motors commands
	 * @param master the motor that is being followed by the slave
	 * @param slave the motor that is following the masters instructions
	 */
	public void setFollowerMode(CANTalon master, CANTalon slave){
		slave.changeControlMode(TalonControlMode.Follower);
		slave.set(master.getDeviceID());
	}
	
	
	
	/**
	 * Drive all motors with all power
	 * @param power
	 */
	public void drive(double power) {
		frontLeftDrive.set(power);
		middleLeftDrive.set(power);
		rearLeftDrive.set(power);
		frontRightDrive.set(power);
		middleRightDrive.set(power);
		rearRightDrive.set(power);
	}
	
	/**
	 * Sets the drivetrain motors with left and right powers
	 * @param leftpower
	 * @param rightpower
	 */
	public void drive(double leftpower, double rightpower) {
		frontLeftDrive.set(leftpower);
		middleLeftDrive.set(leftpower);
		rearLeftDrive.set(leftpower);
		frontRightDrive.set(rightpower);
		middleRightDrive.set(rightpower);
		rearRightDrive.set(rightpower);
		
	}
	
	/**
	 * Stops all drivetrain motors
	 */
	public void stop() {
		frontLeftDrive.set(0.0);
		middleLeftDrive.set(0.0);
		rearLeftDrive.set(0.0);
		frontRightDrive.set(0.0);
		middleRightDrive.set(0.0);
		rearRightDrive.set(0.0);
	}
	
	public void driveForTime(double time, double leftPower, double rightPower){
		drive(leftPower, rightPower);
		Timer.delay(time);
		stop();
	}
	
	@Override
	public void outputToSmartDashboard() {
		
	}
	
	@Override
	public void resetSensors() {
    	gyro.reset();
	}
	
}
