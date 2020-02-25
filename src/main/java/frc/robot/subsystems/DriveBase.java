package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveBase extends SubsystemBase {

    private DriveGearbox[] gearboxes;

    public DriveBase(DriveGearbox left, DriveGearbox right) {
        gearboxes = new DriveGearbox[]{left, right};
    }

    public void drive(double left, double right) {
        gearboxes[0].driveOutput(left);
        gearboxes[1].driveOutput(right);
    }

    public void disable() {
        for (DriveGearbox gearbox : gearboxes) {
            gearbox.disable();
        }
    }

    public void changeMode(boolean isShifted) {
        for (DriveGearbox gearbox : gearboxes) {
            gearbox.shift(isShifted);
        }
    }

}