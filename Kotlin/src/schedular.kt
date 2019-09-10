import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.Duration

class Meeting {
  
  val meeting = this
  val starts = this
  val and = this
  val add = this
  val participants = this
  var event_name = ""
  var start_time = ""
  var end_time = ""
  var date = ""
  var participant_list = listOf<String>()

  infix fun name(event_name: String): Unit {
    this.event_name = event_name
  }
  
  fun format(time: Double): String {
	return "%.2f".format(time).replace(".", ":")
  }

  infix fun at(start_time: Double): Unit {
    this.start_time = format(start_time)
  }

  infix fun ends(end_time: Double): Unit {
    this.end_time = format(end_time)
  }

  infix fun include(people: String): Unit {
    this.participant_list = people.dropLast(1).split(".")
  }

  fun duration(): String {
    val t1 = LocalTime.parse(this.start_time, DateTimeFormatter.ofPattern("HH:mm"))
    val t2 = LocalTime.parse(this.end_time, DateTimeFormatter.ofPattern("HH:mm"))
    var minutes = Duration.between(t1,t2).toMinutes()
    return LocalTime.MIN.plus(Duration.ofMinutes(minutes)).toString()
  }

  infix fun Int.January(year: Int) = "1/$this/$year"
  infix fun Int.February(year: Int) = "2/$this/$year"
  infix fun Int.March(year: Int) = "3/$this/$year"
  infix fun Int.April(year: Int) = "4/$this/$year"
  infix fun Int.May(year: Int) = "5/$this/$year"
  infix fun Int.June(year: Int) = "6/$this/$year"
  infix fun Int.July(year: Int) = "7/$this/$year"
  infix fun Int.August(year: Int) = "8/$this/$year"
  infix fun Int.September(year: Int) = "9/$this/$year"
  infix fun Int.October(year: Int) = "10/$this/$year"
  infix fun Int.November(year: Int) = "11/$this/$year"
  infix fun Int.December(year: Int) = "12/$this/$year"
}

object schedule {
  infix fun meeting(block: Meeting.() -> Unit): Meeting {
    return Meeting().apply(block)
  }
}
