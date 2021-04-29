package cs2.io

import java.io._

object StreamStuff {

  def copyStream(in:InputStream, out:OutputStream):Unit = {
    while(in.available > 0) {
      out.write(in.read)
    }
  }

  def copyFile(inname:String, outname:String):Unit = {
    val infile = new BufferedInputStream(new FileInputStream(new File(inname)))
    val outfile = new BufferedOutputStream(new FileOutputStream(new File(outname)))
    copyStream(infile, outfile)
    infile.close()
    outfile.close()
  }

  def main(args:Array[String]):Unit = {
    copyFile("tempest.txt", "copy.txt")
  }
}