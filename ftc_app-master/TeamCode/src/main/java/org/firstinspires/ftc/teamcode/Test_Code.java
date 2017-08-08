package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name= "Test_Code")

public class Test_Code extends OpMode {

DcMotor Testmotor;
    DcMotor Testmotor2;
    DcMotor Arm;
    double testpower;
    double testpower2;
    double armpower = .3;


    @Override
    public void init() {
        Testmotor = (DcMotor) hardwareMap.dcMotor.get("test");
        Testmotor2 = (DcMotor) hardwareMap.dcMotor.get("test2");
        Arm = (DcMotor) hardwareMap.dcMotor.get("arm");


    }

    @Override
    public void loop() {

        testpower = gamepad1.left_stick_y;
        testpower2 = gamepad1.right_stick_y;


        Testmotor.setPower(testpower);
        Testmotor2.setPower(testpower2);

        if (gamepad1.a)
            Arm.setPower(armpower);
        else
            Arm.setPower(0.0);

        if (gamepad1.b)
            Arm.setPower(1.0);
        else
            Arm.setPower(0.0);




    }
}

