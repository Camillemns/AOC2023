import helper.*
import day1.*

val DayToSolution = Map(
  1 -> Map( 
    1 -> day1.solve_1, 
    2 -> day1.solve_2
  )
)

@main def main: Unit =
  println("What day do you wan to test?")
  val day : Int = scala.io.StdIn.readInt()
  val max_day = DayToSolution.keys.max 
  if (day > max_day) throw new Exception(s"No solution for day #${day} implemented. Last day is #${max_day}")
  val lines : List[String] = Input(day).get_lines()
  val problem = DayToSolution.get(day)
  println("Which problem do you want to solve (1, 2)?")
  val id : Int = scala.io.StdIn.readInt()
  if (id > 2 || id < 1) throw new Exception(s"#${id} doesn't exist for day #${day}. Please provide as problem id 1, 2.")
  println(problem.get(id)(lines))


