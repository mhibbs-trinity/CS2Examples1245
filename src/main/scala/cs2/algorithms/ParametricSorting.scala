package cs2.algorithms

object ParametricSorting {

    def bubbleSort[A <% Ordered[A]] (arr:Array[A]):Unit = {
        for(j <- 0 until arr.length) {
            for(i <- 0 until arr.length-1) { 
                if(arr(i) > arr(i+1)) {
                    val tmp = arr(i)
                    arr(i) = arr(i+1)
                    arr(i+1) = tmp
                }
            }
        }
    }

    def bubbleSort[A] (arr:Array[A], gt:(A,A)=>Boolean):Unit = {
        for(j <- 0 until arr.length) {
            for(i <- 0 until arr.length-1) { 
                if(gt(arr(i), arr(i+1))) {
                    val tmp = arr(i)
                    arr(i) = arr(i+1)
                    arr(i+1) = tmp
                }
            }
        }
    }

    class Student(var first:String, var last:String, var gpa:Double) extends Ordered[Student]{
        override def toString():String = last
        def compare(other:Student):Int = {
            this.gpa.compare(other.gpa)
        }
    }

    def main(args:Array[String]):Unit = {
        val c:Array[Student] = Array(
            new Student("Sally","Ride",4.0),
            new Student("Bob","Smith",3.2),
            new Student("Charlie","Appleby",3.5)
        )
        println(c.mkString(","))
        bubbleSort(c)//, (x:Student, y:Student) => x.first > y.first)
        println(c.mkString(","))

        val a:Array[Int] = Array.fill(10)(scala.util.Random.nextInt(100))
        //println(a.mkString(","))
        bubbleSort(a)
        //println(a.mkString(","))

        val b:Array[Double] = Array.fill(10)(scala.util.Random.nextDouble)
        //println(b.mkString(","))
        bubbleSort(b, (x:Double, y:Double) => x > y) //_>_
        //println(b.mkString(","))
    }

}



