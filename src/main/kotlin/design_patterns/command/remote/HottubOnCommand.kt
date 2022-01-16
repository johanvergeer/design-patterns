package design_patterns.command.remote

class HottubOnCommand(private val hottub: Hottub) : Command {
    override fun execute() {
        this.hottub.on()
        this.hottub.heat()
        this.hottub.bubblesOn()
    }
}
