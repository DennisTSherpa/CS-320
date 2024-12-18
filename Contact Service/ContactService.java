/*************************
 * Name: 	Dennis T Sherpa
 * Course: 	CS-320 
 * Date: 	December 5th, 2024
 * Description: This is the Contact Service class, which provides contact services.
 *************************/

package projectOne;

//Import the HashMap and Map interface from the java utility package
import java.util.HashMap; 
import java.util.Map; 

//Define a Contact Service class
public class ContactService {

 // Declare and intialize a map that will store Contact objects, using String as the key and Contact object as the value
 private Map<String, Contact> contacts = new HashMap<>();

 // Add a new contact
 public boolean addContact(Contact contact) {
     // If a contact with the contactId of the parameter contact already exists
     if (contacts.containsKey(contact.getContactId())) {
         // Contact already exists
         return false; 
     }
     // Put a new contact into contacts
     contacts.put(contact.getContactId(), contact);
     return true; // Contact added
 }

 // Delete a contact by ID
 public boolean deleteContact(String contactId) {
     // If a contact with the contactId of the parameter contact already exists
     if (contacts.containsKey(contactId)) {
         // Remove that contact from contacts
         contacts.remove(contactId);
         return true; // Contact deleted
     }
     return false; // Contact not deleted
 }

 // Update the contact details by ID
 public boolean updateContact(String contactId, String firstName, String lastName, String phoneNumber, String address) {
     // Create a contact that holds the information of the contact whose contactId matches the parameter contactId
     Contact contact = contacts.get(contactId);
     // If contact is null
     if (contact == null) {
         return false; // Contact not found
     }
     // Set the firstName of the object contact with the parameter firstName
     contact.updateFirstName(firstName);
     // Set the lastName of the object contact with the parameter lastName
     contact.updateLastName(lastName);
     // Set the phoneNumber of the object contact with the parameter phoneNumber
     contact.updatePhoneNumber(phoneNumber);
     // Set the address of the object contact with the parameter address
     contact.updateAddress(address);

     return true; // Contacts updated
 }
}