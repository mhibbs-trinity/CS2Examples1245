package cs2.algorithms

import scala.collection.mutable.Set
import scala.io.Source
import java.io.PrintWriter


object TextAnalysis {

    def countWords(lines:Iterator[String]):Int = {
        var wordSet = Set[String]()
        for(line <- lines) {
            var words = line.split("\\s+")
            words = words.map((x:String) => x.filter(_.isLetter).toLowerCase)
            wordSet ++= words
        }
        for(word <- wordSet) {
            //println(word)
        }
        wordSet.size
    }
    def wordFrequency(lines:Iterator[String]):Unit = {
        var wordMap = scala.collection.mutable.Map[String,Int]()
        for(line <- lines) {
            var words = line.split("\\s+")
            words = words.map((x:String) => x.filter(_.isLetter).toLowerCase)
            for(word <- words) {
                if(wordMap.contains(word)) {
                    wordMap(word) = wordMap(word) + 1
                } else {
                    wordMap(word) = 1
                }
            }
        }
        for(tup <- wordMap) {
            //println(tup)
        }
        var wordSort:Array[(String,Int)] = wordMap.toArray
        ParametricSorting.bubbleSort(wordSort, (t1:(String,Int), t2:(String,Int)) => t1._2 > t2._2)

        val out = new PrintWriter("tempestCount.txt")
        for((word,count) <- wordSort) out.println(word + "\t" + count)
        out.close
    }

    def main(args:Array[String]):Unit = {
        val path = getClass.getResource("/tempest.txt")
        val it = Source.fromURL(path).getLines()
        //println(countWords(it))
        wordFrequency(it)
    }
}
