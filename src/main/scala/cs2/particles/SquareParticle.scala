package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

class SquareParticle(p:Vec2, v:Vec2) extends Particle(p,v) {
    col = Color.YellowGreen

    override def display(g:GraphicsContext):Unit = {
        g.setFill(col)
        g.fillRect(pos.x - rad, pos.y-rad, rad*2,rad*2)
    }
}




