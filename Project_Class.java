import java.math.BigInteger;

public class Project_Class {

    // Attributes for project:
    int proj_num;
    String proj_name;
    String type_building;
    int street_num;
    String street_name;
    BigInteger erf_num; // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
    BigInteger total_fee;
    BigInteger paid_to_date;
    String deadline;

    //Creating a Constructor Method:

    public Project_Class (int proj_num,String proj_name,String type_building,int street_num,String street_name,BigInteger erf_num,
                          BigInteger total_fee,BigInteger paid_to_date,String deadline){
        this.proj_num = proj_num;
        this.proj_name = proj_name;
        this.type_building = type_building;
        this.street_num = street_num;
        this.street_name = street_name;
        this.erf_num = erf_num;
        this.total_fee = total_fee;
        this.paid_to_date = paid_to_date;
        this.deadline = deadline;
    }
    // Creating a toString method so the information prints out correctly:

    public String toString() {

        String output_proj = "Project number: " + proj_num;
        output_proj += "\nProject name: " + proj_name;
        output_proj += "\nBuilding type: " + type_building;
        output_proj += "\nProject address: " + street_num +" "+ street_name +" "+ "Street";
        output_proj += "\nERF number: " + erf_num;
        output_proj += "\nTotal fee: R" + total_fee;
        output_proj += "\nAmount paid to date: R" + paid_to_date;
        output_proj += "\nProject deadline: " + deadline;

        return output_proj;
    }
}
