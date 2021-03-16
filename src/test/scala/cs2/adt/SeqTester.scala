package cs2.adt

import org.junit._
import org.junit.Assert._

class SeqTester {
    var s:Seq[Int] = new LinkedSeq[Int]()

    @Before def init():Unit = {
        s = new LinkedSeq[Int]()
    }

    @Test def checkInsertAndGet():Unit = {
        for(i <- 0 to 10) {
            s.insert(i, i)
        }
        assertTrue(s.length == 11)
        assertTrue(s.get(5) == 5)
    }

    @Test def checkRemoveAndSet():Unit = {
        for(i <- 0 to 10) {
            s.insert(i, i)
        }
        assertTrue(s.remove(5) == 5)
        assertTrue(s.length == 10)
        s.set(7,42)
        assertTrue(s.get(7) == 42)
        assertTrue(s.remove(0) == 0)
        assertTrue(s.length == 9)
    }
}

