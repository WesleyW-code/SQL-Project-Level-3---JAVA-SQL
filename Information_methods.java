import java.io.*;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;

public class Information_methods {

    // This method will ask all the questions for the project.
    // Project information method:

    public static void project_info() {

        // Questions for the Project information:

        Scanner proj_info = new Scanner(System.in);
        System.out.println("\nPROJECT INFORMATION QUESTIONS:\n");

        System.out.println("Please enter the project number: ");
        int prj_number = proj_info.nextInt();



        // If the user enters none , the project name will be given with is the building type with client surname.
        System.out.println("Please enter the project name (if you don't have one in mind enter 'none'): ");
        String prj_name = proj_info.next();


        System.out.println("Please enter the building type:" +
                "\nh - House" +
                "\nap - Apartment block" +
                "\ns - Store" +
                "\n Please enter your option now: ");
        String prj_select = proj_info.next();
        String prj_tpe = "";
        if (prj_select.equals("h")) {
            prj_tpe = "House";
        } else if (prj_select.equals("ap")) {
            prj_tpe = "Apartment block";
        } else if (prj_select.equals("s")) {
            prj_tpe = "Store";
        }


        System.out.println("Please enter the project street number: ");
        int prj_strnum = proj_info.nextInt();



        System.out.println("Please enter the project street name: ");
        String prj_strname = proj_info.next();


        // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
        System.out.println("Please enter the ERF number: ");
        BigInteger prj_erf_num = proj_info.nextBigInteger();


        System.out.println("Please enter the total fee of the project: R");
        BigInteger prj_total = proj_info.nextBigInteger();


        System.out.println("Please enter the amount that is paid to date: R");
        BigInteger prj_ptd = proj_info.nextBigInteger();


        System.out.println("Please enter the project deadline(Enter format must be yyyy-mm-dd): ");
        String prj_deadline = proj_info.next();


        String complete = "No";

        String completed_on = "0000-00-00";



        // Questions for the Client information:

        Scanner client_info = new Scanner(System.in);
        System.out.println("\nCLIENT INFORMATION QUESTIONS:\n");

        System.out.println("Please enter the name of the client: ");
        String clnt_name = client_info.next();


        System.out.println("Please enter the surname of the client: ");
        String clnt_surname = client_info.next();


        // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
        System.out.println("Please enter the client's telephone number: ");
        BigInteger clnt_num = client_info.nextBigInteger();


        System.out.println("Please enter the email address of the client: ");
        String clnt_edress = client_info.next();


        System.out.println("Please enter the client street number: ");
        int clnt_str_num = client_info.nextInt();


        System.out.println("Please enter the client street name: ");
        String clnt_str_name = client_info.next();

        // Questions for the Architect information:

        Scanner arch_info = new Scanner(System.in);
        System.out.println("\nARCHITECT INFORMATION QUESTIONS:\n");

        System.out.println("Please enter the name of the architect: ");
        String arch_name = arch_info.next();


        // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
        System.out.println("Please enter the architect telephone number: ");
        BigInteger arch_num = arch_info.nextBigInteger();


        System.out.println("Please enter the email address of the architect: ");
        String arch_edress = arch_info.next();


        System.out.println("Please enter the architect street number: ");
        int arch_str_num = arch_info.nextInt();


        System.out.println("Please enter the architect street name: ");
        String arch_str_name = arch_info.next();


        // Questions for the Contractor information:

        Scanner cont_info = new Scanner(System.in);
        System.out.println("\nCONTRACTOR INFORMATION QUESTIONS:\n");

        System.out.println("Please enter the name of the contractor: ");
        String cont_name = cont_info.next();


        // BigInteger allows for long numbers. (Learned on //www.baeldung.com › java-bigdecimal-biginteger)
        System.out.println("Please enter the contractor telephone number: ");
        BigInteger cont_num = cont_info.nextBigInteger();


        System.out.println("Please enter the email address of the contractor: ");
        String cont_edress = cont_info.next();


        System.out.println("Please enter the contractor street number: ");
        int cont_str_num = cont_info.nextInt();


        System.out.println("Please enter the contractor street name: ");
        String cont_str_name = cont_info.next();


        try {

            // Connect to the database, via the jdbc:mysql: channel on localhost (this PC)
            // Use username "otheruser", password "swordfish".
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Poised_data?useSSL=false",
                    "otheruser",
                    "swordfish"
            );

            // Create a direct line to the database for running our queries
            Statement statement = connection.createStatement();
            int rowsAffected;

            // Doing stuff to my database table:

            // Adding project info:

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO project_info VALUES ('"+prj_number+"', '"+prj_name+"', '"+prj_tpe+"', '"+prj_strnum+"', '"+prj_strname+"', '"+prj_erf_num+"', '"+prj_total+"', '"+prj_ptd+"', '"+prj_deadline+"', '"+complete+"','"+completed_on+"')"
            );

            // This will initiate if the user cant think of a project name to enter and will make the project name the building type plus the client surname.

            if (prj_name.equals("none")) {
                clnt_surname = " "+clnt_surname;
                rowsAffected = statement.executeUpdate(
                        "UPDATE project_info SET project_name = '"+prj_tpe+clnt_surname+"'WHERE project_num='"+prj_number+"'"
                );
            }

            // Adding client info:

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO client_info VALUES ('"+prj_number+"', '"+clnt_name+"', '"+clnt_surname+"', '"+clnt_num+"', '"+clnt_edress+"', '"+clnt_str_num+"', '"+clnt_str_name+"')"
            );

            // Adding Architect info:

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO Arc_info VALUES ('"+prj_number+"', '"+arch_name+"', '"+arch_num+"', '"+arch_edress+"', '"+arch_str_num+"', '"+arch_str_name+"')"
            );

            // Adding Contractor info:

            rowsAffected = statement.executeUpdate(
                    "INSERT INTO Con_info VALUES ('"+prj_number+"', '"+cont_name+"', '"+cont_num+"', '"+cont_edress+"', '"+cont_str_num+"', '"+cont_str_name+"')"
            );

            // Closing the database.
            statement.close();



            System.out.println("\nProject added successfully!\n");


        } catch (SQLException throwables) {
            // We only want to catch a SQLException - anything else is off-limits for now.
            throwables.printStackTrace();
        }


        // Adding the information from the questions to the correct class:

            Project_Class created_proj = new Project_Class(prj_number, prj_name, prj_tpe, prj_strnum, prj_strname, prj_erf_num,
                    prj_total, prj_ptd, prj_deadline);

            Client_Class created_client = new Client_Class(clnt_name, clnt_surname, clnt_num, clnt_edress, clnt_str_num, clnt_str_name);

            Architect_Class created_architect = new Architect_Class(arch_name, arch_num, arch_edress, arch_str_num, arch_str_name);

            Contractor_Class created_contractor = new Contractor_Class(cont_name, cont_num, cont_edress, cont_str_num, cont_str_name);

            // Printing out all the information on the terminal:

            System.out.println("\nPROJECT INFORMATION\n");
            System.out.println(created_proj.toString());

            System.out.println("\nCLIENT INFORMATION\n");
            System.out.println(created_client.toString());

            System.out.println("\nARCHITECT INFORMATION\n");
            System.out.println(created_architect.toString());

            System.out.println("\nCONTRACTOR INFORMATION\n");
            System.out.println(created_contractor.toString());
        }
    }

