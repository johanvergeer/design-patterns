package design_patterns.command.remote

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
        val stringBuff = StringBuffer()
        stringBuff.append("\n------ Remote Control -------\n")
        for (i in this.onCommands.indices) {
            stringBuff.append(
                """[slot $i] ${this.onCommands[i].javaClass.name}    ${this.offCommands[i].javaClass.name}
"""
            )
        }
        return stringBuff.toString()
    }
}
