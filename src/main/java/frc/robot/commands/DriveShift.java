package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DriveShift extends CommandBase {

    public boolean mode;
    private final DriveBase m_drive;

    public DriveShift(DriveBase drive) {
        m_drive = drive;

        addRequirements(drive);
    }

    @Override
    public void execute() {
        mode = !mode;
        m_drive.changeMode(mode);
    }

}