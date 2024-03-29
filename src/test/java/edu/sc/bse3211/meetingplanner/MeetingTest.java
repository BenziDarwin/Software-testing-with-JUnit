package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class MeetingTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testCreateMeeting() {
        Meeting meeting = null;
        meeting = new Meeting();
        assertNotNull(meeting);
    }
    @Test
    public void testCreateMeetingMonthAndDay() {
        Meeting meeting = null;
        meeting = new Meeting(12,1);
        assertNotNull(meeting);
    }

    @Test
    public void testCreateMeetingWithStartAndEnd() {
        Meeting meeting = null;
        meeting = new Meeting(12,1,1,3);
        assertNotNull(meeting);
    }

    @Test 
    public void testCreateMeetingAll() {
        Meeting meeting = null;
        ArrayList<Person> attendees = new ArrayList<Person>();
        attendees.add(new Person("Ssali Benjamin"));
        meeting = new Meeting(12,1,1,3, attendees,new Room("New Room"), "Meeting 1");
        assertNotNull(meeting);
    }

    @Test
    public void testAddAttendee() {
        Meeting meeting = new Meeting();
        meeting.addAttendee(new Person("Ssali Benjamin"));
        assertFalse(meeting.getAttendees().isEmpty());
    }
    
    @Test
    public void testRemoveAttendee() {
        Meeting meeting = new Meeting();
        Person person = new Person("Ssali Benjamin");
        meeting.addAttendee(person);
        assertFalse(meeting.getAttendees().isEmpty());
        meeting.removeAttendee(person);
        assertTrue(meeting.getAttendees().isEmpty());
    }
    
    @Test
    public void testToString() {
        Meeting meeting = new Meeting();
        meeting.setRoom(new Room("Room"));
        assertNotNull(meeting.toString());
    }
    
    @Test
    public void testGetMonth() {
        Meeting meeting = new Meeting(12,1);
        assertEquals(12, meeting.getMonth());
    }
    
    @Test
    public void testSetMonth() {
        Meeting meeting = new Meeting(12,1);
        assertEquals(12, meeting.getMonth());
        meeting.setMonth(11);
        assertEquals(11, meeting.getMonth());
    }
    
    @Test
    public void testGetDay() {
        Meeting meeting = new Meeting(12,1);
        assertEquals(1, meeting.getDay());
    }
    
    @Test
    public void testSetDay() {
        Meeting meeting = new Meeting(12,1);
        assertEquals(1, meeting.getDay());
        meeting.setDay(20);
        assertEquals(20, meeting.getDay());
    }
    
    @Test
    public void testGetStartTime() {
        Meeting meeting = new Meeting(12,1,3,5);
        assertEquals(3, meeting.getStartTime());
    }
    
    @Test
    public void testSetStartTime() {
        Meeting meeting = new Meeting(12,1,3,5);
        assertEquals(3, meeting.getStartTime());
        meeting.setStartTime(4);
        assertEquals(4, meeting.getStartTime());
    }
    
    @Test
    public void testGetEndTime() {
        Meeting meeting = new Meeting(12,1,3,5);
        assertEquals(5, meeting.getEndTime());
    }
    
    @Test
    public void testSetEndTime() {
        Meeting meeting = new Meeting(12,1,3,5);
        assertEquals(5, meeting.getEndTime());
        meeting.setEndTime(7);
        assertEquals(7, meeting.getEndTime());
    }
    
    @Test
    public void testGetAttendees() {
        ArrayList<Person> attendees = new ArrayList<Person>();
        Person person = new Person("Ssali Benjamin");
        attendees.add(person);
        Meeting meeting = new Meeting();
        meeting.addAttendee(person);
        assertEquals(meeting.getAttendees(), attendees);
    }
    
    @Test
    public void testGetAndSetRoom() {
        Meeting meeting = new Meeting();
        Room room = new Room("Room");
        meeting.setRoom(room);
        assertEquals(room , meeting.getRoom());
    }
    
    @Test
    public void testGetAndSetDescription() {
        Meeting meeting = new Meeting();
        meeting.setDescription("It is a description.");
        assertEquals("It is a description.", meeting.getDescription());
    }

}
