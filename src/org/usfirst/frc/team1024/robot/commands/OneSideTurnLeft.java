package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;
import org.usfirst.frc.team1024.robot.RobotMap;

import org.usfirst.frc.team1024.robot.subsystems.Drivetrain;
import org.usfirst.frc.team1024.robot.util.KilaTalon;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class OneSideTurnLeft extends CommandGroup {
	double leftpower;
	double desiredAngle;

	public OneSideTurnLeft(double leftpower, double desiredAngle) {
		while(Robot.drivetrain.gyro.getAngle() <= desiredAngle) {
			Robot.drivetrain.frontLeftDrive.set(leftpower);
			Robot.drivetrain.rearLeftDrive.set(leftpower);
			Robot.drivetrain.frontRightDrive.set(0);
			Robot.drivetrain.rearRightDrive.set(0);
		}
		Robot.drivetrain.frontLeftDrive.set(0);
		Robot.drivetrain.rearLeftDrive.set(0);
		Robot.drivetrain.frontRightDrive.set(0);
		Robot.drivetrain.rearRightDrive.set(0);
	}
	
	@Override
	protected void execute() {
		Robot.drivetrain.OneSideTurnLeft(leftpower, desiredAngle); //Set this later
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void drive(double power) {
		Robot.drivetrain.frontLeftDrive.set(power);
		Robot.drivetrain.rearLeftDrive.set(power);
		Robot.drivetrain.frontRightDrive.set(-power);
		Robot.drivetrain.rearRightDrive.set(-power);
	}
	
}
	
