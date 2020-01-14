package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PanelSpinner extends SubsystemBase {

    VictorSPX m_spinner;

    public PanelSpinner(VictorSPX cONTROL_PANEL_SPINNER) {
        m_spinner = cONTROL_PANEL_SPINNER;
    }

    public void disable() {
        set(0);
    }

    public void set(double speed) {
        m_spinner.set(ControlMode.PercentOutput, speed);
    }

    public void get() {
        m_spinner.getMotorOutputPercent();
    }

}