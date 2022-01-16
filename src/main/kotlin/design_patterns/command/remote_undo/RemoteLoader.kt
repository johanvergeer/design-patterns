package design_patterns.command.remote_undo

object RemoteLoader {
    @JvmStatic
    fun main(args: Array<String>) {
        val remoteControl = RemoteControlWithUndo()
        val livingRoomLight = Light("Living Room")
        val livingRoomLightOn = LightOnCommand(livingRoomLight)
        val livingRoomLightOff = LightOffCommand(livingRoomLight)

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
        remoteControl.onButtonWasPushed(0)
        remoteControl.offButtonWasPushed(0)
        println(remoteControl)

        remoteControl.undoButtonWasPushed()
        remoteControl.offButtonWasPushed(0)
        remoteControl.onButtonWasPushed(0)
        println(remoteControl)

        remoteControl.undoButtonWasPushed()

        val ceilingFan = CeilingFan("Living Room")
        val ceilingFanMedium = CeilingFanMediumCommand(ceilingFan)
        val ceilingFanHigh = CeilingFanHighCommand(ceilingFan)
        val ceilingFanOff = CeilingFanOffCommand(ceilingFan)

        remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff)
        remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff)
        remoteControl.onButtonWasPushed(0)
        remoteControl.offButtonWasPushed(0)
        println(remoteControl)

        remoteControl.undoButtonWasPushed()
        remoteControl.onButtonWasPushed(1)
        println(remoteControl)

        remoteControl.undoButtonWasPushed()
    }
}
