package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectorGate;

public class Intake extends CommandBase {

    private CollectorGate m_gate;

    public Intake(CollectorGate gate) {
        m_gate = gate;

        addRequirements(gate);
    }

    @Override
    public void execute() {
        m_gate.intake();
    }

}