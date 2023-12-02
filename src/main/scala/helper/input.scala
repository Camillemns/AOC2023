package helper

import scala.io.Source

class Input(var day: Int):
    var path = s"src/main/scala/day${day}/data"

    def get_lines() : List[String] =
        return Source.fromFile(path).getLines.toList 