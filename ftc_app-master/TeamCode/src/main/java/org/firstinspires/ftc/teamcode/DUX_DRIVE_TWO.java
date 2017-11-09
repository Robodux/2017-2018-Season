package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Quick's on 10/14/2017.
 */

@TeleOp(name = "DUX_DRIVE 2.0")

public class DUX_DRIVE_TWO extends OpMode {
    Hardware_robodux robot = new Hardware_robodux();

    boolean ready = true;
    boolean oneshot = false;

    int state = 1;

    int floor = 0;//Floor position for intake
    int low = 65;//Low intake position
    int storage = 415;//Storage Position for lift
    int highpos = 810;// High position for lift
    int top = 1160;//top position for lift

    double liftpower = .7;
    double delay = .1;

    double intakepos = 0;
    double clamppos = 0;

    double clampopen = .2;
    double clampclosed = .095;

    double intakeopen = 0.12;
    double intakeallopen = .43;
    double intakeclosed = 0;
    double time;

    double reset = 0;

    double rightpower = 0;
    double leftpower = 0;

    double lefta, righta, max;

    public LynxI2cColorRangeSensor color1 = null;
    @Override
    public void init() {

        robot.init(hardwareMap);
        color1 = hardwareMap.get(LynxI2cColorRangeSensor.class, "color1");

        robot.liftr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.liftl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //robot.intake_sevr.setPosition(.8);
        //robot.intake_sevl.setPosition(.2);

        robot.clampl.setPosition(.81);
        robot.clampr.setPosition(.19);

        robot.liftr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.liftl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }

    @Override
    public void loop() {

        /*telemetry.addData("State", state);
        telemetry.addData("Right Pos", robot.liftr.getCurrentPosition());
        telemetry.addData("Left Pos", robot.liftl.getCurrentPosition());
        telemetry.addData("Right Power", robot.liftr.getPower());
        telemetry.addData("Left Power", robot.liftl.getPower());
        telemetry.update();*/

        robot.intake_sevr.setPosition(1 - intakepos);
        robot.intake_sevl.setPosition(intakepos);

        robot.clampr.setPosition(clamppos);
        robot.clampl.setPosition(1 - clamppos);
/*
        robot.right_front_drive.setPower(gamepad1.right_stick_y);
        robot.right_rear_drive.setPower(gamepad1.right_stick_y);

        robot.left_front_drive.setPower(gamepad1.left_stick_y);
        robot.left_rear_drive.setPower(gamepad1.left_stick_y);
*/

        //telemetry.addData("right motor speed", robot.right_front_drive);
        //telemetry.addData("left motor speed", robot.left_front_drive);
        //telemetry.addData("blue", color1.blue());
        //telemetry.addData("Red", color1.red());


        if(gamepad1.right_bumper){
            rightpower = -gamepad1.right_stick_y/2;
            leftpower = -gamepad1.left_stick_y/2;
        }
        else if(gamepad1.left_bumper){
            rightpower = (-gamepad1.left_stick_y/3)-(gamepad1.left_stick_x/6);
            leftpower = (-gamepad1.left_stick_y/3)+(gamepad1.left_stick_x/6);
        }
        else{
            rightpower = -gamepad1.right_stick_y * 0.85;
            leftpower = -gamepad1.left_stick_y * 0.85;
        }

        robot.right_front_drive.setPower(rightpower);
        robot.right_rear_drive.setPower(rightpower);
        robot.left_front_drive.setPower(leftpower);
        robot.left_rear_drive.setPower(leftpower);

        if(gamepad2.right_trigger > 0 && gamepad2.left_trigger == 0){
            robot.intakel.setPower(1);
            robot.intaker.setPower(1);
        }
        if(gamepad2.left_trigger > 0){
            robot.intakel.setPower(.6);
            robot.intaker.setPower(-.27);
        }
        if(gamepad2.right_trigger == 0 && gamepad2.left_trigger == 0){
            robot.intakel.setPower(0);
            robot.intaker.setPower(0);
        }

        //STORE FIRST BLOCK
        if (gamepad2.left_bumper && ready && state ==1) {
            reset = 0;
            state = 3;
            oneshot = false;
            ready = false;
        }
        if (state == 2 && ready && reset == 0) {
            state = 3;
            oneshot = false;
            ready = false;
        }
        if (state == 3 && ready) {
            state = 4;
            oneshot = false;
            ready = false;
        }
        if (state == 4 && ready) {
            state = 5;
            oneshot = false;
            ready = false;
        }
        //STORE SECOND BLOCK
        if (gamepad2.left_bumper && ready && (state == 5 || state ==12)) {
            state = 7;
            oneshot = false;
            ready = false;
        }
        /*if (state ==6 && ready) {
            state = 7;
            oneshot = false;
            ready = false;
        }*/
        if (state ==7 && ready) {
            state = 8;
            oneshot = false;
            ready = false;
        }
        if (state ==8 && ready) {
            state = 9;
            oneshot = false;
            ready = false;
        }
        // OPEN THE CLAMP IF SCORING AT BOTTOM
        if (state ==9 && ready && gamepad2.dpad_left) {
            state = 14;
            oneshot = false;
            ready = false;
        }
        // SCORE ONE BLOCK UP
        if ((state ==9 || state ==10 || state == 15 || state == 5) && ready && gamepad2.x) {
            state = 12;
            oneshot = false;
            ready = false;
        }
        // OPEN CLAMP TO SCORE
        if (state ==12 && ready && gamepad2.dpad_left) {
            state = 13;
            oneshot = false;
            ready = false;
        }
        // SCORE TWO BLOCKS UP
        if ((state ==9 || state == 12 || state == 15 || state == 5) && ready && gamepad2.y) {
            state = 10;
            oneshot = false;
            ready = false;
        }
        // OPEN CLAMPS AT TWO SCORING POSITION
        if (state ==10 && ready && gamepad2.dpad_left) {
            state = 11;
            oneshot = false;
            ready = false;
        }
        // SCORE THREE BLOCKS UP
        if ((state ==9 || state ==10 || state == 12 || state ==5) && ready && gamepad2.b) {
            state = 15;
            oneshot = false;
            ready = false;
        }
        // OPEN CLAMPS AT THREE SCORING POSITION
        if (state ==15 && ready && gamepad2.dpad_left) {
            state = 16;
            oneshot = false;
            ready = false;
        }
        //BACK TO FLOOR
        if ((state ==10 || state ==12 || state == 15 || state ==5) && ready && gamepad2.a) {
            state = 9;
            oneshot = false;
            ready = false;
        }
        // RESET TO STATE ONE
        if ( ready && gamepad2.dpad_down) {
            reset = 1;
            state = 2;
            oneshot = false;
            ready = false;
        }
        if (state ==2 && ready && reset == 1) {
            state = 1;
            oneshot = false;
            ready = false;
        }
        if (state == 1) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
            robot.liftr.setTargetPosition(floor);
            robot.liftr.setPower(liftpower);
            robot.liftl.setTargetPosition(floor);
            robot.liftl.setPower(liftpower);

            intakepos = (intakeclosed);

            clamppos = (clampopen);

            if (robot.liftr.getCurrentPosition() > floor - 10 && robot.liftr.getCurrentPosition() < floor + 10 && (time + delay) < getRuntime()) {
                ready = true;
            }

        }

