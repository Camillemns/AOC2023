package day2

import scala.util.matching.Regex

val CubeDistribution : Map[String, Int] = Map(
    "red" -> 12,
    "blue" -> 14,
    "green" -> 13,
)

def split_line(line: String): List[String] =
    return line.split(';').toList

def count(draw : String, color: String) : Int =
    val regex : Regex = ("""(\d*) """ + color).r
    return regex.findAllMatchIn(draw).foldLeft(0)(_+_.group(1).toInt)

def in_range(red: Int, blue: Int, green: Int) : Boolean =
    if (red > 12) then return false
    if (blue > 14) then return false
    if (green > 13) then return false
    return true

def max(x: Iterable[Int], y: Iterable[Int]) : List[Int] =
    val r = x.head max y.head
    val b = x.drop(1).take(1).head max y.drop(1).take(1).head
    val g = x.last max y.last
    return List(r, b, g)

def solve_1(lines: List[String]) : Int =
    return lines
        .map(line => split_line(line)
            .map(draw => CubeDistribution
                .map((color, number) => count(draw, color))
            )
            .reduceLeft((x,y) => max(x,y))
        )
        .toList
        .zipWithIndex
        .filter(x => in_range(x._1.head, x._1.drop(1).take(1).head, x._1.last)).map(p => p._2 + 1).sum

def solve_2(lines: List[String]) : Int =
    return lines
    .map(line => split_line(line)
            .map(draw => CubeDistribution
                .map((color, number) => count(draw, color))
            )
            .reduceLeft((x,y) => max(x,y))
            .foldLeft(1)((x, y) => x*y)
        ).sum