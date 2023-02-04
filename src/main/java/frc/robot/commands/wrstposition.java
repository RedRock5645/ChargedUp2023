package frc.robot.commands;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import frc.robot.util.OrbitPID;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;




public class wrstposition extends CommandBase{
    private static OrbitPID pid;
    private static CANSparkMax pivotWrist;
    private static RelativeEncoder pivotWristEncoder;
    private static double wristSteps = 0;

    public wrstposition (int PivotWristID) {
        pivotWrist = new CANSparkMax(PivotWristID, MotorType.kBrushless);
        pivotWristEncoder = pivotWrist.getEncoder();
        pivotWrist.setIdleMode(IdleMode.kBrake);

        pid = new OrbitPID(0.007, 0, 0);
    }
    
    public void setZero() {
        pivotWristEncoder.setPosition(0.0);
    }




    public void setSpeed(double speed) {
        pivotWrist.set(speed);
    }




    public double getAngle() {
        return getPositionOfEncoder() / Constants.TICKS_PER_ANGLE_PIVOT;
    }
    public double getStepsfromAngle(double degrees) {
        return Constants.TICKS_PER_ANGLE_PIVOT * degrees;
    }




    public double getPositionOfEncoder() {
        return pivotWristEncoder.getPosition();
    }


    public void setAngle(double degrees) {
        wristSteps = getStepsfromAngle(degrees);

        double pidoutput = pid.calculate(wristSteps, pivotWristEncoder.getCountsPerRevolution() * getPositionOfEncoder());
        if (pidoutput > 0.25){
            pidoutput = 0.25;
        } 
        else if (pidoutput < -0.25) {
            pidoutput = -0.25;
        }
    }


    @Override
    public void initialize() { 
    }


    @Override 
    public void execute() { 
          
    }

    @Override
    public void end(boolean interruptible) { 
         
    }

    @Override
    public boolean isFinished() { 
        return true;
    }

} 