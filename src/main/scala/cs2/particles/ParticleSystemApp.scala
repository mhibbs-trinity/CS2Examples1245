package cs2.particles
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color

object ParticleSystemApp extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Particles!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            val ps = new ParticleSystem(new Vec2(300,100))
            val gravity = new Vec2(0,0.2)

            val timer = AnimationTimer(t => {
                g.setFill(Color.White)
                g.fillRect(0,0, 600,600)
                ps.display(g)
                ps.timeStep()
                ps.addParticle()
                ps.applyForce(gravity)
            })
            timer.start


        }
    }
}