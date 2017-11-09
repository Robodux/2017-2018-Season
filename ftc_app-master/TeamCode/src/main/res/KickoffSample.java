import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Quick's on 9/9/2017.
 */
@Autonomous (name = "kickoff sample")
public class KickoffSample extends LinearOpMode {

    //stop and reset encoder
    idle() //wait time to reset encoder

    waitForStart()

        leftdrive.settargetpostition (4000)
        leftdrive.setmode run to postiton

            setpower

        while (Opmodeis active)&& leftdrive.isbusy || rightdriveisbusy

        telemetry.adddata
        telemetry.update //updates the telemetry

    //reset the mode to run without encoder

    //isbusy means that the motor is still turning


}
