package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.configuration.LynxI2cDeviceConfiguration;

/**
 * Created by Quick's on 9/21/2017.
 */
@TeleOp (name = "Two Motors Test")
public class Two_Motors_A_Drive extends OpMode {

    Hardware_robodux robot = new Hardware_robodux();


    public LynxI2cColorRangeSensor color1 = null;

    @Override
    public void init(){
        robot.init(hardwareMap);
        color1 = hardwareMap.get(LynxI2cColorRangeSensor.class,"color1");
        robot.right_front_drive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop(){
        if (gamepad1.a){
            robot.right_front_drive.setPower(0.39);
            robot.left_front_drive.setPower(-0.39);
        }else if (gamepad1.b) {
            robot.right_front_drive.setPower(-0.39);
            robot.left_front_drive.setPower(0.39);
        }else if (gamepad1.x){
            robot.right_front_drive.setPower(-0.15);
            robot.left_front_drive.setPower(0.15);
        }else{
            robot.right_front_drive.setPower(0);
            robot.left_front_drive.setPower(0);
        }




    }

    @Override
    public void stop(){
        robot.right_front_drive.setPower(0);
        robot.left_front_drive.setPower(0);
    }
}
