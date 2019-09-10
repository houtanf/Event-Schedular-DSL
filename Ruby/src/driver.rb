require './src/schedular'


def print_meeting(meeting)
  puts "\nMeeting Scheduled:\n\tName: #{meeting.meeting_name}\n\tStart Time: #{meeting.start_time}\n\tEnd Time: #{meeting.end_time}\n\tDuration: #{meeting.meeting_duration()}\n\tDate: #{meeting.date}\n\tAttendance Total: #{meeting.participant_list.length()} People\n\tAttendees: #{meeting.participant_list.join(', ')}\n\n"
end



first_meeting = schedule meeting {
  name 'The Cool Cids Klub'
  start 0.00
  finish 3.00
  on 10, 15, 2018
  participants [
    'me',
    'you'
  ]
}

second_meeting = schedule meeting {
  name 'Toilet Clogging Issue Meeting'
  start 8.00
  finish 8.30
  on 12, 25, 2022
  participants [
    'Janet',
    'Kyle',
    'That Dude',
    'The Janitor',
    'The Janitors Wife',
    'The Janitors Lawyer'
  ]
}

print_meeting(first_meeting)
print_meeting(second_meeting)
