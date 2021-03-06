package org.team708.robot.commands.intake;

import org.team708.robot.Robot;
import org.team708.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeTote extends Command {

    public IntakeTote() {
        // Use requires(+) here to declare subsystem dependencies
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.set(Intake.IN_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.intake.isToteSwitchTriggered();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
