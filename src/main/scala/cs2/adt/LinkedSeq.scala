package cs2.adt

class LinkedSeq[A] extends Seq[A] {
    private class Node(var data:A, var next:Node) {
        def getNode(idx:Int):Node = {
            var rover = this
            for(ctr <- 1 to idx) {
                rover = rover.next
            }
            rover
        }
    }

    private var hed:Node = null
    private var len:Int = 0

    def iterator():Iterator[A] = {
        new Iterator[A] {
            var rover = hed
            def next():A = {
                var ret = rover.data
                rover = rover.next
                ret
            }
            def hasNext():Boolean = {
                rover != null
            }
        }
    }

    override def toString():String = {
        var ret = "("
        var rover = hed
        while(rover != null) {
            ret += rover.data.toString
            if(rover.next != null) ret += ", "
            rover = rover.next
        }
        ret += ")"
        ret
    }

    def get(idx:Int):A = {
        val rover = hed.getNode(idx)
        rover.data
    }
    def set(idx:Int, elem:A):Unit = {
        val rover = hed.getNode(idx)
        rover.data = elem
    }
    def insert(idx:Int, elem:A):Unit = {
        len += 1
        if(idx == 0) {
            hed = new Node(elem, hed)
        } else {
            val rover = hed.getNode(idx - 1)
            rover.next = new Node(elem, rover.next)
        }
    }
    def remove(idx:Int):A = {
        len -= 1
        if(idx == 0) {
            val ret = hed.data
            hed = hed.next
            ret
        } else {
            val rover = hed.getNode(idx - 1)
            val ret = rover.next.data
            rover.next = rover.next.next
            ret
        }
    }
    def length():Int = len
}