package org.team708.robot.commands.autonomous;

import org.team708.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.team708.robot.commands.drivetrain.DriveStraightToEncoderDistance;
import org.team708.robot.commands.drivetrain.DriveToIRDistance;
import org.team708.robot.commands.drivetrain.TurnToDegrees;
import org.team708.robot.commands.intake.IntakeTote;
import org.team708.robot.commands.toteElevator.ToteElevatorUp;
/**
 *Moves a single tote to the auto zone
 */
public class OneToteToAuto extends CommandGroup {
	//distance from IR sensor
    private double tolerance = 1;
    
    //values for turning and moving
    private final double TURN_DEGREES = 90.0;
    private final double TURN_SPEED = 0.5;
    private final double MOVE_DISTANCE = 180.0;
    
    public  OneToteToAuto() {
    	
    	addSequential(new DriveToIRDistance(Drivetrain.DISTANCE_FROM_TOTE, tolerance));
    	addSequential(new IntakeTote());
    	addSequential(new ToteElevatorUp());
    	addSequential(new TurnToDegrees(TURN_SPEED, TURN_DEGREES));
    	addSequential(new DriveStraightToEncoderDistance(MOVE_DISTANCE));
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
