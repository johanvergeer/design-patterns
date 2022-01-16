package design_patterns.command

fun main() {
    val remoteControl = RemoteControl()

    val livingRoomLight = Light()
    val kitchenLight = Light()
    val ceilingFan = CeilingFan()
    val garageDoor = GarageDoor()
    val stereo = Stereo()

    val livingRoomLightOn = LightOnCommand(livingRoomLight)
    val livingRoomLightOff = LightOffCommand(livingRoomLight)
    val kitchenLightOn = LightOnCommand(kitchenLight)
    val kitchenLightOff = LightOffCommand(kitchenLight)

    val ceilingFanOn = CeilingFanHighCommand(ceilingFan)
    val ceilingFanOff = CeilingFanOffCommand(ceilingFan)

    val garageDoorOpen = GarageDoorOpenCommand(garageDoor)
    val garageDoorClose = GarageDoorCloseCommand(garageDoor)

    val stereoOnWithCD = StereoOnWithCDCommand(stereo)
    val stereoOff = StereoOffCommand(stereo)

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff)
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff)
    remoteControl.setCommand(3, garageDoorOpen, garageDoorClose)
    remoteControl.setCommand(4, stereoOnWithCD, stereoOff)

    println(remoteControl)
}