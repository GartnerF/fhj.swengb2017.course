package at.fhj.swengb.plasma

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.canvas.Canvas
import javafx.scene.image.{PixelFormat, PixelWriter}
import javafx.scene.{Group, Scene}
import javafx.stage.Stage

import scala.util.Random

/**
  * Simple sinus drawing on a byte array which is displayed via javafx.
  *
  * Created by lad on 14/07/2017.
  */
object Plasma {

  def main(args: Array[String]): Unit = {
    Application.launch(classOf[PlasmaJfxApp], args: _*)
  }

}

class PlasmaJfxApp extends javafx.application.Application {

  /**
    * the width and height of our visual area
    */
  val (width, height) = (1024, 768)

  /**
    * we have 3 color components, thus one line in our backing array is three times as long as the visual 'pixel' area
    */
  val backingArrayWidth = width * 3

  /**
    * ranges for x and y direction
    */
  val (xs, ys) = (0 until width, 0 until height)


  /**
    * Black visual area out at the start of the program
    */
  val backingArray = Array.tabulate(width * height * 3)(i => 0.toByte)


  val colorDepth = 255

  /**
    * precompute sin values to gain some speed (presumably, didn't really measure)
    */
  val sinTable: Array[Double] = (0 until 180).map(a => Math.sin(a * Math.PI / 180)).toArray

  /**
    * scale visual area index to sintable
    */
  val (xFac: Double, yFac: Double) = (sinTable.length.toDouble / width, sinTable.length.toDouble / height)

  val state: Array[Int] = Array(0, 0)


  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Plasma")

    val root = new Group()
    val canvas = new Canvas(width, height)

    root.getChildren.add(canvas)
    primaryStage.setScene(new Scene(root))
    primaryStage.show()


    new AnimationTimer() {


      override def handle(now: Long): Unit = {
        applySinus(backingArray, sinTable, colorDepth, state)
        drawByteArray(canvas, backingArray)

      }
    }.start()


  }

  private def applySinus(backingArray: Array[Byte]
                         , sinTable: Array[Double] = sinTable
                         , colorDepth: Int = 255
                         , state: Array[Int]) = {
    val moveX = state(0)
    val moveY = state(1)
    state(0) = state(0) + 1
    state(1) = state(1) + 1
    val superXFac = 1
    val superYFac = 1
    for {x <- xs
         y <- ys} {
      val sinXIndex = ((x * xFac * superXFac).toInt + moveX * superXFac) % sinTable.length
      val sinYIndex = ((y * yFac * superYFac).toInt + moveY * superYFac) % sinTable.length

     // val sinIndex = (sinXIndex + sinYIndex) % sinTable.length

      val c: Int = (sinTable(sinXIndex) * colorDepth).toInt

      backingArray(x * 3 + 0 + y * backingArrayWidth) = c.toByte
      backingArray(x * 3 + 1 + y * backingArrayWidth) = c.toByte
      backingArray(x * 3 + 2 + y * backingArrayWidth) = c.toByte
    }
  }

  private def applyNoise(a: Array[Byte]) = {
    for (i <- a.indices) a(i) = Random.nextInt(254).toByte
  }

  private def drawByteArray(canvas: Canvas, bytes: Array[Byte]) = {
    val pxw: PixelWriter = canvas.getGraphicsContext2D.getPixelWriter
    pxw.setPixels(0, 0, width, height, PixelFormat.getByteRgbInstance, bytes, 0, backingArrayWidth)
  }
}