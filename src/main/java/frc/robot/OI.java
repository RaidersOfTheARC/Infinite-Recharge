package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;

public class OI {

    public Joystick driveLeft, driveRight;
    public JoystickButton gearboxShift;

    public XboxController toolOp;
    public JoystickButton powerCellGateOpen, powerCellGateClose;

    public OI() {
        driveLeft = new Joystick(OIConstants.kLeftJoystick);
        driveRight = new Joystick(OIConstants.kRightJoystick);

        gearboxShift = new JoystickButton(driveLeft, OIConstants.kGearboxShiftButton);

        toolOp = new XboxController(OIConstants.kToolOp);
        powerCellGateOpen = new JoystickButton(toolOp, Button.kBumperLeft.value);
        powerCellGateClose = new JoystickButton(toolOp, Button.kBumperRight.value);
    }

}