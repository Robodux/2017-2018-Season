package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Quick's on 10/14/2017.
 */
@TeleOp (name = "Elapsed Time")
@Disabled
public class Elapsed_Time extends OpMode {


    double time;
    @Override
    public void init(){

    }

    @Override
    public void loop(){

        time = getRuntime();

        if (gamepad1.a){
            resetStartTime();
        }

        telemetry.addData("time", time);
        telemetry.update();
    }

    @Override
    public void stop(){

    }
}
