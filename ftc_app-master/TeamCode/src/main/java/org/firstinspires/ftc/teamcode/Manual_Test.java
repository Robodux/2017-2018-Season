package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Quick's on 10/28/2017.
 */
@TeleOp(name = "Manual Test")
public class Manual_Test extends OpMode {

    Hardware_robodux robot = new Hardware_robodux();
    double lefta, righta, max;
    @Override
    public void init(){
        robot.init(hardwareMap);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.right_rear_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.left_rear_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.liftl.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.liftr.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    @Override
    public void loop(){

        //POV PROGRAM
        /*double  leftb = Math.pow(lefta , 3);
        double rightb = Math.pow(righta , 3);

        lefta  = -gamepad1.left_stick_y + gamepad1.right_stick_x;
        righta = -gamepad1.left_stick_y - gamepad1.right_stick_x;

        max = Math.max(Math.abs(leftb), Math.abs(rightb));
        if (max > 1.0)
        {
            leftb /= max;
            rightb /= max;
        }
        */

        robot.right_front_drive.setPower(gamepad1.right_stick_y);
        robot.right_rear_drive.setPower(gamepad1.right_stick_y);

        robot.left_front_drive.setPower(gamepad1.left_stick_y);
        robot.left_rear_drive.setPower(gamepad1.left_stick_y);

        //INTAKE
        if(gamepad1.right_trigger < .5 && gamepad1.right_trigger > 0){
            robot.intaker.setPower(1);
            robot.intakel.setPower(.25);
        }else if (gamepad1.right_trigger == 0){
            robot.intakel.setPower(0);
            robot.intaker.setPower(0);
        }else{
            robot.intakel.setPower(gamepad1.right_trigger);
            robot.intaker.setPower(gamepad1.right_trigger);
        }

        //LIFT
        if (gamepad2.dpad_up){
            robot.liftl.setPower(-0.20);
            robot.liftr.setPower(-0.20);
        }
        if (gamepad2.dpad_down){
            robot.liftl.setPower(0.20);
            robot.liftr.setPower(0.20);
        }else{
            robot.liftl.setPower(0);
            robot.liftr.setPower(0);
        }

        //CLAMP
        if (gamepad2.a){
            robot.clampl.setPosition(1);
            robot.clampr.setPosition(0);
        }else if (gamepad2.b){
            robot.clampl.setPosition(.925);
            robot.clampr.setPosition(.075);
        }

        //INTAKE CLAMP
        if (gamepad2.right_bumper){
            robot.intake_sevl.setPosition(.42);
            robot.intake_sevr.setPosition(.58);
        }else if (gamepad2.left_bumper){
            robot.intake_sevl.setPosition(0);
            robot.intake_sevr.setPosition(1);
        }

        //TELEMETRY FOR LIFT
        telemetry.addData("Left Lift Position", robot.liftl.getCurrentPosition());
        telemetry.addData("Right Lift Position", robot.liftr.getCurrentPosition());

    }
    @Override
    public void stop(){

    }
}
