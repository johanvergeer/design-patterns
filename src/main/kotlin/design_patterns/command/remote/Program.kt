package design_patterns.command.remote

enum class Speed { OFF, LOW, MEDIUM, HIGH }

interface Command {
    fun execute()
}

class NoCommand : Command {
    override fun execute() {}
}

/**
 * This is the invoker
 */
class RemoteControl {
    private val onCommands = this.initiateCommands()
    private val offCommands = this.initiateCommands()

    private fun initiateCommands(): Array<Command> {
        return (0 until 7).map { NoCommand() }.toTypedArray()
    }

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        this.onCommands[slot] = onCommand
        this.offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        this.onCommands[slot].execute()
    }

    fun offButtonWasPushed(slot: Int) {
        this.offCommands[slot].execute()
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        stringBuilder.appendLine("------ Remote Control -------")
        for (i in this.onCommands.indices) {
            stringBuilder.appendLine(
                "[slot $i] ${this.onCommands[i].javaClass.name}    ${this.offCommands[i].javaClass.name}"
            )
        }
        return stringBuilder.toString()
    }
}

//region Stereo with commands
class Stereo(private val location: String) {
    fun on() {
        println("${this.location} stereo is on")
    }

    fun off() {
        println("${this.location} stereo is off")
    }

    fun setCD() {
        println("${this.location} stereo is set for CD input")
    }

    fun setVolume(volume: Int) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        println("${this.location} stereo volume set to $volume")
    }
}

class StereoOnWithCDCommand(private val stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.on()
        this.stereo.setCD()
        this.stereo.setVolume(11)
    }
}

class StereoOffCommand(private val stereo: Stereo) : Command {
    override fun execute() {
        this.stereo.off()
    }
}
//endregion

//region Light with commands
class Light(private val location: String) {

    fun on() {
        println("${this.location} light is on")
    }

    fun off() {
        println("${this.location} light is off")
    }
}

class LightOnCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.on()
    }
}

class LightOffCommand(private val light: Light) : Command {
    override fun execute() {
        this.light.off()
    }
}
//endregion

//region CeilingFan with commands
class CeilingFan(private val location: String = "") {
    var speed: Speed = Speed.LOW
        private set

    /**
     * turns the ceiling fan on to high
     */
    fun high() {
        this.speed = Speed.HIGH
        println("${this.location} ceiling fan is on high")
    }

    /**
     * turns the ceiling fan on to medium
     */
    fun medium() {
        this.speed = Speed.MEDIUM
        println("${this.location} ceiling fan is on medium")
    }

    /**
     * turns the ceiling fan on to low
     */
    fun low() {
        this.speed = Speed.LOW
        println("${this.location} ceiling fan is on low")
    }

    /**
     * turns the ceiling fan off
     */
    fun off() {
        this.speed = Speed.OFF
        println("${this.location} ceiling fan is off")
    }
}

class CeilingFanOnCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        this.ceilingFan.high()
    }
}

class CeilingFanOffCommand(private val ceilingFan: CeilingFan) : Command {
    override fun execute() {
        this.ceilingFan.off()
    }
}
//endregion

fun main() {
    val remoteControl = RemoteControl()

    val livingRoomLight = Light("Living Room")
    val kitchenLight = Light("Kitchen")
    val ceilingFan = CeilingFan("Living Room")
    val stereo = Stereo("Living Room")

    val livingRoomLightOn = LightOnCommand(livingRoomLight)
    val livingRoomLightOff = LightOffCommand(livingRoomLight)

    val kitchenLightOn = LightOnCommand(kitchenLight)
    val kitchenLightOff = LightOffCommand(kitchenLight)

    val ceilingFanOn = CeilingFanOnCommand(ceilingFan)
    val ceilingFanOff = CeilingFanOffCommand(ceilingFan)

    val stereoOnWithCD = StereoOnWithCDCommand(stereo)
    val stereoOff = StereoOffCommand(stereo)

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff)
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff)
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff)
    remoteControl.setCommand(3, stereoOnWithCD, stereoOff)

    println(remoteControl)

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(1)
    remoteControl.offButtonWasPushed(1)
    remoteControl.onButtonWasPushed(2)
    remoteControl.offButtonWasPushed(2)
    remoteControl.onButtonWasPushed(3)
    remoteControl.offButtonWasPushed(3)
}
