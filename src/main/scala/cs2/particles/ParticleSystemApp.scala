package cs2.particles
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer

object ParticleSystemApp extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Particles!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            val p = new Particle(new Vec2(300,100), new Vec2(0.2,0.4))
            p.display(g)

            val timer = AnimationTimer(t => {
                p.display(g)
                p.timeStep()
            })
            timer.start


        }
    }
}