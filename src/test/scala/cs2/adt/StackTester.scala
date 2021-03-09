package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
    var s:Stack[Int] = null

    @Before def init() {
        s = Stack[Int]()
    }

    @Test def checkIsEmptyInitially() {
        assertTrue(s.isEmpty)
    }

    @Test def checkIsEmptyWithNonEmpty() {
        s.push(1)
        assertTrue(s.isEmpty == false)
    }

    @Test def checkLotsOfPushAndPop() {
        for(i <- 1 to 50) {
            s.push(i)
        }
        assertTrue(s.isEmpty == false)
        for(i <- 50 to 1 by -1) {
            assertTrue(s.peek == i)
            assertTrue(s.pop == i)
        }
        assertTrue(s.isEmpty)
    }

}

