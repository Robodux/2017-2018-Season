package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp (name= "Test_code")

public class Test_Code extends OpMode {

    Hardware_robodux robot = new Hardware_robodux();
    BNO055IMU imu;

    double testpower;
    double testpower2;
    double armpower = .3;
    Orientation angle;
    double heading;



    @Override
    public void init() {

        robot.init(hardwareMap);
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;

        imu.initialize(parameters);

    }

    @Override
    public void loop() {

        testpower = gamepad1.left_stick_y;
        testpower2 = gamepad1.right_stick_y;

        angle = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        heading = angle.firstAngle;

        telemetry.addLine()
                .addData("Heading",heading);

        robot.Testmotor.setPower(testpower);
        robot.Testmotor2.setPower(testpower2);

        if (gamepad1.a)
            robot.Arm.setPower(armpower);
        else
            robot.Arm.setPower(0.0);

        //if (gamepad1.b)
            //robot.Arm.setPower(1.0);
        //else
            //robot.Arm.setPower(0.0);

    }
    public void zeroTurn(double targetHeading, double turnSpeed){
        if (heading > targetHeading)
            robot.Testmotor.setPower(turnSpeed);
            robot.Testmotor2.setPower(-turnSpeed);
        else if (heading < targetHeading)
            robot.Testmotor.setPower(-turnSpeed);
            robot.Testmotor2.setPower(turnSpeed);

    }
}

