/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveGearbox extends SubsystemBase {
    
    CANSparkMax[] m_controllers;
    Solenoid m_actuatorIn, m_actuatorOut;

    public DriveGearbox(Solenoid shifterIn, Solenoid shifterOut, CANSparkMax... controllers) {
        m_controllers = controllers;
        m_actuatorIn = shifterIn;
        m_actuatorOut = shifterOut;

        if (m_controllers.length > 1 && !checkSpeedControllers()) {
            boolean firstMotorInversionStatus = m_controllers[0].getInverted();

            m_controllers[1].setInverted(firstMotorInversionStatus);
            if (m_controllers.length == 3) m_controllers[2].setInverted(!firstMotorInversionStatus);
        }
    }

    private boolean checkSpeedControllers() {
        boolean firstTwoEqual = m_controllers[0].getInverted() == m_controllers[1].getInverted();

        return (m_controllers.length == 2) ? firstTwoEqual :
            firstTwoEqual && m_controllers[0].getInverted() != m_controllers[2].getInverted();
    }

    public void driveOutput(double speed) {
        for (CANSparkMax controller : m_controllers) {
            controller.set(speed);
        }
    }

    public void disable() {
        for (CANSparkMax controller : m_controllers) {
            controller.disable();
        }
    }

    public void shift(boolean isShifted) {
       m_actuatorIn.set(isShifted);
       m_actuatorOut.set(!isShifted);
    }

}
