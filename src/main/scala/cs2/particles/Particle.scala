package cs2.particles

import cs2.util.Vec2
import scalafx.scene.paint.Color
import scalafx.scene.canvas.GraphicsContext

abstract class Particle(protected var pos:Vec2, private var vel:Vec2) {
    var rad = 10.0
    var col = Color.OrangeRed

    def display(g:GraphicsContext):Unit
    
    def isOffScreen():Boolean = {
        pos.x < 0 || pos.x > 600 || pos.y < 0 || pos.y > 600
    }

    def timeStep():Unit = {
        pos += vel
    }
    def applyForce(force:Vec2):Unit = {
        vel += force
    }
}