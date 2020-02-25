package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticLift;

public class ActuateLift extends CommandBase {

    private PneumaticLift m_lift;

    public ActuateLift(PneumaticLift lift) {
        m_lift = lift;

        addRequirements(lift);
    }

    @Override
    public void execute() {
        m_lift.shift();
    }

}