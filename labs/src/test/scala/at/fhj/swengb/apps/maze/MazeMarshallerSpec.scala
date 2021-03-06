package at.fhj.swengb.apps.maze

import org.scalatest.WordSpecLike


/**
  * Specification for Maze marshaller.
  */
class MazeMarshallerSpec extends WordSpecLike {

  "Mazemarshaller" should {
    ".convert(pos : Pos)" in {
      val pos = Pos(4711, 815)
      val actual: MazeProtobuf.Pos = MazeProtocol.convert(pos)

      assert(actual.getX == pos.x)
      assert(actual.getY == pos.y)
    }

    ".convert(pos : Rect)" in {
      val pos = Rect(4711.0, 815.0)
      val actual: MazeProtobuf.Rect = MazeProtocol.convert(pos)

      assert(pos.width == actual.getWidth)
      assert(pos.height == actual.getHeight)
    }
    ".convert (cell:Cell)" in {
      val cell = Cell(Pos(4711,815),Coord(121,121),Rect(121,121))
      val actual: MazeProtobuf.Cell = MazeProtocol.convert(cell)

      assert(actual.


    }
  }
}
