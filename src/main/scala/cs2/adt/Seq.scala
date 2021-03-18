package cs2.adt

abstract class Seq[A] extends Iterable[A] {
    //Abstract methods
    def get(idx:Int):A
    def set(idx:Int, elem:A):Unit
    def insert(idx:Int, elem:A):Unit
    def remove(idx:Int):A
    def length():Int

    //Dervided concrete methods
    def prepend(elem:A):Unit = insert(0, elem)
    def +:= (elem:A):Unit = prepend(elem)
    def append(elem:A):Unit = insert(length, elem)
    def += (elem:A):Unit = append(elem)

    def apply(idx:Int):A = get(idx)
    def update(idx:Int, elem:A) = set(idx, elem)
}

object Seq {
    def apply[A : Manifest]():Seq[A] = new DoubleLinkedSeq[A]()

    def main(args:Array[String]):Unit = {
        var seq = Seq[Int]()
        for(i <- 5 to 10) { seq.insert(0, i) }

        //O(n^2)
        for(idx <- 0 until seq.length) {
            println(seq(idx))
        }
        seq(2) = 42 //seq.update(2, 42)

        //O(n)
        println(seq)

        //O(n)
        val it = seq.iterator
        while(it.hasNext) {
            println(it.next)
        }

        println(seq.sum)
        println(seq.mkString("$$"))
    }
}
