package design_patterns.command.remote_undo

import java.lang.Appendable

interface Command {
    fun execute()
    fun undo()
}

class NoCommand : Command {
    override fun execute() {}
    override fun undo() {}
}

/**
 * This is the invoker
 */
class RemoteControlWithUndo {
    var undoCommand: Command = NoCommand()

    private val onCommands = this.initiateCommands()
    private val offCommands = this.initiateCommands()

    private fun initiateCommands(): Array<Command> {
        return (0 until 7).map { NoCommand() }.toTypedArray()
    }

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot].execute()
        undoCommand = onCommands[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot].execute()
        undoCommand = offCommands[slot]
    }

    fun undoButtonWasPushed() {
        undoCommand.undo()
    }

    override fun toString(): String {
        val stringBuilder: Appendable = StringBuilder()
        stringBuilder.append("\n------ Remote Control -------\n")
        for (i in onCommands.indices) {
            stringBuilder.append(
                """[slot $i] ${onCommands[i].javaClass.name}    ${offCommands[i].javaClass.name}
"""
            )
        }
        stringBuilder.append(
            """
    [undo] ${undoCommand.javaClass.name}
    
            """.trimIndent()
        )
        return stringBuilder.toString()
    }
}

//region Light with commands
class Light(var location: String) {
    var level = 0

    fun on() {
        this.level = 100
        println("Light is on")
    }

    fun off() {
        this.level = 0
        println("Light is off")
    }

    fun dim(level: Int) {
        this.level = level
        if (level == 0) {
            this.off()
        } else {
            println("Light is dimmed to $level%")
        }
    }
}

abstract class LightCommand(protected val light: Light) : Command {
    var level = 0

    final override fun execute() {
        this.level = this.light.level
        this.switchLight()
    }

    final override fun undo() {
        this.light.dim(this.level)
    }

    /**
     * Switch the [light] on or off
     */
    protected abstract fun switchLight()
}

class LightOffCommand(light: Light) : LightCommand(light) {
    override fun switchLight() {
        this.light.off()
    }
}

class LightOnCommand(light: Light) : LightCommand(light) {
    override fun switchLight() {
        this.light.on()
    }
}
//endregion

//region CeilingFan with commands
enum class Speed { OFF, LOW, MEDIUM, HIGH }

class CeilingFan(private val location: String) {
    var speed: Speed = Speed.OFF
        private set

    fun high() {
        speed = Speed.HIGH
        println("$location ceiling fan is on high")
    }

    fun medium() {
        speed = Speed.MEDIUM
        println("$location ceiling fan is on medium")
    }

    fun low() {
        speed = Speed.LOW
        println("$location ceiling fan is on low")
    }

    fun off() {
        speed = Speed.OFF
        println("$location ceiling fan is off")
    }
}

abstract class CeilingFanCommand(protected val ceilingFan: CeilingFan) : Command {
    private var prevSpeed = Speed.OFF

    final override fun undo() = when (prevSpeed) {
        Speed.HIGH -> ceilingFan.high()
        Speed.MEDIUM -> ceilingFan.medium()
        Speed.LOW -> ceilingFan.low()
        Speed.OFF -> ceilingFan.off()
    }

    final override fun execute() {
        prevSpeed = this.ceilingFan.speed
        this.setSpeed()
    }

    /**
     * Set the [ceilingFan] to the correct speed
     */
    protected abstract fun setSpeed()
}

class CeilingFanHighCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.high()
    }
}

class CeilingFanLowCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.low()
    }
}

class CeilingFanMediumCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.medium()
    }
}

class CeilingFanOffCommand(ceilingFan: CeilingFan) : CeilingFanCommand(ceilingFan) {
    override fun setSpeed() {
        this.ceilingFan.off()
    }
}
//endregion

fun main() {
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
