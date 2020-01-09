package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveBase;

public class Drive extends CommandBase {

    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveBase m_drive;
    private final DoubleSupplier m_left, m_right;

    public Drive(DriveBase drivetrain, DoubleSupplier left, DoubleSupplier right) {
        m_drive = drivetrain;
        m_left = left;
        m_right = right;

        addRequirements(drivetrain);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drive.drive(m_left.getAsDouble(), m_right.getAsDouble());
    }

}