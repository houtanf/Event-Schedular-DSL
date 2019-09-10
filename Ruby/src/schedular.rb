class Meeting
  attr_reader :meeting_name, :start_time, :end_time, :date, :participant_list

  def name(meeting_name)
    @meeting_name = meeting_name
  end

  def convert_time(time)
    ('%.2f' % time).sub('.', ':')
  end

  def start(start_time)
    @start_time = convert_time(start_time)
  end

  def finish(end_time)
    @end_time = convert_time(end_time)
  end

  def on(month, day, year)
    @date = "#{month}/#{day}/#{year}"
  end

  def participants(participants)
    @participant_list = participants
  end

  def meeting_duration()
    date_split = @date.split('/')

    start_split = @start_time.to_s.split(":")
    start = Time.new(date_split[2], date_split[0], date_split[1], start_split[0], start_split[1])

    finish_split = @end_time.to_s.split(":")
    finish = Time.new(date_split[2], date_split[0], date_split[1], finish_split[0], finish_split[1])

    Time.at(finish - start).utc.strftime("%H:%M")
  end
end

def schedule(event)
  event
end

def meeting(&block) 
  scheduled_meeting = Meeting.new

  scheduled_meeting.instance_eval(&block)

  scheduled_meeting
end
