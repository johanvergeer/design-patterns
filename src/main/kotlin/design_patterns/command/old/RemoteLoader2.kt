package design_patterns.command.old

fun main() {
    val remoteControl = RemoteControlWithUndo()

    val ceilingFan = CeilingFan("Living Room")

    val ceilingFanMedium = CeilingFanMediumCommand(ceilingFan)
    val ceilingFaHigh = CeilingFanHighCommand(ceilingFan)
    val ceilingFanLow = CeilingFanLowCommand(ceilingFan)
    val ceilingFanOff = CeilingFanOffCommand(ceilingFan)

    remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff)
    remoteControl.setCommand(1, ceilingFaHigh, ceilingFanOff)
    remoteControl.setCommand(2, ceilingFanLow, ceilingFanOff)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println(remoteControl)

    remoteControl.undoButtonWasPushed()
    println(remoteControl)

    remoteControl.onButtonWasPushed(1)
    println(remoteControl)

    remoteControl.undoButtonWasPushed()
}
