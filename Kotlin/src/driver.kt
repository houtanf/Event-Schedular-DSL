fun print_meeting(meeting: Meeting): Unit {
  println("\nMeeting Scheduled\n\tMeeting name: ${meeting.event_name}\n\tStart Time: ${meeting.start_time}\n\tEnd Time: ${meeting.end_time}\n\tDuration: ${meeting.duration()}\n\tDate: ${meeting.date}\n\tAttendance: ${meeting.participant_list.size} People\n\tAttendees: ${meeting.participant_list.joinToString(", ")}\n\n")
}

fun main(args: Array<String>) {
  val meeting1 = schedule meeting {
    meeting name "Making Code Simple Again"
    starts at 10.30
    and ends 12.30
    date = 12 April 1212
    participants include "Venkat." + "Venkat Again." + "Also Venkat."
  }

  val meeting2 = schedule meeting {
    meeting name "Meeting of Odd Named Individuals"
    starts at 14.30
    and ends 18.00
    date = 23 October 2018
    participants include "Sam." + "Man." + "Him." + "Jim." + "Slim."
  }

  print_meeting(meeting1)
  print_meeting(meeting2)
}

