package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Gear extends Subsystem implements Subsystem1024 {
	public Solenoid pusher = new Solenoid(RobotMap.GEAR_PUSHER_PORT_1);
	public DoubleSolenoid clamper = new DoubleSolenoid(RobotMap.GEAR_CLAMP_PORT_1, RobotMap.GEAR_CLAMP_PORT_2);
	public DigitalInput gearDetector = new DigitalInput(RobotMap.GEAR_DETECTOR_PORT);
	public DigitalOutput gearTransmitter = new DigitalOutput(RobotMap.GEAR_TRANSMITTER_PORT);
	public Relay gearIndicator = new Relay(RobotMap.GEAR_LED_PORT);
	
	
	/**
	 * Sets the gear clamper to a desired state (open, closed, or neutral)
	 * @param clamp (open = 1, closed = -1, neutral = 0)
	 */
	public void clamp(int clamp) {
		if (clamp == 1) {
			clamper.set(Value.kForward);
		} else if (clamp == -1) {
			clamper.set(Value.kReverse);
		} else if (clamp == 0) {
			clamper.set(Value.kOff);
		}
	}
	
	public void push(boolean push) {
		if (push == true) {
			pusher.set(true/*Value.kForward*/);
		} else if (push == false) {
			pusher.set(false/*Value.kReverse*/);
		}
	}
	
	/**
	 * Uses a limit switch to detect if there is a gear seated in the holder
	 * @returns true if there is a gear
	 * @returns false if there is not a gear
	 */
	public boolean isGear() {
		if (gearDetector.get() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sets the LEDs based on if there is a gear or not(using isGear())
	 */
	public void setLED() {
		if (isGear()) {
			setLED(true);
		} else {
			setLED(false);
		}
	}
	
	/**
	 * Turns the LEDs on or off 
	 * @param state
	 */
	public void setLED(boolean state) {
		if (state == true) {
			gearIndicator.set(Relay.Value.kOn);
		} else {
			gearIndicator.set(Relay.Value.kOff);
		}
	}
	
	@Override
	public void outputToSmartDashboard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

