package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.SubsystemConstants;

public class RobotMap {

    public static CANSparkMax LEFT_GEARBOX_LEFT;            // left drive gearbox, left motor
    public static CANSparkMax RIGHT_GEARBOX_LEFT;           // right drive gearbox, left motor
    public static CANSparkMax LEFT_GEARBOX_RIGHT;           // left drive gearbox, right motor
    public static CANSparkMax RIGHT_GEARBOX_RIGHT;          // right drive gearbox, right motor

    public static Solenoid SPEED_MODE_ACTUATOR;             // the speed mode actuator for the drive base
    public static Solenoid TORQUE_MODE_ACTUATOR;            // the torque mode actuator for the drive base

    public static VictorSPX CONTROL_PANEL_SPINNER;          // the motor that spins the control panel
    public static VictorSPX PANEL_LIFT_MOTOR;               // the motor that controls the lift for the spinner
    public static Servo POWER_CELL_GATE_CONTROLLER_LEFT;    // the leftside servo for the power cell collector gate
    public static Servo POWER_CELL_GATE_CONTROLLER_RIGHT;   // the rightside servo for the power cell collector gate
    public static Solenoid LIFT_IN;                         // the solenoid that brings the lift piston into the cylinder
    public static Solenoid LIFT_OUT;                        // the solenoid that pushes the lift piston out of the cylinder

    public static void init() {

        LEFT_GEARBOX_LEFT = new CANSparkMax(
            DriveConstants.kLeftGearboxLeftMotor,
            MotorType.kBrushless);

        RIGHT_GEARBOX_LEFT = new CANSparkMax(
            DriveConstants.kRightGearboxLeftMotor,
            MotorType.kBrushless);

        LEFT_GEARBOX_RIGHT = new CANSparkMax(
            DriveConstants.kLeftGearboxRightMotor,
            MotorType.kBrushless);

        RIGHT_GEARBOX_RIGHT = new CANSparkMax(
            DriveConstants.kRightGearboxRightMotor,
            MotorType.kBrushless);

        LEFT_GEARBOX_LEFT.setInverted(false);
        LEFT_GEARBOX_RIGHT.setInverted(false);
        RIGHT_GEARBOX_LEFT.setInverted(true);
        RIGHT_GEARBOX_RIGHT.setInverted(true);

        SPEED_MODE_ACTUATOR = new Solenoid(DriveConstants.kSpeedMode);
        TORQUE_MODE_ACTUATOR = new Solenoid(DriveConstants.kTorqueMode);

        CONTROL_PANEL_SPINNER = new VictorSPX(SubsystemConstants.kControlPanelSpinner);
        PANEL_LIFT_MOTOR = new VictorSPX(SubsystemConstants.kControlPanelLiftControl);
        POWER_CELL_GATE_CONTROLLER_LEFT = new Servo(SubsystemConstants.kPowerCellGateLeft);
        POWER_CELL_GATE_CONTROLLER_RIGHT = new Servo(SubsystemConstants.kPowerCellGateRight);
        LIFT_IN = new Solenoid(SubsystemConstants.kLiftIn);
        LIFT_OUT = new Solenoid(SubsystemConstants.kLiftOut);
    }

}