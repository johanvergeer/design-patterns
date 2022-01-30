package design_patterns.command.remote_lambda

fun interface Command {
    fun execute()
}

class RemoteControl {
    private val onCommands = this.initiateCommands()
    private val offCommands = this.initiateCommands()

    /**
     * Initiates the Lambda-powered commands
     *
     * Note this implementation doesn't require a `NoCommand` class
     * like we used in [design_patterns.command.remote.RemoteControl].
     */
    private fun initiateCommands(): Array<Command> {

        return (0 until 7).map { Command {} }.toTypedArray()
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
        val stringBuilder: Appendable = StringBuilder()
        stringBuilder.append("\n----- Remote Control -----\n")

        for (i in this.onCommands.indices) {
            val onCommandName = this.onCommands[i].javaClass.simpleName
            val offCommandName = this.offCommands[i].javaClass.simpleName
            stringBuilder.append("[slot $i] ${onCommandName.padEnd(25)} ${offCommandName}\n")
        }

        return stringBuilder.toString()
    }
}

enum class CeilingFanSpeed { OFF, LOW, MEDIUM, HIGH }

class CeilingFan(private val location: String = "") {
    var speed = CeilingFanSpeed.OFF

    fun high() {
        // turns the ceiling fan on to high
        this.speed = CeilingFanSpeed.HIGH
        println("${this.location} ceiling fan is on high")
    }

    fun medium() {
        // turns the ceiling fan on to medium
        this.speed = CeilingFanSpeed.MEDIUM
        println("${this.location} ceiling fan is on medium")
    }

    fun low() {
        // turns the ceiling fan on to low
        this.speed = CeilingFanSpeed.LOW
        println("${this.location} ceiling fan is on low")
    }

    fun off() {
        // turns the ceiling fan off
        this.speed = CeilingFanSpeed.OFF
        println("${this.location} ceiling fan is off")
    }
}

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

    fun setDVD() {
        println("${this.location} stereo is set for DVD input")
    }

    fun setRadio() {
        println("${this.location} stereo is set for Radio")
    }

    fun setVolume(volume: Int) {
        // code to set the volume
        // valid range: 1-11 (after all 11 is better than 10, right?)
        println("${this.location} stereo volume set to $volume")
    }
}

class GarageDoor(private val location: String) {
    fun up() {
        println("${this.location} garage Door is Up")
    }

    fun down() {
        println("${this.location} garage Door is Down")
    }

    fun stop() {
        println("${this.location} garage Door is Stopped")
    }

    fun lightOn() {
        println("${this.location} garage light is on")
    }

    fun lightOff() {
        println("${this.location} garage light is off")
    }
}

class Light(private val location: String) {
    fun on() {
        println("${this.location} light is on")
    }

    fun off() {
        println("${this.location} light is off")
    }
}

fun main() {
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
    remoteControl.offButtonWasPushed(5)
}
