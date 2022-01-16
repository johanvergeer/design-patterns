package design_patterns.command.old

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
        val stringBuffer = StringBuffer()
        stringBuffer.append("\n----- Remote Control -----\n")

        for (i in this.onCommands.indices) {
            val onCommandName = this.onCommands[i].javaClass.simpleName
            val offCommandName = this.offCommands[i].javaClass.simpleName
            stringBuffer.append("[slot $i] ${onCommandName.padEnd(25)} ${offCommandName}\n")
        }

        return stringBuffer.toString()
    }
}
