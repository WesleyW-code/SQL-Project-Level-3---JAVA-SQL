import java.math.BigInteger;

public class Contractor_Class {

    // Attributes for contractor:
    String cont_name;
    BigInteger cont_contact_nr; // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
    String cont_email;
    int cont_str_num;
    String cont_str_name;

    //Creating a Constructor Method:

    public Contractor_Class (String cont_name, BigInteger cont_contact_nr, String cont_email, int cont_str_num, String cont_str_name){
        this.cont_name = cont_name;
        this.cont_contact_nr = cont_contact_nr;
        this.cont_email = cont_email;
        this.cont_str_num = cont_str_num;
        this.cont_str_name = cont_str_name;
    }
    // Creating a toString method so the information prints out correctly:

    public String toString() {

        String output_contractor = "Contractor name: " + cont_name;
        output_contractor += "\nContractor contact number: " + cont_contact_nr;
        output_contractor += "\nContractor email address: " + cont_email;
        output_contractor += "\nContractor physical address: " + cont_str_num+" "+cont_str_name+" "+"Street";

        return output_contractor;
    }
}
