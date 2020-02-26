package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.GoBILDAServo;

public class CollectorGate extends SubsystemBase {

    private GoBILDAServo m_left, m_right;

    public CollectorGate(GoBILDAServo left, GoBILDAServo right) {
        m_left = left;
        m_right = right;

        m_left.setReverse(true);
        m_right.setReverse(false);

        lock(); 
    }

    public void lock() {
        m_left.set(0.8);
        m_right.set(0.8);
    }

    public void disable() {
        m_left.setDisabled();
        m_right.setDisabled();
    }

    public void release() {
        m_left.set(0.5);
        m_right.set(0.5);
    }

    public void intake() {
        m_left.set(0.68);
        m_right.set(0.68);
    }

}