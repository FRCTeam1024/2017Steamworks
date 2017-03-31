package org.usfirst.frc.team1024.robot.commands.auto;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class LineUpAndShoot extends Command {

	public LineUpAndShoot() {
		int pos = 0;
		int[] xPositionArray = new int[10];
		int maxPos = 1;
		int aveCount = 0;
		int samples = 0;
		int xPositionAve = 0;
		int turnDir = 0; // negative is left turn. positive is right turn. zero
							// is stop.
		int lowerBound = 120;
		int upperBound = 140;
		char xPosition = 0;
		boolean target = false;
		while (!target && !Robot.oi.getBreakButton()) {
			if (turnDir > 0) { // Set pivot direction (positive = right,
								// negative =
								// left, zero = stop)
				Robot.drivetrain.drive(0, 0.3);
			} else if (turnDir < 0) {
				Robot.drivetrain.drive(0.3, 0);
			} else {
				Robot.drivetrain.drive(0, 0);
			}
			byte[] pixyValues = new byte[64];
			pixyValues[0] = (byte) 0b01010101;
			pixyValues[1] = (byte) 0b10101010;

			Robot.pixyI2C.readOnly(pixyValues, 64); // get camera
														// frame
														// data
			if (pixyValues != null) {// parse camera frame data
				int i = 0;
				while ((!(pixyValues[i] == 85 && pixyValues[i + 1] == -86) && i < 50)
						&& !Robot.oi.getBreakButton() && RobotState.isAutonomous()) {
					i++;
				}
				i++;
				if (i > 50 && !Robot.oi.getBreakButton())
					i = 49;
				while ((!(pixyValues[i] == 85 && pixyValues[i + 1] == -86) && i < 50)
						&& !Robot.oi.getBreakButton() && RobotState.isAutonomous()) {
					i++;
				}

				// Calculate xPosition using running average
				xPosition = (char) (((pixyValues[i + 7] & 0xff) << 8) | (pixyValues[i + 6] & 0xff));
				char yPosition = (char) ((pixyValues[i + 9] & 0xff << 8) | pixyValues[i + 8] & 0xff);
				char width = (char) ((pixyValues[i + 11] & 0xff << 8) | pixyValues[i + 10] & 0xff);
				char height = (char) ((pixyValues[i + 13] & 0xff << 8) | pixyValues[i + 12] & 0xff);
				DriverStation.reportError("xposition: " + xPosition, true);
				if (xPosition < 300 && xPosition > 1 && (width > 20 && width < 45)) {
					xPositionArray[pos] = xPosition;
					pos++;
					samples++;
					if (pos > maxPos) {
						pos = 0;
					}
				}
				xPositionAve = 0;
				for (aveCount = 0; aveCount <= maxPos; aveCount++) {
					xPositionAve += xPositionArray[aveCount];
				}
				xPositionAve = xPositionAve / (maxPos + 1);

				if ((xPositionAve > lowerBound && xPositionAve < upperBound)) { // Determine
					// if we
					// have a
					// target
					target = true;
				}
				if (samples > maxPos) { // Don't
																			// adjust
																			// turn
																			// direction
																			// until
					// there is a full average
					if (xPositionAve < lowerBound) {
						turnDir = -1;
					} else if (xPositionAve > upperBound) {
						turnDir = 1;
					} else {
						turnDir = 0;
					}
					samples = maxPos + 1; // Don't let samples grow
											// uncontrollably
				}
			}
		}
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
	}
	@Override
	protected boolean isFinished() { return false; }

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}