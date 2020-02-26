package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;

public class OI {

    public XboxController driveController;
    public JoystickButton gearboxShift;

    public XboxController toolOp;
    public JoystickButton powerCellGateOpen, powerCellGateClose, liftActuate, powerCellGateIntake;

    public OI() {
        driveController = new XboxController(OIConstants.kDriveController);

        gearboxShift = new JoystickButton(driveController, OIConstants.kGearboxShiftButton);

        toolOp = new XboxController(OIConstants.kToolOp);
        powerCellGateOpen = new JoystickButton(driveController, Button.kBumperLeft.value);
        powerCellGateClose = new JoystickButton(driveController, Button.kBumperRight.value);
        liftActuate = new JoystickButton(toolOp, Button.kA.value);
        powerCellGateIntake = new JoystickButton(driveController, Button.kA.value);
    }

}