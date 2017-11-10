package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Quick's on 10/19/2017.
 */
@TeleOp(name = "Servo Position")
@Disabled
public class Servo_Position extends OpMode {
    Hardware_robodux robot = new Hardware_robodux();

    @Override
    public void init(){
        robot.init(hardwareMap);

    }
    @Override
    public void loop(){
        if (gamepad1.a) {
            robot.clampl.setPosition(1);
            robot.clampr.setPosition(0);
        }else{
            robot.clampl.setPosition(.93);
            robot.clampr.setPosition(.07);
        }
    }
    @Override
    public void stop(){

    }
}
