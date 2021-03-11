package cs2.adt

import org.junit._
import org.junit.Assert._

class QueueTester {
    var q = Queue[Int]()

    @Before def init():Unit = {
        q = Queue[Int]()
    }

    @Test def checkManyEnqueueDequeue():Unit = {
        assertTrue(q.isEmpty())
        for(i <- 1 to 50) {
            q.enqueue(i)
        }
        assertTrue(q.isEmpty() == false)
        for(i <- 1 to 50) {
            assertTrue(q.peek == i)
            assertTrue(q.dequeue == i)
        }
        assertTrue(q.isEmpty())
    }

}
