package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext

class ParticleSystem(val origin:Vec2) {
    var particles:List[Particle] = Nil

    def addParticle():Unit = {
        if(math.random() < 0.5) {
            particles ::= new Particle(Vec2(origin), new Vec2(math.random()*4-2, math.random()*4-2))
        } else {
            particles ::= new SquareParticle(Vec2(origin), new Vec2(math.random()*4-2, math.random()*4-2))
        }
    }

    def display(g:GraphicsContext):Unit = {
        for(p <- particles) {
            p.display(g)
        }
        println(particles.length)
    }
    def timeStep():Unit = {
        particles.foreach((p:Particle) => p.timeStep())
        //particles.foreach(_.timeStep)
    }
    def applyForce(force:Vec2):Unit = {
        for(p <- particles) {
            p.applyForce(force)
        }
    }
}