package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class OI {

    public Joystick driveLeft, driveRight;
    public JoystickButton gearboxShift;

    public OI() {
        driveLeft = new Joystick(0);
        driveRight = new Joystick(1);

        gearboxShift = new JoystickButton(driveLeft, 1);
    }

}