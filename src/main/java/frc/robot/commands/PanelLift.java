package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PanelSpinner;

public class PanelLift extends CommandBase {

    private DoubleSupplier m_liftSpeed;
    private PanelSpinner m_spinner;

    public PanelLift(PanelSpinner spinner, DoubleSupplier liftSpeed) {
        m_spinner = spinner;
        m_liftSpeed = liftSpeed;

        addRequirements(spinner);
    }

    @Override
    public void execute() {
        m_spinner.moveLift(m_liftSpeed.getAsDouble());
    }

}