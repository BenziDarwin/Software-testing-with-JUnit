package edu.sc.bse3211.meetingplanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {
	// Add test methods here. 
	// You are not required to write tests for all classes.

	@Test
	public void testCreateCalendar() {
		Calendar calendar = null;
		calendar = new Calendar();
		// Makes sure a calendar has been instanciated.
        assertNotNull(calendar);
	}

	@Test
	public void testIsBusy() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,"New Meeting");
		meeting.setStartTime(10);
		meeting.setEndTime(12);
		calendar.addMeeting(meeting);
		// Makes sure that the time is marked as busy.
		assertTrue(calendar.isBusy(12,1,10,12));
	}

	@Test
	public void testCheckTimesPass() throws TimeConflictException {
		Calendar.checkTimes(12,12,12,14);
	}

	@Test
	public void testCheckTimesFail() {
		try {
			Calendar.checkTimes(13,12,12,12);
		} catch (TimeConflictException e) {
            assertSame("Month does not exist.", e.getMessage());
		}

		try {
			Calendar.checkTimes(12,32,12,12);
		} catch (TimeConflictException e) {
            assertSame("Day does not exist.", e.getMessage());
		}

		try {
			Calendar.checkTimes(12,12,24,-1);
		} catch (TimeConflictException e) {
            assertSame("Illegal hour.", e.getMessage());
		}
	}

	@Test
	public void testAddMeetingPass() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		calendar.addMeeting(meeting);
		assertEquals(calendar.getMeeting(12,1, 0), meeting);
	}

	@Test
	public void testAddMeetingFail() {
		// Create Janan Luwum holiday
		Calendar calendar = new Calendar();
		// Add to calendar object.
		try {
			Meeting janan = new Meeting(2, 16, "Janan Luwum");
			calendar.addMeeting(janan);
			// Verify that it was added.
			Boolean added = calendar.isBusy(2, 16, 0, 23);
			assertTrue("Janan Luwum Day should be marked as busy on the calendar",added);
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}

	@Test
	public void testClearSchedule() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		calendar.addMeeting(meeting);
		// Make sure the day is busy.
		assertTrue(calendar.isBusy(12,1,1,5));
		// Clear the schedule for that day.
		calendar.clearSchedule(12,1);
		// Make sure the calendar is not busy.
		assertFalse(calendar.isBusy(12,1,1,5));
	}

	@Test
	public void testPrintAgendaMonth() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		meeting.setRoom(new Room("New Meeting"));
		meeting.addAttendee(new Person("Ssali Benjamin"));
		calendar.addMeeting(meeting);
        assertNotNull(calendar.printAgenda(12));
	}

	@Test
	public void testPrintAgendaMonthAndDay() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		meeting.setRoom(new Room("New Meeting"));
		meeting.addAttendee(new Person("Ssali Benjamin"));
		calendar.addMeeting(meeting);
		assertNotNull(calendar.printAgenda(12, 1));
	}

	@Test
	public void testGetMeeting() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		meeting.setRoom(new Room("New Meeting"));
		meeting.addAttendee(new Person("Ssali Benjamin"));
		calendar.addMeeting(meeting);
		assertNotNull(calendar.getMeeting(12,1,0));
	}

	@Test 
	public void testRemoveMeeting() throws TimeConflictException {
		Calendar calendar = new Calendar();
		Meeting meeting = new Meeting(12,1,1,5);
		meeting.setRoom(new Room("New Meeting"));
		meeting.addAttendee(new Person("Ssali Benjamin"));
		calendar.addMeeting(meeting);
		assertNotNull(calendar.getMeeting(12,1,0));
		calendar.removeMeeting(12,1,0);
		try {
			calendar.getMeeting(12,1,0);
		} catch (IndexOutOfBoundsException ignored){}
	}

}
