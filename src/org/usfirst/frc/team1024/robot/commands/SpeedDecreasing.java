package org.usfirst.frc.team1024.robot.commands;

import org.usfirst.frc.team1024.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpeedDecreasing extends Command {

	public class SpeedDecrease extends Command {

		public SpeedDecrease() {
			requires(Robot.gear);
		}
		
		@Override
		protected void initialize() {
		}
		
		@Override
		protected void execute() {
			Robot.shooter.shooterPower -= 0.001;
		}
		
		@Override
		protected boolean isFinished() {
			return false;
		}
		
		@Override
		protected void end() {
		}
		
		@Override
		protected void interrupted() {
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}