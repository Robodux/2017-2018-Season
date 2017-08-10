package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name= "Test_Code")

public class Test_Code extends OpMode {

    Hardware_robodux robot = new Hardware_robodux();


    double testpower;
    double testpower2;
    double armpower = .3;


    @Override
    public void init() {

        robot.init(hardwareMap);


    }

    @Override
    public void loop() {

        testpower = gamepad1.left_stick_y;
        testpower2 = gamepad1.right_stick_y;


        robot.Testmotor.setPower(testpower);
        robot.Testmotor2.setPower(testpower2);

        if (gamepad1.a)
            robot.Arm.setPower(armpower);
        else
            robot.Arm.setPower(0.0);

        if (gamepad1.b)
            robot.Arm.setPower(1.0);
        else
            robot.Arm.setPower(0.0);


    }
}

