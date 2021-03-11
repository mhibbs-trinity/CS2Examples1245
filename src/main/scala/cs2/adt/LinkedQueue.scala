package cs2.adt

class LinkedQueue[A] extends Queue[A] {
    private class Node(var data:A, var next:Node)
    private var head:Node = null
    private var last:Node = null

    def enqueue(elem:A):Unit = {
        last.next = new Node(elem, null)
        last = last.next
    }
    def dequeue():A = {
        val ret = head.data
        head = head.next
        ret
    }
    def peek():A = { head.data }
    def isEmpty():Boolean = { head == null }
}