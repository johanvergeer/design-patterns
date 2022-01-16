package design_patterns.facade.home_theater

class HomeTheaterFacade(
    private val amp: Amplifier,
    private val tuner: Tuner,
    private val player: StreamingPlayer,
    private val projector: Projector,
    private val screen: Screen,
    private val lights: TheaterLights,
    private val popper: PopcornPopper,
    private val cd: CdPlayer
) {

    fun watchMovie(movie: String) {
        println("Get ready to watch a movie...")
        this.popper.on()
        this.popper.pop()
        this.lights.dim(10)
        this.screen.down()
        this.projector.on()
        this.projector.wideScreenMode()
        this.amp.on()
        this.amp.player = this.player
        this.amp.setSurroundSound()
        this.amp.setVolume(5)
        this.player.on()
        this.player.play(movie)
    }

    fun endMovie() {
        println("Shutting movie theater down...")
        this.popper.off()
        this.lights.on()
        this.screen.up()
        this.projector.off()
        this.amp.off()
        this.player.stop()
        this.player.off()
    }

    fun listenToRadio(frequency: Double) {
        println("Tuning in the airwaves...")
        this.tuner.on()
        this.tuner.frequency = frequency
        this.amp.on()
        this.amp.setVolume(5)
        this.amp.tuner = this.tuner
    }

    fun endRadio() {
        println("Shutting down the tuner...")
        this.tuner.off()
        this.amp.off()
    }
}
