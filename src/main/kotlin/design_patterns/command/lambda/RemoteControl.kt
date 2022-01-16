package design_patterns.command.lambda

//
// This is the invoker
//
class RemoteControl {
    private val onCommands = initiateCommands()
    private val offCommands = initiateCommands()

    private fun initiateCommands(): Array<Command> {
        return (0 until 7).map { Command {} }.toTypedArray()
    }

    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        onCommands[slot] = onCommand
        offCommands[slot] = offCommand
    }

    fun onButtonWasPushed(slot: Int) {
        onCommands[slot].execute()
    }

    fun offButtonWasPushed(slot: Int) {
        offCommands[slot].execute()
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