package design_patterns.command.remote

class HottubOffCommand(private val hottub: Hottub) : Command {
    override fun execute() {
        this.hottub.cool()
        this.hottub.off()
    }
}
