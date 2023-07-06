package frc.robot.commands.ledstrip;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDSubsystem;

public class LedCone extends CommandBase {

    LEDSubsystem led;

    public LedCone(LEDSubsystem led) {
        this.led = led;

        addRequirements(led);
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        led.setLEDCode(0.69);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
