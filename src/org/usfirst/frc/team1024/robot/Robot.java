package org.usfirst.frc.team1024.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1024.robot.commands.redauto.*;
import org.usfirst.frc.team1024.robot.commands.auto.HopperShoot;
import org.usfirst.frc.team1024.robot.commands.auto.Pos1Shoot;
import org.usfirst.frc.team1024.robot.commands.auto.Pos2GearOnMiddlePeg;
import org.usfirst.frc.team1024.robot.commands.auto.RedPos1ShootCrossArc;
import org.usfirst.frc.team1024.robot.commands.auto.RedPos1ShootCrossArcGear;
import org.usfirst.frc.team1024.robot.commands.auto.RedPos1ShootCrossArcOppositeSide;
import org.usfirst.frc.team1024.robot.commands.auto.BluePos1ShootCrossArc;
import org.usfirst.frc.team1024.robot.commands.auto.CrossBaselinePower;

import java.io.IOException;
import java.util.List;

import org.usfirst.frc.team1024.Pixy.PixyI2C;
import org.usfirst.frc.team1024.Pixy.PixyObject;
import org.usfirst.frc.team1024.Pixy.PixyPacket;

// import org.usfirst.frc.team1024.robot.commands.auto.Pos2GearOnMiddlePeg;

import org.usfirst.frc.team1024.robot.subsystems.Blender;
import org.usfirst.frc.team1024.robot.subsystems.Climber;
import org.usfirst.frc.team1024.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1024.robot.subsystems.Gear;
import org.usfirst.frc.team1024.robot.subsystems.Hopper;
import org.usfirst.frc.team1024.robot.subsystems.Shooter;


import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team1024.robot.subsystems.REVDigitBoard;

/**
 * @author team1024 Change Log 1/26/17:
 */
public class Robot extends IterativeRobot {
	public static boolean hasRun = false;
	//public static Logger logger;
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter = new Shooter();
	public static final Climber climber = new Climber();
	public static final Blender blender = new Blender();
	public static final Gear gear = new Gear();
	public static final Hopper hopper = new Hopper();
	public static final REVDigitBoard autoChooser = new REVDigitBoard();

	public PixyI2C pixy;
	public PixyPacket test;
	public DigitalOutput pixyPower;
	public static int[] pixyValues;

	int position = 0;
	String peg = "";

	public static OI oi;
	public int autoSelected;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	public boolean shooterSetState = false;

	@Override
	public void robotInit() {
		oi = new OI();
		NetworkTable.globalDeleteAll();
		shooter.initDashboard();
		drivetrain.initDashboard();
		//logger = new Logger();
		drivetrain.frontLeftDrive.setEncPosition(0);
		drivetrain.frontRightDrive.setEncPosition(0);

		pixyPower = new DigitalOutput(4);
		pixyPower.set(true);
		
		pixy = new PixyI2C();
		pixyValues = new int[10];

		autoSelected = 0;

		drivetrain.navx.zeroYaw();
		autoChooser.display("1024");
	}

	@Override
	public void disabledInit() {
		autoChooser.display("1024");
		if (hasRun == true) {
			/*try {
				logger.workbook.write(logger.out);
				logger.out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			hasRun = false;
		}
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		// Copied from last year
		if (!autoChooser.getButtonA()) {
			autoSelected++;
			Timer.delay(.2);
			while (!autoChooser.getButtonA())
				;
			if (autoSelected > 9)
				autoSelected = 9;
		}
		if (!autoChooser.getButtonB()) {
			autoSelected--;
			Timer.delay(0.2);
			while (!autoChooser.getButtonB())
				;
			if (autoSelected < 0)
				autoSelected = 0;

		}

		autoChooser.display("000" + autoSelected);
		/**
		 * BEFORE YOU ADD AN AUTO...NO WHILE LOOPS!!!
		 */
		switch (autoSelected) {
		case 0:
			break;
		case 1:
			autonomousCommand = new Pos2GearOnMiddlePeg();
			break;
		case 2:
			autonomousCommand = new Pos1Shoot();
			break;
		// shoot 10sec
		// cross baseline
		case 3:
			//not used!!!
			autonomousCommand = new RedPos1ShootCross();
			break;
		// shoot 5sec
		// cross baseline
		case 4:

			// shoot, cross, arc
			// square up
			// set to 35% inside, 50% outside
			// 1 second
			autonomousCommand = new BluePos1ShootCrossArc();

			// delay 5sec
			// move
			// shoot 5sec
			// cross baseline
			break;
		case 5:
			autonomousCommand = new RedPos1ShootCrossArc();
			break;
		case 6:
			//NOT USED
			autonomousCommand = new Pos3NPeg();
			break;
		// pos3 N Peg
		case 7:
			//not used!!!
			// hopper shoot
			autonomousCommand = new RedPos1ShootCrossArcGear();
			break;
		case 8:
			// just cross baseline
			autonomousCommand = new RedPos1ShootCrossArcOppositeSide();
			break;
		case 9:
			autonomousCommand = new CrossBaselinePower();
			break;
		}
	}

	@Override
	public void autonomousInit() {
		if (autonomousCommand != null)
			autonomousCommand.start();
		Robot.drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.Position);
		Robot.drivetrain.frontRightDrive.changeControlMode(TalonControlMode.Position);

		drivetrain.navx.zeroYaw();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		shooter.shooter.updateTable();
		drivetrain.frontLeftDrive.changeControlMode(TalonControlMode.PercentVbus);
		drivetrain.frontRightDrive.changeControlMode(TalonControlMode.PercentVbus);
		drivetrain.frontLeftDrive.enable();
		drivetrain.frontRightDrive.enable();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		hasRun = true;
		//logger.logAll();
		outputTheThings();
		// printGyro();
		drivetrain.drive(-oi.lJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM),
				oi.rJoy.getRawAxis(RobotMap.JOYSTICK_Y_AXIS_NUM));

