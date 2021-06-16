import java.math.BigInteger;

public class Architect_Class {

    // Attributes for architect:

    String arch_name;
    BigInteger arch_contact_nr; // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
    String arch_email;
    int arch_str_num;
    String arch_str_name;


    //Creating a Constructor Method:

    public Architect_Class (String arch_name,BigInteger arch_contact_nr,String arch_email,int arch_str_num,String arch_str_name){
        this.arch_name = arch_name;
        this.arch_contact_nr = arch_contact_nr;
        this.arch_email = arch_email;
        this.arch_str_num = arch_str_num;
        this.arch_str_name = arch_str_name;
    }
    // Creating a toString method so the information prints out correctly:

    public String toString() {

        String output_architect = "Architect name: " + arch_name;
        output_architect += "\nArchitect contact number: " + arch_contact_nr;
        output_architect += "\nArchitect email address: " + arch_email;
        output_architect += "\nArchitect physical address: " + arch_str_num+" "+arch_str_name+" "+"Street";

        return output_architect;
    }
}
