package design_patterns.command.party

//
// This is the invoker
//
class RemoteControl {
    private val onCommands = initiateCommands()
    private val offCommands = initiateCommands()

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

        for (i in onCommands.indices) {
            stringBuffer.append("[slot $i] ${onCommands[i].javaClass.simpleName.padEnd(25)} ${offCommands[i].javaClass.simpleName}\n")
        }

        return stringBuffer.toString()
    }
}