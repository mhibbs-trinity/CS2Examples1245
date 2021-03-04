package cs2.particles

import cs2.util.Vec2
import scalafx.scene.canvas.GraphicsContext
import scala.collection.mutable.Buffer

class ParticleSystem(val origin:Vec2) {
    var particles:Buffer[Particle] = Buffer()

    def addParticle():Unit = {
        particles += new RainbowParticle(Vec2(origin), new Vec2(math.random()*4-2, math.random()*4-2))
        /*
        if(math.random() < 0.5) {
            particles ::= new RoundParticle(Vec2(origin), new Vec2(math.random()*4-2, math.random()*4-2))
        } else {
            particles ::= new SquareParticle(Vec2(origin), new Vec2(math.random()*4-2, math.random()*4-2))
        }*/
    }

    def display(g:GraphicsContext):Unit = {
        for(p <- particles) {
            p.display(g)
        }
        //println(particles.length)
    }
    def timeStep():Unit = {
        particles.foreach((p:Particle) => p.timeStep())
        /* This is bad because changing the size of a collection
           during a for loop over it causes problems
        for(p <- particles) {
            if(p.isOffScreen) {
                particles -= p
            }
        }*/
        /* Using a while loop can work, but has the danger of
           accidentally creating an infinite loop
        var i = 0
        while(i < particles.length) {
            if(particles(i).isOffScreen) {
                particles.remove(i)
            } else {
                i += 1
            }
        } */
        particles = particles.filterNot((p:Particle) => p.isOffScreen)
    }
    def applyForce(force:Vec2):Unit = {
        for(p <- particles) {
            p.applyForce(force)
        }
    }
}