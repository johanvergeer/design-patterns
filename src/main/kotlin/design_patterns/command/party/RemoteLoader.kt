package design_patterns.command.party

object RemoteLoader {
    @JvmStatic
    fun main(args: Array<String>) {
        val remoteControl = RemoteControl()

        val light = Light("Living Room")
        val tv = TV("Living Room")
        val stereo = Stereo("Living Room")
        val hottub = Hottub()

        val lightOn = LightOnCommand(light)
        val stereoOn = StereoOnCommand(stereo)
        val tvOn = TVOnCommand(tv)
        val hottubOn = HottubOnCommand(hottub)

        val lightOff = LightOffCommand(light)
        val stereoOff = StereoOffCommand(stereo)
        val tvOff = TVOffCommand(tv)
        val hottubOff = HottubOffCommand(hottub)

        val partyOn = arrayOf(lightOn, stereoOn, tvOn, hottubOn)
        val partyOff = arrayOf(lightOff, stereoOff, tvOff, hottubOff)
        val partyOnMacro = MacroCommand(partyOn)
        val partyOffMacro = MacroCommand(partyOff)

        remoteControl.setCommand(0, partyOnMacro, partyOffMacro)
        println(remoteControl)
        println("--- Pushing Macro On---")
        remoteControl.onButtonWasPushed(0)
        println("--- Pushing Macro Off---")
        remoteControl.offButtonWasPushed(0)
    }
}