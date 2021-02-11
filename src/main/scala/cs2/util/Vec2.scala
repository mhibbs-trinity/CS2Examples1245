package cs2.util

class Vec2(var x:Double, var y:Double) {
    def + (other:Vec2):Vec2 = {
        new Vec2(this.x + other.x, this.y + other.y)
    }

    def += (other:Vec2):Unit = {
        this.x += other.x
        this.y += other.y
    }
}

object Vec2 {
    def apply(ix:Double, iy:Double):Vec2 = new Vec2(ix,iy)
    def apply(toCopy:Vec2):Vec2 = new Vec2(toCopy.x, toCopy.y)
}
