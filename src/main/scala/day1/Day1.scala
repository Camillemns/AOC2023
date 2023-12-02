package day1

val WordToSafeDigits = Map(
  "one" -> "one1one",
  "two" -> "two2two",
  "three" -> "three3three",
  "four" -> "four4four",
  "five" -> "five5five",
  "six" -> "six6six",
  "seven" -> "seven7seven",
  "eight" -> "eight8eight",
  "nine" -> "nine9nine"
)

def get_calibration(str: String) : Int =
  val digits : String = str.filter(_.isDigit)
  val first = digits.take(1)
  val last = digits.takeRight(1)
  val calib = s"${first}${last}"
  return calib.toInt


def replace_word_by_digits(str: String) : String =
  val clean = WordToSafeDigits.foldLeft(str) { case (cur, (from, to)) => cur.replaceAll(from, to) }
  return clean


def solve_1(lines: List[String]) : Int =
  return lines.map(row => get_calibration(row)).sum


def solve_2(lines: List[String]) : Int =
  return lines.map(row => get_calibration(replace_word_by_digits(row))).sum
