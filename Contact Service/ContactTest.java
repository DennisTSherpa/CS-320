/*************************
 * Name: 	Dennis T Sherpa
 * Course: 	CS-320 
 * Date: 	December 5th, 2024
 * Description: This is the Contact Test class, which tests the Contact class.
 *************************/

package projectOne;

//Import the JUnit library's @Test annotation, which allows us to mark methods as test cases.
import org.junit.jupiter.api.Test;

//Import all static members of the Assertions class, which includes methods like assertEquals, assertTrue, assertFalse, assertThrows, etc.
//This will allows us to write assertions in test methods to check that the code behaves as expected.
import static org.junit.jupiter.api.Assertions.*;

//Define a class that validates the Contact class
public class ContactTest {
    // Test when a contact creation succeeds
    @Test
    public void testContactCreation() {
    	// Create initial contact
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Confirm contact has been created
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    /*
     * Tests when a contact creation fails because the input for a contact field 
     * (1) exceeds the maximum number of characters
     * (2) is null
     * (3) is not exactly 10 digits (applicable only to the phone number)
     */
    
    /*
     * Tests when a contact is created with an invalid contact ID
     */
    
    // Test when contact ID exceeds 10 characters
    @Test
    public void testWhenContactIdExceedsMaxCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test when contact ID is null
    @Test
    public void testWhenContactIdIsNull() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    /*
     * Tests when a contact is created with an invalid first name
     */
    
    // Test when first name exceeds 10 characters
    @Test
    public void testWhenFirstNameExceedsMaxCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }
    
    // Test when first name is null
    @Test
    public void testWhenFirstNameIsNull() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
    }

    /*
     * Tests when a contact is created with an invalid last name
     */
    
    // Test when last name exceeds 10 characters
    @Test
    public void testWhenLastNameExceedsMaxCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }
    
    // Test when last name is null
    @Test
    public void testWhenLastNameIsNull() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
    }

    /*
     * Tests when a contact is created with an invalid phone number
     */
    
    // Test when phone number exceeds 10 characters
    @Test
    public void testWhenPhoneNumberExceedsTenCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345678901234567890", "123 Main St");
        });
    }
    
    // Test when phone number is less than 10 characters
    @Test
    public void testWhenPhoneNumberIsLessThanTenCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1", "123 Main St");
        });
    }
    
    // Test when phone number is null
    @Test
    public void testWhenPhoneNumberIsNull() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
    }
    
    // Test when phone number is not exactly 10 digits
    @Test
    public void testWhenPhoneNumberIsNotExactlyTenDigits() {
    	// Confirm contact cannot be created
    	assertThrows(IllegalArgumentException.class, () -> {
    		new Contact("12345", "John", "Doe", "123456789a", "123 Main St");
    	});
    }

    /*
     * Tests when a contact is created with an invalid address
     */
    
    // Test when address exceeds 30 characters
    @Test
    public void testWhenAddressExceedsMaxCharacters() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "123 Main St123 Main St123 Main St123 Main St");
        });
    }
    
    // Test when address is null
    @Test
    public void testWhenAddressIsNull() {
    	// Confirm contact cannot be created
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
    }
    
    /* 
     * Test that all fields of a contact can be updated successfully
     */

    @Test
    public void testWhenFirstNameUpdateSucceeds() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Update first name
    	contact.updateFirstName("Paul");
    	// Update last name
    	contact.updateLastName("Ryan");
    	// Update phone number
    	contact.updatePhoneNumber("0987654321");
    	// Update address
    	contact.updateAddress("321 South St");
    	
    	// Confirm all modifiable fields of the contact have been updated
    	assertEquals("Paul", contact.getFirstName());
    	assertEquals("Ryan", contact.getLastName());
    	assertEquals("0987654321", contact.getPhoneNumber());
    	assertEquals("321 South St", contact.getAddress());
    }
    
    /*
     * Tests when a contact update fails because the input for a contact field
     * (1) exceeds maximum number of characters
     * (2) is null
     * (3) is not exactly 10 digits (applicable only to the phone number)
     */
    
    /*
     * Test when a contact is updated with an invalid first name
     */
    
    // Test when first name is updated with more than 10 characters
    @Test
    public void testWhenFirstNameUpdateExceedsMaxCharacters() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm first name cannot be updated with more than 10 characters
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateFirstName("This will exceed 10 characters");
    	});
    }
    
    // Test when first name is updated with null
    @Test
    public void testWhenFirstNameIsUpdatedWithNull() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm first name cannot be updated with null
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateFirstName(null);
    	});
    }
    
    /*
     * Test when a contact is updated with an invalid last name
     */
    
    // Test when last name is updated with more than 10 characters
    @Test
    public void testWhenLastNameUpdateExceedsMaxCharacters() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm last name cannot be updated with more than 10 characters
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateLastName("This will exceed 10 characters");
    	});
    }
    
    // Test when last name is updated with null
    @Test
    public void testWhenLastNameIsUpdatedWithNull() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm last name cannot be updated with null
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateLastName(null);
    	});
    }
    
    /*
     * Test when a contact is updated with an invalid phone number
     */
    
    // Test when phone number is updated with more than 10 characters
    @Test
    public void testWhenPhoneNumberUpdateExceedsTenCharacters() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm phone number cannot be updated with more than 10 characters
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updatePhoneNumber("01234567890123456789");
    	});
    }
    
    // Test when phone number is updated with less than 10 characters
    @Test
    public void testWhenPhoneNumberUpdateLessThanTenCharacters() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm phone number cannot be updated with less than 10 characters
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updatePhoneNumber("1");
    	});
    }
    
    // Test when phone number is updated with null
    @Test
    public void testWhenPhoneNumberIsUpdatedWithNull() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm phone number cannot be updated with null
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updatePhoneNumber(null);
    	});
    }
    
    // Test when phone number is not updated with exactly 10 digits
    @Test
    public void testWhenPhoneNumberIsNotUpdatedWithTenDigits() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm phone number cannot be updated with input that is not exactly 10 digits
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updatePhoneNumber("123456789a");
    	});
    }
    
    /*
     * Test when a contact is updated with an invalid address
     */
    
    // Test when address is updated with more than 30 characters
    @Test
    public void testWhenAddressUpdateExceedsMaxCharacters() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm address cannot be updated with more than 30 characters
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateAddress("This will exceed 30 characters.");
    	});
    }
    
    // Test when address is updated with null
    @Test
    public void testWhenAddressIsUpdatedWithNull() {
    	// Create initial contact
    	Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
    	
    	// Confirm address cannot be updated with null
    	assertThrows(IllegalArgumentException.class, () -> {
    		contact.updateAddress(null);
    	});
    }
   
}
