import java.math.BigInteger;

public class Client_Class {

    // Attributes for client:
    String name;
    String surname;
    BigInteger contact_nr; // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
    String email;
    int street_number;
    String street_name;

    //Creating a Constructor Method:

    public Client_Class (String name,String surname,BigInteger contact_nr,String email,int street_number,String street_name){

        this.name = name;
        this.surname = surname;
        this.contact_nr = contact_nr;
        this.email = email;
        this.street_number = street_number;
        this.street_name = street_name;
    }

    // Creating a toString method so the information prints out correctly:

    public String toString() {

        String output_client = "Name: " + name;
        output_client += "\nSurname: " + surname;
        output_client += "\nContact number: " + contact_nr;
        output_client += "\nEmail address: " + email;
        output_client += "\nPhysical address: " +street_number+" "+street_name+" "+"Street";

        return output_client;
    }
}
