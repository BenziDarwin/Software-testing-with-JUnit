package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testCreateRoom() {
        Room room = null;
        room = new Room();
        assertNotNull(room);
    }

    @Test
    public void testCreateRoomWithID() {
        Room room = null;
        room = new Room("Room 1");
        assertNotNull(room);
    }

    @Test
    public void testGetID() {
        Room room = new Room("Room 1");
        assertSame(room.getID(), "Room 1");
    }
    
    @Test
    public void testAddMeeting() throws TimeConflictException {
        Room room = new Room("Room 1");
        Meeting meeting = new Meeting(12,1,2,4);
        room.addMeeting(meeting);
        assertSame(room.getMeeting(12,1,0), meeting);
    }
    
    @Test
    public void testPrintAgendaMonth() throws TimeConflictException {
        Room room = new Room("Room 1");
        Meeting meeting = new Meeting(12,1,2,4);
        room.addMeeting(meeting);
        meeting.setRoom(room);
        assertNotNull(room.printAgenda(12));
    }
    
    @Test
    public void testPrintAgendaMonthDay() throws TimeConflictException {
        Room room = new Room("Room 1");
        Meeting meeting = new Meeting(12,1,2,4);
        room.addMeeting(meeting);
        meeting.setRoom(room);
        assertNotNull(room.printAgenda(12, 1));
    }
    
    @Test
    public void testIsBusy() throws TimeConflictException {
        Room room = new Room("Room 1");
        Meeting meeting = new Meeting(12,1,2,4);
        room.addMeeting(meeting);
        assertTrue(room.isBusy(12,1,2,4));
    }
    
    @Test
    public void testRemoveMeeting() throws TimeConflictException {
        Room room = new Room("Room 1");
        Meeting meeting = new Meeting(12,1,2,4);
        room.addMeeting(meeting);
        assertSame(room.getMeeting(12,1,0), meeting);
        room.removeMeeting(12,1,0);
        try {
            room.getMeeting(12,1,0);
        } catch (IndexOutOfBoundsException ignored){}
    }
}
