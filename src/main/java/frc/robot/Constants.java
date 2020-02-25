/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {

        public static double kWheelDiameter = 6;   // inches
        public static double kTrackWidth = 30;     // inches

        public static double kPi = Math.PI;         // for the sake of consistency..?
        
        // calculations
        public static double kWheelCircumference = kWheelDiameter * kPi;

        /**
         * The constants for the drive motors in {@link RobotMap}
         */
        public static int kLeftGearboxLeftMotor = 5;
        public static int kRightGearboxLeftMotor = 7;
        public static int kLeftGearboxRightMotor = 6;
        public static int kRightGearboxRightMotor = 8;

        /**
         * The constants for the solenoids for the gearboxes
         */
        public static int kSpeedMode = 0;
        public static int kTorqueMode = 1;

    }

    public static final class OIConstants {

        public static int kDriveController = 0;

        public static int kGearboxShiftButton = Button.kBumperRight.value;

        public static int kToolOp = 1;

    }

    public static final class SubsystemConstants {

        public static int kControlPanelSpinner = 10;
        public static int kControlPanelLiftControl = 11;
        public static int kPowerCellGateLeft = 4;
        public static int kPowerCellGateRight = 5;
        public static int kLiftIn = 2;
        public static int kLiftOut = 3;

        public static int kCompressor = 0;

    }

}
