package design_patterns.command.old

class RemoteControlWithUndo {
    private val onCommands = initiateCommands()
    private val offCommands = initiateCommands()
    private var undoComand: Command = NoCommand()

    private fun initiateCommands(): Array<Command> {
        return (0 until 7).map { NoCommand() }.toTypedArray()
    }

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        this.onCommands[slot] = onCommand
        this.offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        this.onCommands[slot].execute()
        this.undoComand = onCommands[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        this.offCommands[slot].execute()
        this.undoComand = offCommands[slot]
    }

    fun undoButtonWasPushed() {
        undoComand.undo()

        this.undoComand = NoCommand()
    }

    override fun toString(): String {
        val stringBuffer = StringBuffer()
        stringBuffer.append("\n----- Remote Control -----\n")

        for (i in onCommands.indices) {
            val onCommandName = onCommands[i].javaClass.simpleName
            val offCommandName = offCommands[i].javaClass.simpleName
            stringBuffer.append("[slot $i] ${onCommandName.padEnd(25)} ${offCommandName}\n")
        }

        stringBuffer.append("[undo] ${undoComand.javaClass.simpleName}")
        stringBuffer.append("\n")

        return stringBuffer.toString()
    }
}
