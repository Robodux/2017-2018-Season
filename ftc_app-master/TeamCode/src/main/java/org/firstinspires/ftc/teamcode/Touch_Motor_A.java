package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;

/**
 * Created by Quick's on 10/12/2017.
 */
@TeleOp(name = "Touch Test With Motors")
public class Touch_Motor_A extends OpMode {
    Hardware_robodux robot = new Hardware_robodux();
    DigitalChannel digitalTouch;

    boolean touch;



    @Override
    public void init(){
        robot.init(hardwareMap);
        digitalTouch = hardwareMap.get(DigitalChannel.class, "touch_sensor_digital");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        robot.right_front_drive.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

        /*
        if (gamepad1.a && touch == false ){
            robot.left_front_drive.setPower(1);
            robot.right_front_drive.setPower(1);
        }else{
            robot.left_front_drive.setPower(0);
            robot.right_front_drive.setPower(0);
        }
        telemetry.addData("Touch", touch);
        telemetry.update();
    }
    */

        //if (touchSensor.ew("touch_sensor_digital == true)
        //telemetry.addData("Touch", digitalTouch.getState());
        telemetry.update();
    /*public void stop (){
        robot.left_front_drive.setPower(0);
        robot.right_front_drive.setPower(0);
    }*/

    }
}



