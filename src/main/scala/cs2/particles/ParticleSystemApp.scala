package cs2.particles
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import cs2.util.Vec2
import scalafx.animation.AnimationTimer
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

object ParticleSystemApp extends JFXApp with Rainbowness {
    stage = new JFXApp.PrimaryStage {
        title = "Particles!"
        scene = new Scene(600,600) {
            val canvas = new Canvas(600,600)
            content = canvas
            val g = canvas.graphicsContext2D

            var ps:List[ParticleSystem] = Nil
            val gravity = new Vec2(0,0.2)

            canvas.onMouseClicked = (e:MouseEvent) => {
                ps ::= new ParticleSystem(new Vec2(e.x, e.y))
            }

            canvas.requestFocus()
            canvas.onKeyPressed = (e:KeyEvent) => {
                if(e.code == KeyCode.Space) {
                    ps = Nil
                }
            }

            val timer = AnimationTimer(t => {
                g.setFill(stepColor())
                g.fillRect(0,0, 600,600)
                ps.foreach(_.display(g))
                ps.foreach(_.timeStep())
                ps.foreach(_.addParticle())
                ps.foreach(_.applyForce(gravity))
            })
            timer.start


        }
    }
}