package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    public Joystick driveLeft, driveRight;

    public OI() {
        driveLeft = new Joystick(0);
        driveRight = new Joystick(1);
    }

}