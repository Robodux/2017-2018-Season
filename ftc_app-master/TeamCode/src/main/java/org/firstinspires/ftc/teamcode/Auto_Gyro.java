package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;



@TeleOp(name= "Auto_Gyro")
@Disabled
public class Auto_Gyro extends LinearOpMode {



    ColorSensor colorSensor;




    @Override
    public void runOpMode() throws InterruptedException {
        colorSensor = hardwareMap.colorSensor.get("color");
        waitForStart();

        while (opModeIsActive()){

            telemetry.addData("Red  ", colorSensor.red());
            telemetry.update();





        }


    }
}
