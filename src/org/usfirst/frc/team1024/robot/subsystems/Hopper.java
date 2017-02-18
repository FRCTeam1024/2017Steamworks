package org.usfirst.frc.team1024.robot.subsystems;

import org.usfirst.frc.team1024.robot.RobotMap;
import org.usfirst.frc.team1024.robot.util.KilaTalon;
import org.usfirst.frc.team1024.robot.util.Subsystem1024;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hopper implements Subsystem1024 {

	public DoubleSolenoid flap = new DoubleSolenoid(RobotMap.HOPPER_FLAP_PORT_1, RobotMap.HOPPER_FLAP_PORT_2);
	public KilaTalon agitator = new KilaTalon(RobotMap.AGITATOR_PORT);

	public Hopper() {
		LiveWindow.addActuator("Hopper", "Flap", flap);
		LiveWindow.addActuator("Hopper", "Agitator", agitator);

		flap.startLiveWindowMode();
		agitator.startLiveWindowMode();
	}

	/**
	 * The agitatator runs at a preset power
	 */
	public void agitate() {
		agitator.set(1.0); // preset later
	}

	/**
	 * 
	 * The agitatator runs at a preset power
	 */
	public void agitate(double power) {
		agitator.set(power);
	}

	public void flap(boolean state) {
		if (state == true) {
			flap.set(Value.kForward);
		} else {
			flap.set(Value.kReverse);
		}
	}

	@Override
	public void outputToSmartDashboard() {
		SmartDashboard.putData("Flap", flap);
		SmartDashboard.putData("Agitator", agitator);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetSensors() {
		// TODO Auto-generated method stub

	}

}
