package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Quick's on 10/21/2017.
 */


@TeleOp (name = "REV_test")
public class REV_motor_test extends OpMode{
    Hardware_robodux robot = new Hardware_robodux();
    @Override
    public void init (){
        robot.init(hardwareMap);

    }

    @Override
    public void loop (){
        if (gamepad1.a){
            robot.intakel.setPower(-1);
            robot.intaker.setPower( -1);
        }else{
            robot.intakel.setPower(0);
            robot.intaker.setPower(0);
        }
    }
    @Override
    public void stop (){

    }



}