		blender.blend(oi.logi.getRawAxis(3));// Blender
		hopper.agitator.set(oi.logi.getRawAxis(3));
		hopper.agitate(oi.logi.getRawAxis(3));
		climber.climb(Math.abs(oi.logi.getRawAxis(1)));// Climber

		if (oi.logi.getRawButton(1) == true) {
			gear.clamper.set(Value.kOff);
		}
		if (oi.logi.getPOV() == 0) {
			shooter.shooterSetSpeed += 5.0;
		} else if (oi.logi.getPOV() == 180) {
			shooter.shooterSetSpeed -= 5.0;
		}
		if (oi.lJoy.getRawButton(7) || oi.rJoy.getRawButton(7) || oi.lJoy.getRawButton(5)) {
			drivetrain.shifter.set(false);
		}
		if (oi.lJoy.getRawButton(10) || oi.rJoy.getRawButton(10)) {
			drivetrain.shifter.set(true);
		}
		if (oi.logi.getRawButton(9)) {
			autonomousCommand.cancel();
		}

		List<PixyObject> pixyObjectList = getPixyObjects();
		if (pixyObjectList != null) {
			// printPixyStuff(pixyObjectList);
			// System.out.println("Got " + pixyObjectList.size() + " objects
			// from the pixy");
			// for (int i = 0; i < pixyObjectList.size(); i++) {
			// DriverStation.reportError(pixyObjectList.get(i).toString(),
			// false);
			// }
		}
	}

	public List<PixyObject> getPixyObjects() {
		// pixy values are saved and read like PixyPacket.(x,y,width,height)
		try {
			return pixy.readFrame(1);
		} catch (Exception e) {
			DriverStation.reportError(e.getMessage(), true);
			// e.printStackTrace();
			return null;
		}
	}

	public static void printPixyStuff(List<PixyObject> pol) {
		for (int i = 0; i < pol.size(); i++) {
			PixyObject po1 = pol.get(i);
			SmartDashboard.putNumber(String.format("Pixy %1$d X", i), po1.getX());
			SmartDashboard.putNumber(String.format("Pixy %1$d Y", i), po1.getY());
			SmartDashboard.putNumber(String.format("Pixy %1$d Width", i), po1.getWidth());
			SmartDashboard.putNumber(String.format("Pixy %1$d Height", i), po1.getHeight());
		}
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public void outputTheThings() {
		shooter.outputToSmartDashboard();
		drivetrain.outputToSmartDashboard();
		// gear.outputToSmartDashboard();
		// climber.outputToSmartDashboard();
		// blender.outputToSmartDashboard();
	}

	public static void printGyro() {

		Timer.delay(0.020); /* wait for one motor update time period (50Hz) */

		/* Display 6-axis Processed Angle Data */
		SmartDashboard.putBoolean("IMU_Connected", drivetrain.navx.isConnected());
		SmartDashboard.putBoolean("IMU_IsCalibrating", drivetrain.navx.isCalibrating());
		SmartDashboard.putNumber("IMU_Yaw", drivetrain.navx.getYaw());
		SmartDashboard.putNumber("IMU_Pitch", drivetrain.navx.getPitch());
		SmartDashboard.putNumber("IMU_Roll", drivetrain.navx.getRoll());

		/* Display tilt-corrected, Magnetometer-based heading (requires */
		/* magnetometer calibration to be useful) */

		SmartDashboard.putNumber("IMU_CompassHeading", drivetrain.navx.getCompassHeading());

		/*
		 * Display 9-axis Heading (requires magnetometer calibration to be
		 * useful)
		 */
		SmartDashboard.putNumber("IMU_FusedHeading", drivetrain.navx.getFusedHeading());

		/*
		 * These functions are compatible w/the WPI Gyro Class, providing a
		 * simple
		 */
		/* path for upgrading from the Kit-of-Parts gyro to the navx MXP */

		SmartDashboard.putNumber("IMU_TotalYaw", drivetrain.navx.getAngle());
		SmartDashboard.putNumber("IMU_YawRateDPS", drivetrain.navx.getRate());

		/*
		 * Display Processed Acceleration Data (Linear Acceleration, Motion
		 * Detect)
		 */

		SmartDashboard.putNumber("IMU_Accel_X", drivetrain.navx.getWorldLinearAccelX());
		SmartDashboard.putNumber("IMU_Accel_Y", drivetrain.navx.getWorldLinearAccelY());
		SmartDashboard.putBoolean("IMU_IsMoving", drivetrain.navx.isMoving());
		SmartDashboard.putBoolean("IMU_IsRotating", drivetrain.navx.isRotating());

		/*
		 * Display estimates of velocity/displacement. Note that these values
		 * are
		 */
		/*
		 * not expected to be accurate enough for estimating robot position on a
		 */
		/*
		 * FIRST FRC Robotics Field, due to accelerometer noise and the
		 * compounding
		 */
		/*
		 * of these errors due to single (velocity) integration and especially
		 */
		/* double (displacement) integration. */

		SmartDashboard.putNumber("Velocity_X", drivetrain.navx.getVelocityX());
		SmartDashboard.putNumber("Velocity_Y", drivetrain.navx.getVelocityY());
		SmartDashboard.putNumber("Displacement_X", drivetrain.navx.getDisplacementX());
		SmartDashboard.putNumber("Displacement_Y", drivetrain.navx.getDisplacementY());

		/* Display Raw Gyro/Accelerometer/Magnetometer Values */
		/*
		 * NOTE: These values are not normally necessary, but are made available
		 */
		/*
		 * for advanced users. Before using this data, please consider whether
		 */
		/* the processed data (see above) will suit your needs. */

		SmartDashboard.putNumber("RawGyro_X", drivetrain.navx.getRawGyroX());
		SmartDashboard.putNumber("RawGyro_Y", drivetrain.navx.getRawGyroY());
		SmartDashboard.putNumber("RawGyro_Z", drivetrain.navx.getRawGyroZ());
		SmartDashboard.putNumber("RawAccel_X", drivetrain.navx.getRawAccelX());
		SmartDashboard.putNumber("RawAccel_Y", drivetrain.navx.getRawAccelY());
		SmartDashboard.putNumber("RawAccel_Z", drivetrain.navx.getRawAccelZ());
		SmartDashboard.putNumber("RawMag_X", drivetrain.navx.getRawMagX());
		SmartDashboard.putNumber("RawMag_Y", drivetrain.navx.getRawMagY());
		SmartDashboard.putNumber("RawMag_Z", drivetrain.navx.getRawMagZ());
		SmartDashboard.putNumber("IMU_Temp_C", drivetrain.navx.getTempC());
		SmartDashboard.putNumber("IMU_Timestamp", drivetrain.navx.getLastSensorTimestamp());

		/* Omnimount Yaw Axis Information */
		/*
		 * For more info, see
		 * http://navx-mxp.kauailabs.com/installation/omnimount
		 */
		AHRS.BoardYawAxis yaw_axis = drivetrain.navx.getBoardYawAxis();
		SmartDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
		SmartDashboard.putNumber("YawAxis", yaw_axis.board_axis.getValue());

		/* Sensor Board Information */
		SmartDashboard.putString("FirmwareVersion", drivetrain.navx.getFirmwareVersion());

		/* Quaternion Data */
		/*
		 * Quaternions are fascinating, and are the most compact representation
		 * of
		 */
		/*
		 * orientation data. All of the Yaw, Pitch and Roll Values can be
		 * derived
		 */
		/*
		 * from the Quaternions. If interested in motion processing, knowledge
		 * of
		 */
		/* Quaternions is highly recommended. */
		SmartDashboard.putNumber("QuaternionW", drivetrain.navx.getQuaternionW());
		SmartDashboard.putNumber("QuaternionX", drivetrain.navx.getQuaternionX());
		SmartDashboard.putNumber("QuaternionY", drivetrain.navx.getQuaternionY());
		SmartDashboard.putNumber("QuaternionZ", drivetrain.navx.getQuaternionZ());

		/* Connectivity Debugging Support */
		SmartDashboard.putNumber("IMU_Byte_Count", drivetrain.navx.getByteCount());
		SmartDashboard.putNumber("IMU_Update_Count", drivetrain.navx.getUpdateCount());
	}
}
