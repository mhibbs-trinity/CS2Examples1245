package cs2.net

import java.lang.Thread
import java.net._
import java.io._

object ChatProgram {

  def createOutputThread(sock:Socket):Thread = {
    new Thread {
      override def run():Unit = {
        val os = new BufferedOutputStream(sock.getOutputStream)
        val is = new BufferedInputStream(System.in)

        var msg = ""
        while(!sock.isClosed && msg != "EXIT\n") {
          msg = ""
          while(!sock.isClosed && is.available == 0) Thread.sleep(10)
          var lastChar = 'Z'
          while(!sock.isClosed && is.available > 0 && lastChar != '\n') {
            lastChar = is.read.toChar
            msg += lastChar
          }
          println(">> " + msg)
          if(!sock.isClosed) {
            for(c <- msg) {
              os.write(c)
            }
            os.flush()
          }
        }
        println("After the output while")
        os.close
        is.close
        sock.close
      }
    }
  }

  def createInputThread(sock:Socket):Thread = {
    new Thread {
      override def run():Unit = {
        val is = new BufferedInputStream(sock.getInputStream)

        var msg = ""
        while(!sock.isClosed && msg != "EXIT\n") {
          msg = ""
          while(!sock.isClosed && is.available == 0) Thread.sleep(10)
          var lastChar = 'Z'
          while(!sock.isClosed && is.available > 0 && lastChar != '\n') {
            lastChar = is.read.toChar
            msg += lastChar
          }
          println("<< " + msg)
        }
        println("After the input while")
        is.close
        sock.close
      }
    }
  }


  def main(args:Array[String]):Unit = {
    //args(0) = server | client
    //args(1) = port number
    //args(2) = hostname (client only)

    var sock:Socket = null
    var ss:ServerSocket = null
    if(args(0) == "server") {
      ss = new ServerSocket(args(1).toInt)
      sock = ss.accept()
    } else if(args(0) == "client") {
      sock = new Socket(args(2), args(1).toInt)
    } else {
      println("Incorrect arguments")
    }
    val inThread = createInputThread(sock)
    val outThread = createOutputThread(sock)
    inThread.start()
    outThread.start()
    inThread.join()
    outThread.join()
    sock.close
    if(args(0) == "server") ss.close

  }
}

