package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Constants;
import org.usfirst.frc.team1024.robot.util.KilaTalon;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Change Log:
 * 1/26/17: added shooter motor and Livewindow stuff
 * 1/28/2017: Added displayRPM, shoot, and preset shoot commands
 */
public class Shooter extends Subsystem implements Subsystem1024 {
    public final KilaTalon shooter = new KilaTalon(RobotMap.SHOOTER_PORT);
    public double shooterPower;
    
	public Shooter() {
		LiveWindow.addActuator("Shooter", "Shooter Motor", shooter);
		
		setMotorConfig(shooter, 0.1724137931034483, 0.12, 0.0005, 0.0003);
		shooterPower = Constants.initShooterPower;
	}
	
	public void setMotorConfig(KilaTalon motor, double f, double p, double i, double d) {
		motor.reverseOutput(true);
		motor.enableBrakeMode(false);
		motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		motor.configEncoderCodesPerRev(360);
		motor.configNominalOutputVoltage(+0.0f, -0.0f);
        motor.configPeakOutputVoltage(+12.0f, -12.0f);
        motor.changeControlMode(TalonControlMode.Speed);
		motor.setPIDSourceType(PIDSourceType.kRate);
		motor.setPID(p, i, d, f, 0, 0.0, 0);
		motor.reverseSensor(true);
	}

	/**
	 * The preset value of the shooter's power
	 */
    public void shootPreset() {
    	shoot(1.0); // Set this later
    }
    
	/**
	 * Sets the parameters of shooter
	 */
    public void shoot(double power) {
    	//shooter.changeControlMode(TalonControlMode.PercentVbus);
    	shooter.set(power);
    }
    
    /*public void shootPID(double speed) {
    	shooter.changeControlMode(TalonControlMode.Speed);
    	shooter.setSetpoint(speed);
    }*/

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
		//SmartDashboard.putData("Shooter", shooter);
		
		shooter.setP(SmartDashboard.getNumber("P", shooter.getP()));
		shooter.setI(SmartDashboard.getNumber("I", shooter.getI()));
		shooter.setD(SmartDashboard.getNumber("D", shooter.getD()));
		shooter.setSetpoint(SmartDashboard.getNumber("Setpoint", shooter.getSetpoint()));
		
		SmartDashboard.putNumber("F", shooter.getF());
		if (SmartDashboard.getBoolean("GO", false) == true) {
			shooter.enable();
		} else {
			shooter.disable();
		}
		SmartDashboard.putNumber("Shooter RPM", shooter.getSpeed());
	}
	
	public void initDashboard() {
		SmartDashboard.putNumber("P", shooter.getP());
		SmartDashboard.putNumber("I", shooter.getI());
		SmartDashboard.putNumber("D", shooter.getD());
		SmartDashboard.putNumber("Setpoint", shooter.getSetpoint());
		SmartDashboard.putBoolean("GO", false);
	}
	
	/**
	 * Stops the shooter 
	 */
	@Override
	public void stop() {
		shooter.set(0.0);
	}
	
	/*
	public void autoShoot(){
		
	}
	*/
	
	/**
	 * Resets the sensors 
	 */
	
	@Override
	public void resetSensors() {
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
