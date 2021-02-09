package cs2.graphics

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.paint.Color
import scalafx.scene.input.MouseEvent

object CanvasTest extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        title = "Canvas test!"
        scene = new Scene(600, 400) {
            val canvas = new Canvas(600, 400)
            content = canvas

            val g = canvas.graphicsContext2D
            /*
            g.strokeRect(100,200, 200,150)
            g.setStroke(Color.HotPink)
            g.setFill(Color.Blue)
            g.fillOval(100,200, 200,150)
            g.strokeLine(0,0, 100,200)
            g.fillText("Hello!", 100,200)
            */
            /*
            for(x <- 0 to 600) {
                //get from 0 to 600, into range 0 to 255
                //0-600 ==> 0-1 ==> 0-255
                g.setStroke(Color.rgb((x / 600.0 * 255).toInt, 0,0))
                g.strokeLine(x,0, x,400)
            }*/

            var prevX:Double = 0.0
            var prevY:Double = 0.0
            canvas.onMousePressed = (e:MouseEvent) => {
                prevX = e.x
                prevY = e.y
            }
            canvas.onMouseDragged = (e:MouseEvent) => {
                g.strokeLine(prevX,prevY, e.x,e.y)
                prevX = e.x
                prevY = e.y
            }

        }
    }
}

