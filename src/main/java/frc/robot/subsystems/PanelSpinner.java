package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PanelSpinner extends SubsystemBase {

    VictorSPX m_spinner;
    VictorSPX m_lift;

    public PanelSpinner(VictorSPX CONTROL_PANEL_SPINNER, VictorSPX PANEL_LIFT) {
        m_spinner = CONTROL_PANEL_SPINNER;
        m_lift = PANEL_LIFT;
    }

    public void disable() {
        set(0);
        moveLift(0);
    }

    public void set(double speed) {
        m_spinner.set(ControlMode.PercentOutput, speed);
    }

    public void moveLift(double power) {
        m_spinner.set(ControlMode.PercentOutput, power / m_spinner.getBusVoltage());
    }

    public void get() {
        m_spinner.getMotorOutputPercent();
    }

}