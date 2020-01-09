/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.Drive;
import frc.robot.commands.DriveShift;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.DriveGearbox;

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

  private final Drive driveCommand;

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

    driveCommand = new Drive(driveBase, (DoubleSupplier)Robot.oi.driveLeft, (DoubleSupplier)Robot.oi.driveRight);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    Robot.oi.gearboxShift.whenPressed(new DriveShift(driveBase));
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
