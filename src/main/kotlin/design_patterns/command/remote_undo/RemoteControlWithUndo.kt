package design_patterns.command.remote_undo

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
        val stringBuff = StringBuffer()
        stringBuff.append("\n------ Remote Control -------\n")
        for (i in onCommands.indices) {
            stringBuff.append(
                """[slot $i] ${onCommands[i].javaClass.name}    ${offCommands[i].javaClass.name}
"""
            )
        }
        stringBuff.append(
            """
    [undo] ${undoCommand.javaClass.name}
    
            """.trimIndent()
        )
        return stringBuff.toString()
    }
}
