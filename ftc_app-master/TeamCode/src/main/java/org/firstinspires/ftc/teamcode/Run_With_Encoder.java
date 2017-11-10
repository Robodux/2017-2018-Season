package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.configuration.MotorConfiguration;

/**
 * Created by Quick's on 9/21/2017.
 */
@Autonomous
@Disabled
public class Run_With_Encoder extends OpMode{

    Hardware_robodux robot = new Hardware_robodux();

    @Override
    public void init () {
        robot.init(hardwareMap);

        //robot.left_rear_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //robot.right_rear_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //robot.left_rear_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //robot.right_rear_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //robot.left_rear_drive.setTargetPosition(2000);
        robot.left_front_drive.setTargetPosition(2000);
        robot.right_front_drive.setTargetPosition(2000);
        //robot.right_rear_drive.setTargetPosition(2000);

        //robot.left_rear_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //robot.right_rear_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    @Override
    public void loop () {

        //robot.left_rear_drive.setPower(.7);
        robot.left_front_drive.setPower(.7);
        //robot.right_rear_drive.setPower(.7);
        robot.right_front_drive.setPower(.7);
    }
    @Override
    public void stop () {
        //robot.left_rear_drive.setPower(0);
        robot.left_front_drive.setPower(0);
        //robot.right_rear_drive.setPower(0);
        robot.right_front_drive.setPower(0);
    }
}