        if (state == 2) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
            robot.liftr.setTargetPosition(floor);
            robot.liftr.setPower(liftpower);
            robot.liftl.setTargetPosition(floor);
            robot.liftl.setPower(liftpower);


            intakepos = (intakeclosed);

            clamppos = (clampclosed);

            if (robot.liftr.getCurrentPosition() > floor - 20 && robot.liftr.getCurrentPosition() < floor + 20 && (time + delay) < getRuntime()) {
                ready = true;
            }
        }

        if (state == 3) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(floor);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(floor);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeopen);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > floor - 20 && robot.liftr.getCurrentPosition() < floor + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 4) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeopen);

                clamppos = (clampclosed);


                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 5) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeclosed);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 6) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeclosed);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 7) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 8) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(floor);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(floor);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > floor - 20 && robot.liftr.getCurrentPosition() < floor + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 9) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(low);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(low);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > low - 20 && robot.liftr.getCurrentPosition() < low + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 10) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(highpos);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(highpos);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > highpos - 20 && robot.liftr.getCurrentPosition() < highpos + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 11) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(highpos);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(highpos);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > highpos - 20 && robot.liftr.getCurrentPosition() < highpos + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 12) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 13) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(storage);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(storage);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > storage - 20 && robot.liftr.getCurrentPosition() < storage + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 14) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(low);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(low);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > low - 20 && robot.liftr.getCurrentPosition() < low + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }

        if (state == 15) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(top);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(top);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampclosed);

                if (robot.liftr.getCurrentPosition() > top - 20 && robot.liftr.getCurrentPosition() < top + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }


        if (state == 16) {

            if (oneshot == false) {
                time = getRuntime();
                ready = false;
                oneshot = true;
            }
                robot.liftr.setTargetPosition(top);
                robot.liftr.setPower(liftpower);
                robot.liftl.setTargetPosition(top);
                robot.liftl.setPower(liftpower);

                intakepos = (intakeallopen);

                clamppos = (clampopen);

                if (robot.liftr.getCurrentPosition() > top - 20 && robot.liftr.getCurrentPosition() < top + 20 && (time + delay) < getRuntime()) {
                    ready = true;
                }
        }
    }

    @Override
    public void stop() {

    }
}
