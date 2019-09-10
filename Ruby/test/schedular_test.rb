require './src/schedular'
require 'test/unit'
 
class TestSchedular < Test::Unit::TestCase
 
  def test_canary
    assert(true) #Feedback: please indent
  end

  def test_schedule_meeting_traditional
    result = schedule(meeting {})
    
    assert_not_nil result
  end
   
  def test_schedule_meeting_fluent
    result = schedule meeting {}
  
    assert_not_nil result
  end
  
  def test_schedule_meeting_with_name
    scheduled_meeting = schedule meeting {
      name 'the meeting'
    }
    
    assert scheduled_meeting.meeting_name == 'the meeting'
  end
  
  def test_schedule_meeting_with_start
    scheduled_meeting = schedule meeting {
      name 'the meeting'
      start 10.30
    }
           
    assert scheduled_meeting.meeting_name == 'the meeting'
    assert scheduled_meeting.start_time == '10:30'
  end
  
  def test_schedule_meeting_with_end
    scheduled_meeting = schedule meeting {
      name 'the meeting'
      start 10.30
      finish 12.00
    }

    assert scheduled_meeting.meeting_name == 'the meeting'
    assert scheduled_meeting.start_time == '10:30'
    assert scheduled_meeting.end_time == '12:00'
  end
  
  def test_schedule_meeting_with_on
    scheduled_meeting = schedule meeting {
      name 'the meeting'
      start 10.30
      finish 12.00
      on 10, 15, 2018  
    }
      
    assert scheduled_meeting.meeting_name == 'the meeting'
    assert scheduled_meeting.start_time == '10:30'
    assert scheduled_meeting.end_time == '12:00'
    assert scheduled_meeting.date == '10/15/2018'
  end
  
  def test_schedule_meeting_with_participants
    scheduled_meeting = schedule meeting {
      name 'the meeting'
      start 10.30
      finish 12.00
      on 10, 15, 2018
      participants [
        'Kim R.',
        'Mike B.',
        'Paula P.',
        'Chin Z.'
      ]
    }
      
    assert scheduled_meeting.meeting_name == 'the meeting'
    assert scheduled_meeting.start_time == '10:30'
    assert scheduled_meeting.end_time == '12:00'
    assert scheduled_meeting.date == '10/15/2018'
    assert scheduled_meeting.participant_list == ['Kim R.', 'Mike B.', 'Paula P.', 'Chin Z.']
  end
end
