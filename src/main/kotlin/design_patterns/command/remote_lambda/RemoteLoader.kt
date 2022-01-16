package design_patterns.command.remote_lambda

object RemoteLoader {
    @JvmStatic
    fun main(args: Array<String>) {
        val remoteControl = RemoteControl()

        val livingRoomLight = Light("Living Room")
        val kitchenLight = Light("Kitchen")
        val ceilingFan = CeilingFan("Living Room")
        val garageDoor = GarageDoor("Main house")
        val stereo = Stereo("Living Room")

        remoteControl.setCommand(0, { livingRoomLight.on() }) { livingRoomLight.off() }
        remoteControl.setCommand(1, { kitchenLight.on() }) { kitchenLight.off() }
        remoteControl.setCommand(2, { ceilingFan.high() }) { ceilingFan.off() }

        val stereoOnWithCD = Command {
            stereo.on()
            stereo.setCD()
            stereo.setVolume(11)
        }

        remoteControl.setCommand(3, stereoOnWithCD) { stereo.off() }
        remoteControl.setCommand(4, { garageDoor.up() }) { garageDoor.down() }

        println(remoteControl)

        remoteControl.onButtonWasPushed(0)
        remoteControl.offButtonWasPushed(0)
        remoteControl.onButtonWasPushed(1)
        remoteControl.offButtonWasPushed(1)
        remoteControl.onButtonWasPushed(2)
        remoteControl.offButtonWasPushed(2)
        remoteControl.onButtonWasPushed(3)
        remoteControl.offButtonWasPushed(3)
        remoteControl.onButtonWasPushed(4)
        remoteControl.offButtonWasPushed(4)
        remoteControl.onButtonWasPushed(5)
    }
}
