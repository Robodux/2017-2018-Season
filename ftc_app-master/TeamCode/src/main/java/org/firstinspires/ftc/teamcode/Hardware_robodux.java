package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware_robodux {

    public DcMotor Testmotor = null;
    public DcMotor Testmotor2 = null;
    public DcMotor Arm = null;

    HardwareMap map = null;

    public void init(HardwareMap aMap) {

        map = aMap;

        Testmotor = map.dcMotor.get("test");
        Testmotor2 = map.dcMotor.get("test2");
        Arm = map.dcMotor.get("arm");


        //set direction on motors

    }

    public void stopRobot() {

        Testmotor.setPower(0.0);
        Testmotor2.setPower(0.0);
        Arm.setPower(0.0);

    }


}
