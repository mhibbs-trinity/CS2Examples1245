package cs2.net

import java.net._
import java.io._

object SimpleNetworking {

  def getPageSource(site:String):String = {
    val url = new URL(site)
    val bis = new BufferedInputStream(url.openStream)
    var res = ""
    while(bis.available() > 0) {
      res += bis.read.toChar
    }
    bis.close()
    res
  }

  def serverSide():Unit = {
    val ss = new ServerSocket(50000)
    val sock:Socket = ss.accept() //blocks until a client connects
    val os = sock.getOutputStream()
    for(i <- 1 to 10) {
      val c = scala.util.Random.nextPrintableChar()
      println(">>> Sending: " + c)
      os.write(c)
    }
    os.flush()
    os.close()
    sock.close()
    ss.close()
  }

  def clientSide():Unit = {
    val sock = new Socket("localhost", 50000)
    val is = sock.getInputStream()
    while(is.available == 0) { Thread.sleep(10) }
    while(is.available > 0) {
      println("<<< Received: " + is.read.toChar)
    }
    is.close
    sock.close
  }

  def main(args:Array[String]):Unit =  {
    //println(getPageSource("https://www.google.com"))
    (new Thread { override def run():Unit = { serverSide() } }).start
    Thread.sleep(10)
    clientSide()
  }
}


