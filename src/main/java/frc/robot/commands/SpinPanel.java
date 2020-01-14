package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PanelSpinner;

public class SpinPanel extends CommandBase {

    DoubleSupplier m_speed;
    PanelSpinner m_spinner;

    public SpinPanel(PanelSpinner spinner, DoubleSupplier speed) {
        m_spinner = spinner;
        m_speed = speed;

        addRequirements(spinner);
    }

    @Override
    public void execute() {
        m_spinner.set(m_speed.getAsDouble());
    }

}