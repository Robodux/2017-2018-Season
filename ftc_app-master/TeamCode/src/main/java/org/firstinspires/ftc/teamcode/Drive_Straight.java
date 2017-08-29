package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by Quick's on 8/28/2017.
 */

@TeleOp (name = "Straight")

public class Drive_Straight extends OpMode {

    double rightpower;
    double leftpower;
    double leftposition = -90;
    double rightposition = -100;
    double inputpower = .5;
    double distance = -1000;
    double adjustedspeed;
    double accmult;
    double dccmult;
    double diff;
    double scalingfactor = 600;
    double oneshot = 0;


    @Override
    public void init() {

    }

    @Override
    public void loop() {

        if (distance < 0 && oneshot == 0) {
            inputpower = inputpower * (-1);
            oneshot = 1;
        }

        diff = rightposition - leftposition;

        if (diff > 0 && inputpower > 0){
            rightpower = inputpower - (diff / scalingfactor);
            leftpower = inputpower;
        }

        if (diff < 0 && inputpower > 0) {
            rightpower = inputpower;
            leftpower = inputpower + (diff / scalingfactor);

        }

        if (diff > 0 && inputpower < 0) {
            rightpower = inputpower;
            leftpower = inputpower + (diff / scalingfactor);
        }

        if (diff < 0 && inputpower < 0) {
            rightpower = inputpower - (diff / scalingfactor);
            leftpower = inputpower;
        }

         if (diff == 0.0){
             rightpower = inputpower;
             leftpower = inputpower;
         }

        telemetry.addLine()
                .addData("rightpower",rightpower);
        telemetry.addLine()
                .addData("leftpower",leftpower);
}}
