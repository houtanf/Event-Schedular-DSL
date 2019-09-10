import org.junit.jupiter.api.Test;
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SchedularTest {

  @Test fun canary() {
    assertTrue(true)
  }

  @Test fun scheduleMeetingTraditional() {
    val result = schedule.meeting({})
      
    assertTrue(result.hashCode() > 0)
  }

  @Test fun scheduleMeetingFluent() {
    val result = schedule meeting {}
      
    assertTrue(result.hashCode() > 0)
  }

  @Test fun scheduleMeetingWithName() {
    val result = schedule meeting {
      meeting name "a meeting"
    }
      
    assertEquals(result.event_name, "a meeting")
  }

  @Test fun scheduleMeetingWithStart() {
    val result = schedule meeting {
      meeting name "a meeting"
      starts at 10.30
    }
      
    assertEquals(result.event_name, "a meeting")
    assertEquals(result.start_time, "10:30")
  }

  @Test fun scheduleMeetingWithEnd() {
    val result = schedule meeting {
      meeting name "a meeting"
      starts at 10.30
      and ends 12.30
    }
      
    assertEquals(result.event_name, "a meeting")
    assertEquals(result.start_time, "10:30")
    assertEquals(result.end_time, "12:30")
  }

  @Test fun scheduleMeetingWithDate() {
    val result = schedule meeting {
      meeting name "a meeting"
      starts at 10.30
      and ends 12.30
      date = 23 October 2018
    }
      
    assertEquals(result.event_name, "a meeting")
    assertEquals(result.start_time, "10:30")
    assertEquals(result.end_time, "12:30")
    assertEquals(result.date, "10/23/2018")
  }

  @Test fun scheduleMeetingWithParticipants() {
    val result = schedule meeting {
      meeting name "a meeting"
      starts at 10.30
      and ends 12.30
      date = 23 October 2018
      participants include "Houtan." + "Martin." + "Venkat."
    }

    assertEquals(result.event_name, "a meeting")
    assertEquals(result.start_time, "10:30")
    assertEquals(result.end_time, "12:30")
    assertEquals(result.date, "10/23/2018")
    assertEquals(result.participant_list, listOf("Houtan", "Martin", "Venkat"))
  }
}
