package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Quick's on 9/19/2017.
 */

@TeleOp(name = "POV_Test")
@Disabled
public class POV_Test extends OpMode{

    Hardware_robodux robot = new Hardware_robodux();
    double lefta, righta, max;
    @Override
    public void init(){

        robot.init(hardwareMap);

        robot.right_rear_drive.setDirection(DcMotorSimple.Direction.REVERSE);
        robot.right_front_drive.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void init_loop(){

    }
    @Override
    public void loop(){

        double  leftb = Math.pow(lefta , 3);
        double rightb = Math.pow(righta , 3);

        lefta  = -gamepad1.left_stick_y + gamepad1.right_stick_x;
        righta = -gamepad1.left_stick_y - gamepad1.right_stick_x;

        max = Math.max(Math.abs(leftb), Math.abs(rightb));
        if (max > 1.0)
        {
            leftb /= max;
            rightb /= max;
        }
/*
        robot.right_front_drive.setPower(righta);
        robot.right_rear_drive.setPower(righta);
        robot.left_front_drive.setPower(lefta);
        robot.left_rear_drive.setPower(lefta);

        telemetry.addData("left",  "%.2f", lefta);
        telemetry.addData("right", "%.2f", righta);
        telemetry.update();

*/
        robot.right_front_drive.setPower(rightb);
        robot.right_rear_drive.setPower(rightb);
        robot.left_front_drive.setPower(leftb);
        robot.left_rear_drive.setPower(leftb);

        telemetry.addData("left",  "%.2f", leftb);
        telemetry.addData("right", "%.2f", rightb);
        telemetry.update();

    }
    @Override
    public void stop(){
        robot.right_front_drive.setPower(0.0);
        robot.right_rear_drive.setPower(0.0);
        robot.left_front_drive.setPower(0.0);
        robot.left_rear_drive.setPower(0.0);
    }

}
