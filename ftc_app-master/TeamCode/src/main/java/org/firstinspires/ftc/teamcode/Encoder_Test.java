package org.firstinspires.ftc.teamcode;

        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.OpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Quick's on 9/28/2017.
 */
@TeleOp(name="Encoder")
@Disabled
public class Encoder_Test extends OpMode {

    Hardware_robodux robot = new Hardware_robodux();

    @Override
    public void init(){
        robot.init(hardwareMap);

        robot.left_front_drive.setDirection(DcMotor.Direction.REVERSE);

        robot.left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    @Override
    public void loop(){
        telemetry.addData("Right Motor Position", robot.right_front_drive.getCurrentPosition());
        telemetry.addData("Left Motor Position", robot.left_front_drive.getCurrentPosition());
        telemetry.addData("Left Motor Mode", robot.left_front_drive.getMode());
        telemetry.addData("Left Motor Target", robot.left_front_drive.getTargetPosition());
        telemetry.addData("Left Motor Power", robot.left_front_drive.getPower());



        robot.left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.right_front_drive.setTargetPosition(200);
        robot.left_front_drive.setTargetPosition(-200);

        robot.left_front_drive.setPower(.4);
        robot.right_front_drive.setPower(.4);

    }
    @Override
    public void stop(){


    }
}
