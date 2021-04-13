package cs2.parallel

import io.StdIn._
import java.lang.Thread

object SimpleCounting {
  def countDownGetName():String = {
    val thread = new Thread {
      override def run():Unit = {
        for(i <- 1 to 5) {
          println(i)
          Thread.sleep(1000)
        }
        println("Times up!")
        sys.exit()
      }
    }
    thread.start

    println("Enter your name:")
    var name = readLine
    thread.stop
    name
  }

  def betterCountDownGetName():String = {
    var haveAnswer = false
    var timesUp = false

    val thread = new Thread {
      override def run():Unit = {
        //run thread
        var ctr = 5
        while(!haveAnswer && ctr > 0) {
          println(ctr)
          ctr -= 1
          Thread.sleep(1000)
        }
        if(!haveAnswer) {
          println("Times up!")
          timesUp = true
        }
      }
    }
    thread.start

    //Main thread
    var name = "Default"
    println("Enter your name:")
    while(!timesUp && !Console.in.ready) {
      Thread.sleep(10)
    }
    if(!timesUp) {
      name = readLine
      haveAnswer = true
    }
    name
  }

  def countToABillion():Unit = {
    var ctr = 0
    val threads:Array[Thread] = Array.fill(10)(new Thread {
      override def run():Unit = {
        for(i <- 1 to 1000000000/10) {
          ctr += 1
        }
      }
    })
    threads.foreach((x:Thread) => x.start)
    threads.foreach(_.join)
    
    println(ctr)
  }

  def main(args:Array[String]):Unit = {
    //println("Hello, " + betterCountDownGetName())
    for(i <- 1 to 20) {
      countToABillion()
    }
  }
}
