package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Quick's on 9/28/2017.21 */

@TeleOp(name = "Servo_Color_Test")
public class Servo_Color_Test extends OpMode{
    public LynxI2cColorRangeSensor color1 = null;

    Hardware_robodux robot = new Hardware_robodux();

    @Override
    public void init(){
        robot.init(hardwareMap);
        robot.left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        color1 = hardwareMap.get(LynxI2cColorRangeSensor.class,"color1");

    }
    @Override
    public void loop(){
        if(color1.blue() > 90 && color1.blue() > color1.red() && robot.right_front_drive.isBusy() == false && robot.left_front_drive.isBusy() == false){
           // robot.kick.setPosition(0.0);
           /* robot.left_front_drive.setTargetPosition(500);
            robot.right_front_drive.setTargetPosition(500);

            robot.left_front_drive.setPower(0.2);
            robot.right_front_drive.setPower(0.2);*/
        }else if(color1.blue() < 90 && color1.red() > 90 && color1.red() > color1.blue() && robot.right_front_drive.isBusy() == false && robot.left_front_drive.isBusy() == false){
            //robot.kick.setPosition(1.0);
            /*robot.left_front_drive.setTargetPosition(-500);
            robot.right_front_drive.setTargetPosition(-500);

            robot.left_front_drive.setPower(0.2);
            robot.right_front_drive.setPower(0.2);*/


        }else{
            //robot.kick.setPosition(0.5);
/*
            robot.left_front_drive.setPower(0);
            robot.right_front_drive.setPower(0);
*/
        }


    }
    @Override
    public void stop(){

    }
}
