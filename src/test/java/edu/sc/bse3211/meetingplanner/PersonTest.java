package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testCreatePerson() {
    Person person = null;
    person = new Person();
    assertNotNull(person);
    }

    @Test
    public void testCreatePersonWithName() {
        Person person = null;
        person = new Person("Person 1");
        assertNotNull(person);
    }
    
    @Test
    public void testGetName() {
        Person person = new Person("Person 1");
        assertSame(person.getName(), "Person 1");
    }
    
    @Test
    public void testAddMeeting() throws TimeConflictException {
        Person person = new Person("Person 1");
        Meeting meeting = new Meeting(12,1,1,3);
        person.addMeeting(meeting);
        assertNotNull(person.getMeeting(12,1,0));
    }
    
    @Test
    public void testPrintAgendaMonth() throws TimeConflictException {
        Person person = new Person("Person 1");
        Meeting meeting = new Meeting(12,1,1,3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertNotNull(person.printAgenda(12));
    }
    
    @Test
    public void testPrintAgendaMonthDay() throws TimeConflictException {
        Person person = new Person("Person 1");
        Meeting meeting = new Meeting(12,1,1,3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertNotNull(person.printAgenda(12, 1));
    }
    
    @Test
    public void testIsBusy() throws TimeConflictException {
        Person person = new Person("Person 1");
        Meeting meeting = new Meeting(12,1,1,3);
        Room room = new Room("Room 1");
        meeting.setRoom(room);
        person.addMeeting(meeting);
        assertTrue(person.isBusy(12,1,1,3));
    }
    
    @Test
    public void testRemoveMeeting() throws TimeConflictException {
        Person person = new Person("Person 1");
        Meeting meeting = new Meeting(12,1,1,3);
        person.addMeeting(meeting);
        assertNotNull(person.getMeeting(12,1,0));
        person.removeMeeting(12,1,0);
        try {
            person.getMeeting(12,1,0);
        } catch (IndexOutOfBoundsException ignored){}
    
    }
}
