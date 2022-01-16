package design_patterns.command.old

fun main() {
    val remoteControl = RemoteControlWithUndo()

    val livingRoomLight = Light()
    val lightOnCommand = LightOnCommand(livingRoomLight)
    val lightOffCommand = LightOffCommand(livingRoomLight)

    remoteControl.setCommand(0, lightOnCommand, lightOffCommand)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println(remoteControl)

    remoteControl.undoButtonWasPushed()
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(0)

    println(remoteControl)

    remoteControl.undoButtonWasPushed()

    println(remoteControl)
}
