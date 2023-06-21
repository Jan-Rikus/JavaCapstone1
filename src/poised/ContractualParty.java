package poised;

// This class holds the information to create a new person object

public class ContractualParty
{
    // Attributes
    String position, firstName, surname, contactNum, email, address;

    // Constructor Method
    public ContractualParty(String position, String firstName, String surname, String contactNum,
                            String email, String address)
    {
        this.position = position;
        this.firstName = firstName;
        this.surname = surname;
        this.contactNum = contactNum;
        this.email = email;
        this.address = address;
    }

    // Getter and Setter Methods
    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getContactNum()
    {
        return this.contactNum;
    }

    public void setContactNum(String newContactNum)
    {
        this.contactNum = contactNum;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String newEmail)
    {
        this.email = newEmail;
    }

    // Display poised.ContractualParty object data
    public String toString()
    {
        System.out.println("\nContractual Parties involved: ");

        String output = "\nPosition: " + position;
        output += "\nName: " + firstName;
        output += "\nSurname " + surname;
        output += "\nContact Number " + contactNum;
        output += "\nEmail Address: " + email;
        output += "\nPhysical Address: " + address;

        return output;
    }
}
