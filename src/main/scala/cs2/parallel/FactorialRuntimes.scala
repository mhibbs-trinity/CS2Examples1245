package cs2.parallel

class TimeLogger {
  private var start = System.nanoTime()
  def reset():Unit = start = System.nanoTime()
  def logTime():Unit = { println((System.nanoTime() - start)/1e9 + " seconds") }
}

object FactorialRuntimes {

  def factRecur(n:BigInt):BigInt = {
    if(n <= 1) 1
    else n * factRecur(n-1)
  }

  def factFor(n:BigInt):BigInt = {
    var product:BigInt = 1
    for(x <- BigInt(1) to n) {
      product *= x
    }
    product
  }

  def factCollect(n:BigInt):BigInt = {
    (BigInt(1) to n).reduce(_*_)
  }


  def main(args:Array[String]):Unit = {
    val num = 5000
    val logger = new TimeLogger
    /*
    logger.reset()
    factRecur(num)
    logger.logTime()
    */
    logger.reset()
    factFor(num)
    logger.logTime()

    logger.reset()
    factCollect(num)
    logger.logTime()
  }
}

