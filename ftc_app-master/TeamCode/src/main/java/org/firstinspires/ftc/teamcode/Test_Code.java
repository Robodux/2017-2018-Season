package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name= "Test_Code")

public class Test_Code extends OpMode {

DcMotor Testmotor;
    double testpower;

    @Override
    public void init() {
        Testmotor = (DcMotor) hardwareMap.dcMotor.get("test");

    }

    @Override
    public void loop() {

        testpower = gamepad1.left_stick_y;

        Testmotor.setPower(testpower);


    }
}

