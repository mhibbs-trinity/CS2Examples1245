package cs2.adt

class HashTableSet[A <% Ordered[A]] extends Set[A] {
    private var hash = Array.fill(100)(new BinarySearchTree[A]())
    private var len = 0

    private def getBucket(elem:A):Int = elem.hashCode() % hash.length

    def iterator():Iterator[A] = {
        new Iterator[A] {
            var bucket = 0
            var bstit = hash(0).iterator()
            advance

            private def advance():Unit = {
                while(!bstit.hasNext && bucket < hash.length - 1) {
                    bucket += 1
                    bstit = hash(bucket).iterator
                }
            }

            def next():A = {
                if(bstit.hasNext) bstit.next
                else {
                    advance
                    bstit.next
                }
            }
            def hasNext():Boolean = {
                if(bstit.hasNext) true
                else {
                    advance
                    bstit.hasNext
                }
            }
        }
    }
    def add(elem:A):Unit = {
        val bucket = getBucket(elem)
        if(!hash(bucket).contains(elem)) {
            hash(bucket).insert(elem)
            len += 1
        }
    }
    def remove(elem:A):Unit = {
        val bucket = getBucket(elem)
        if(hash(bucket).contains(elem)) {
            hash(bucket).remove(elem)
            len -= 1
        }
    }
    def contains(elem:A):Boolean = {
        val bucket = getBucket(elem)
        hash(bucket).contains(elem)
    }
    override def size():Int = len
}