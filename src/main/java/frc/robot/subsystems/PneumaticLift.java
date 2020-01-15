package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticLift extends SubsystemBase {

    private Solenoid m_In, m_Out;

    public PneumaticLift(Solenoid solIn, Solenoid solOut) {
        m_In = solIn;
        m_Out = solOut;

        initialize();
    }

    public void initialize() {
        m_In.set(true);
        m_Out.set(false);
    }

    public void shift() {
        m_In.set(!m_In.get());
        m_Out.set(!m_Out.get());
    }

}