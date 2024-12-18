/*************************
 * Name: 	Dennis T Sherpa
 * Course: 	CS-320 
 * Date: 	December 5th, 2024
 * Description: This is the Contact class, which stores contacts.
 *************************/

package projectOne;

//Define a Contact class
public class Contact {
    // A unique contact ID string that cannot be updated once set
    private final String contactId;
    // Four strings that respectively hold the first name, last name, phone number, and address
    private String firstName, lastName, phoneNumber, address;

    // Constructor with validation
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
        // Check if the contact ID meets requirements
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }
        // Check if the first name meets requirements
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        // Check if the last name meets requirements
        if (lastName == null || lastName.length() > 10) {   	
            throw new IllegalArgumentException("Invalid Last Name");
        }
        // Check if the phone number meets requirements
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        for (char c: phoneNumber.toCharArray()) {
        	if (!Character.isDigit(c)) {
        		throw new IllegalArgumentException("Invalid phone number.");
        	}
        }
        // Check if the address meets requirements
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Initialize contact ID
        this.contactId = contactId;
        // Initialize first name
        this.firstName = firstName;
        // Initialize last name
        this.lastName = lastName;
        // Initialize phone number
        this.phoneNumber = phoneNumber;
        // Initialize address
        this.address = address;
    }

    // Getters

    // Get contact ID
    public String getContactId() {
        return contactId;
    }

    // Get first name
    public String getFirstName() {
        return firstName;
    }

    // Get last name
    public String getLastName() {
        return lastName;
    }

    // Get phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Get address
    public String getAddress() {
        return address;
    }

    // Setters

    // Update first name only if it meets requirements
    public void updateFirstName(String firstName) {
        // Check if new first name meets requirements
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }

        // Update first name
        this.firstName = firstName;
    }

    // Update last name only if it meets requirements
    public void updateLastName(String lastName) {
        // Check if new last name meets requirements
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }

        // Update last name
        this.lastName = lastName;
    }

    // Update phone number only if it meets requirements
    public void updatePhoneNumber(String phoneNumber) {
        // Check if new phone number meets requirements
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        for (char c: phoneNumber.toCharArray()) {
        	if (!Character.isDigit(c)) {
        		throw new IllegalArgumentException("Invalid phone number.");
        	}
        }

        // Update phone number
        this.phoneNumber = phoneNumber;
    }

    // Update address only if it meets requirements
    public void updateAddress(String address) {
        // Check if new address meets requirements
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        // Update address
        this.address = address;
    }
}
