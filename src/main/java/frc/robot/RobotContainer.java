/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.ActuateLift;
import frc.robot.commands.CloseGate;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveShift;
import frc.robot.commands.Intake;
import frc.robot.commands.OpenGate;
import frc.robot.subsystems.CollectorGate;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.DriveGearbox;
import frc.robot.subsystems.PneumaticLift;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveGearbox left, right;
  private final DriveBase driveBase;
  private final CollectorGate gate;
  private final PneumaticLift lift;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    left = new DriveGearbox(RobotMap.SPEED_MODE_ACTUATOR, RobotMap.TORQUE_MODE_ACTUATOR,
                            RobotMap.LEFT_GEARBOX_LEFT, RobotMap.LEFT_GEARBOX_RIGHT);
    right = new DriveGearbox( RobotMap.SPEED_MODE_ACTUATOR, RobotMap.TORQUE_MODE_ACTUATOR,
                              RobotMap.RIGHT_GEARBOX_LEFT, RobotMap.RIGHT_GEARBOX_RIGHT);

    driveBase = new DriveBase(left, right);
    gate = new CollectorGate(RobotMap.POWER_CELL_GATE_CONTROLLER_LEFT, RobotMap.POWER_CELL_GATE_CONTROLLER_RIGHT);
    lift = new PneumaticLift(RobotMap.LIFT_IN, RobotMap.LIFT_OUT);

    driveBase.setDefaultCommand(
      new Drive(
        driveBase,
        () -> Robot.oi.driveController.getY(Hand.kLeft),
        () -> Robot.oi.driveController.getX(Hand.kRight)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Robot.oi.gearboxShift.whenPressed(new DriveShift(driveBase));

    Robot.oi.powerCellGateOpen.whenPressed(new OpenGate(gate));
    Robot.oi.powerCellGateClose.whenPressed(new CloseGate(gate));
    Robot.oi.powerCellGateIntake.whenPressed(new Intake(gate));

    Robot.oi.liftActuate.whenPressed(new ActuateLift(lift));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
