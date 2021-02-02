package cs2

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.event.ActionEvent

object WindowTest extends JFXApp {
    stage = new JFXApp.PrimaryStage {
        scene = new Scene(600,400) {
            val btn = new Button("Hello!")
            btn.onAction = (e:ActionEvent) => { println("Hello!") }
            content = btn
        }
    }
}