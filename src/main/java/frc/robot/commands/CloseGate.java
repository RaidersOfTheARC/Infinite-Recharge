package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CollectorGate;

public class CloseGate extends CommandBase {

    private CollectorGate m_gate;

    public CloseGate(CollectorGate gate) {
        m_gate = gate;
    }

    @Override
    public void execute() {
        m_gate.lock();
    }

}