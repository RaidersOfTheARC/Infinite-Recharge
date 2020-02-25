package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CollectorGate extends SubsystemBase {

    private Servo m_left, m_right;

    public CollectorGate(Servo left, Servo right) {
        m_left = left;
        m_right = right;

        lock();
    }

    public void lock() {
        m_left.set(0);
        m_right.set(1);
    }

    public void disable() {
        m_left.setDisabled();
        m_right.setDisabled();
    }

    public void release() {
        m_left.set(0.75);
        m_right.set(0.25);
    }

}