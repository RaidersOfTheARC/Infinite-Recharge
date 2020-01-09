package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;


public class RobotMap {

    public static CANSparkMax LEFT_GEARBOX_LEFT;    // left drive gearbox, left motor
    public static CANSparkMax RIGHT_GEARBOX_LEFT;   // right drive gearbox, left motor
    public static CANSparkMax LEFT_GEARBOX_RIGHT;   // left drive gearbox, right motor
    public static CANSparkMax RIGHT_GEARBOX_RIGHT;  // right drive gearbox, right motor

    public static Solenoid SPEED_MODE_ACTUATOR;     // the speed mode actuator for the drive base
    public static Solenoid TORQUE_MODE_ACTUATOR;    // the torque mode actuator for the drive base 

    public static void init() {
        LEFT_GEARBOX_LEFT = new CANSparkMax(10, MotorType.kBrushless);
        RIGHT_GEARBOX_LEFT = new CANSparkMax(20, MotorType.kBrushless);
        LEFT_GEARBOX_RIGHT = new CANSparkMax(30, MotorType.kBrushless);
        RIGHT_GEARBOX_RIGHT = new CANSparkMax(40, MotorType.kBrushless);

        LEFT_GEARBOX_LEFT.setInverted(false);
        LEFT_GEARBOX_RIGHT.setInverted(false);
        RIGHT_GEARBOX_LEFT.setInverted(true);
        RIGHT_GEARBOX_RIGHT.setInverted(true);

        SPEED_MODE_ACTUATOR = new Solenoid(0);
        TORQUE_MODE_ACTUATOR = new Solenoid(1);
    }

}