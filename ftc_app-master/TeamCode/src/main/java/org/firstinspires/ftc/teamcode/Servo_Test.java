package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

/**
 * Created by Quick's on 9/26/2017.
 */
@TeleOp (name = "servo test")
public class Servo_Test extends OpMode {

    public LynxI2cColorRangeSensor color1 = null;

    Hardware_robodux robot = new Hardware_robodux();

    double actpos;
    double actpos1;

    @Override
    public void init(){
        robot.init(hardwareMap);
        color1 = hardwareMap.get(LynxI2cColorRangeSensor.class,"color1");

    }
    @Override
    public void loop(){

        //actpos = robot.kick.getPosition();
        //actpos1 = robot.kick1.getPosition();

        telemetry.addData("Servo 1 Position", actpos);
        telemetry.addData("Servo 2 Position", actpos1);

        if (gamepad1.a ){
          //  robot.kick1.setPosition(0);
            //robot.kick.setPosition(0.6);

        }else {
            //robot.kick.setPosition(0);
            //robot.kick1.setPosition(0.6);

        }
    }
    @Override
    public void stop(){

    }
}
