package cs2.algorithms

import scala.collection.mutable.Set
import scala.io.Source


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

    def main(args:Array[String]):Unit = {
        val path = getClass.getResource("/tempest.txt")
        val it = Source.fromURL(path).getLines()
        println(countWords(it))
    }
}
