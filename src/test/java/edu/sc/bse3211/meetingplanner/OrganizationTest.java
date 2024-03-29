package edu.sc.bse3211.meetingplanner;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class OrganizationTest {
	// Add test methods here. 
    // You are not required to write tests for all classes.

    @Test
    public void testCreateOrganisation() {
        Organization organization = null;
        organization = new Organization();
        assertNotNull(organization);
    }

    @Test
    public void testGetEmployees() {
        Organization organization = new Organization();
        assertFalse(organization.getEmployees().isEmpty());
    }
    
    @Test
    public void testGetRooms() {
        Organization organization = new Organization();
        assertFalse(organization.getRooms().isEmpty());
    }
    
    @Test
    public void testGetRoomPass() throws Exception {
        Organization organization = new Organization();
        assertNotNull(organization.getRoom("LLT6A"));
    }

    @Test
    public void testGetRoomFail() {
        Organization organization = new Organization();
        try {
            // Wrong name of room.
            organization.getRoom("LLLLT6A");
        } catch (Exception e) {
            assertEquals("Requested room does not exist", e.getMessage());
        }
    }
    
    @Test
    public void testGetEmployeePass() throws Exception {
        Organization organization = new Organization();
        assertNotNull(organization.getEmployee("Acan Brenda"));
    }

    @Test
    public void testGetEmployeeFail() {
        Organization organization = new Organization();
        try {
            // Wrong name of person.
            organization.getEmployee("Not a person.");
        } catch (Exception e) {
            assertEquals("Requested employee does not exist", e.getMessage());
        }
    }
}
