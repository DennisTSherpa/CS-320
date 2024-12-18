/*************************
 * Name: 	Dennis T Sherpa
 * Course: 	CS-320 
 * Date: 	December 5th, 2024
 * Description: This is the Contact Service Test class, which tests the Contact Service class.
 *************************/

package projectOne;

//Import the JUnit Library's @BeforeEach annotation, which allows to mark a method to run before each test case
import org.junit.jupiter.api.BeforeEach;
//Import the JUnit library's @Test annotation, which allows us to mark methods as test cases.
import org.junit.jupiter.api.Test;
//Import all static members of the Assertions class, which includes methods like assertEquals, assertTrue, assertFalse, assertThrows, etc.
//This will allows us to write assertions in test methods to check that the code behaves as expected.
import static org.junit.jupiter.api.Assertions.*;

//Define a class that validates the ContactService class
public class ContactServiceTest {
    // Create a private ContactService object
    private ContactService contactService;
    // Create a private Contact object
    private Contact contact;

    // Before execution of each test case run this method to set up the prerequisites of each test
    @BeforeEach
    public void setUp() {
        // Assign an instance of ContactSerivce to the object contactService
        contactService = new ContactService();
        // Assign an instance of Contact to the object contact
        contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    }

    // Test the contact service of adding a contact
    @Test
    public void testAddContact() {
        // Validate a contact can be added
        assertTrue(contactService.addContact(contact));
        // Validate a pre-existing contact cannot be added
        assertFalse(contactService.addContact(contact)); 
    }

    // Test the contact service of deleting a contact
    @Test
    public void testDeleteContact() {
        // Add a contact
        contactService.addContact(contact);
        // Validate that an existing contact can be deleted
        assertTrue(contactService.deleteContact("12345"));
        // Validate that a non-existent contact cannot be deleted
        assertFalse(contactService.deleteContact("54321")); 
    }

    // Test the contact service of updating a contact
    @Test
    public void testUpdateContact() {
        // Add a contact
        contactService.addContact(contact);
        // Validate an existing contact can be updated
        assertTrue(contactService.updateContact("12345", "Jane", "Doe", "0987654321", "456 Oak St"));
        // Validate that the updated contact exists
        assertEquals("Jane", contact.getFirstName());
        // Validate that the updated contact exists
        assertEquals("0987654321", contact.getPhoneNumber());
    }

    // Test the contact service of updating a contact
    @Test
    public void testUpdateNonExistentContact() {
        // Validate that a non-existent contact cannot be updated
        assertFalse(contactService.updateContact("54321", "Jane", "Doe", "0987654321", "456 Oak St"));
    }
}
