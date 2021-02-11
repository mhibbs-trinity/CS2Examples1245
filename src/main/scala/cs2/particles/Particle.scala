package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

class Particle(var pos:Vec2, var vel:Vec2) {
    var rad = 10.0
    var col = Color.OrangeRed

    def display(g:GraphicsContext):Unit = {
        g.setFill(col)
        g.fillOval(pos.x - rad, pos.y - rad, rad*2,rad*2)
    }
    def timeStep():Unit = {
        pos += vel
    }
    def applyForce(force:Vec2):Unit = {
        vel += force
    }
}