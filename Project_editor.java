import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.lang.*;

public class Project_editor {

    public static void Editing_project() {

        // Asking user which of the tasks they would like to edit by requesting a project number:
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
            ResultSet results;

            // Doing stuff to my database table:

            // Finding all project numbers for now:
            results = statement.executeQuery(
                    "SELECT Project_num FROM Project_info"
            );

            String proj_nums = "";
            while (results.next()){

                // Getting all project numbers:
                proj_nums += results.getString("Project_num");
            }


            // Asking user to enter the specific project number so they can edit that project:
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter one of the following project numbers to edit that project: \n" +
                    proj_nums +
                    "\nPlease enter the number now: ");
            String user_input = input.next();

            // The following code will take the user input and display a menu that asks what specific element of the project they want to change.
            // It will edit the specific element in the correct table.

            // Using the following list to index each project element in the source file:
            // Also using this to construct my editing menu.
            String project_indexes[]= new String[]{"n", "pn", "t", "ps", "psn", "en", "tf", "ap", "d", "c", "ctn", "cts", "ctt",
                    "cte", "cts", "ctsn", "an", "at", "ae", "as", "asn", "cn", "ct", "ce", "cs", "csn"};

            // Using the following list to create my menu for editing and making the code more efficient.
            String index_names[]= new String[]{"Project_num", "Project_name", "Building_type", "Project_str_num",
                    "Project_str_name", "ERF_num", "Total_fee", "Amount_paid", "Project_deadline", "Complete", "Client_name",
                    "Client_surname", "Client_tel", "Client_edress", "Client_str_num", "Client_str_name",
                    "Arc_name", "Arc_tel", "Arc_edress",
                    "Arc_str_num", "Arc_str_name", "Con_name", "Con_tel",
                    "Con_edress", "Con_str_num", "Con_str_name"};

            // Doing this to construct my selection menu to be efficient(this menu will allow the user to edit any element of the selected project).
            String project_menu = "";
            String client_menu = "";
            String architect_menu = "";
            String contractor_menu = "";

            for (int i = 0; i < project_indexes.length; i++) {

                // The symbol "&&" is an and statement (Learned this on: Stackoverflow.com)
                if (i < 9&&i != 0&&i != 9) {
                    project_menu += project_indexes[i]+" - "+index_names[i]+"\n";
                }
                if (i >= 10 && i < 16 ) {
                    client_menu += project_indexes[i]+" - "+index_names[i]+"\n";
                }
                if (i >= 16 && i < 21) {
                    architect_menu += project_indexes[i]+" - "+index_names[i]+"\n";
                }
                if (i >= 21 ) {
                    contractor_menu += project_indexes[i]+" - "+index_names[i]+"\n";
                }
            }

            // This is statement checks if the project is complete and if so gives and error to stop the user from editing a completed project.
            ResultSet complete;
            complete = statement.executeQuery(
                    "SELECT Project_num,Complete FROM Project_info WHERE Project_num = '"+user_input+"' and Complete = 'finalised'"
            );
            String check = "";
            while (complete.next()){

                // Checking if the project is complete:
                check += complete.getString("Complete");
            }

            // If the project is complete the program will stop.
            if (check.equals("finalised")) {
                System.out.println("This project is finalised and can not be edited!\n");
            }
            // Else it will continue:
            else {
                // User will edit the project here:

                // Asking user if they want to edit or complete the project:
                Scanner option_edit = new Scanner(System.in);
                System.out.println("Would you like to edit or finalise the project: " +
                        "\ne - Edit" +
                        "\nf - Finalise" +
                        "\nPlease enter your selection now: ");
                String option_answer = option_edit.next();

                // The menu will prompt here with all the elements that can be changed.
                // Project number is not shown as the user should not be able to change it (because it is basically my identifier for each project)
                // Complete is also not shown to change because you can simply complete a project by selecting 'c' above.

                // This is the 'e' option that will allow for the selected project to be edited.
                if (option_answer.equals("e")) {

                    // Asking user what info they want to edit (what table):
                    System.out.println("What information would you like to edit:\n" +
                            "p - Project info\n" +
                            "c - Client info\n" +
                            "a - Architect info\n" +
                            "d - Contractor info\n" +
                            "Please enter your selection now: ");
                    String table = input.next();

                    String change = "";
                    if (table.equals("p")) {
                        table = "project_info";
                        System.out.println("Choose which information you want to change: \n"+project_menu+
                                "\nPlease enter your option now: ");
                        change += input.next();
                    }
                    else if (table.equals("c")) {
                        table = "client_info";
                        System.out.println("Choose which information you want to change: \n"+client_menu+
                                "\nPlease enter your option now: ");
                        change += input.next();
                    }
                    else if (table.equals("a")) {
                        table = "arc_info";
                        System.out.println("Choose which information you want to change: \n"+architect_menu+
                                "\nPlease enter your option now: ");
                        change += input.next();
                    }
                    else if (table.equals("d")) {
                        table = "con_info";
                        System.out.println("Choose which information you want to change: \n"+contractor_menu+
                                "\nPlease enter your option now: ");
                        change += input.next();
                    }
                    // This for loop gets the location for the element that is going to be edited
                    int edit_index = 0;
                    for (int i = 0; i < project_indexes.length; i++) {

                        if (project_indexes[i].equals(change)) {
                            edit_index = i;
                        }
                    }

                    // Getting the column name so the correct data can be changed:
                    String column_name = index_names[edit_index];

                    // Asking user to make change:
                    System.out.println("What would you like to change the "+column_name+" to: ");
                    String edit_for_data = input.next();

                    // Updating the database.
                    rowsAffected = statement.executeUpdate(
                            "UPDATE "+table+" SET "+column_name+" = '"+edit_for_data+"'WHERE Project_num = '"+user_input+"'"
                    );
                    // Showing that the book has been edited.
                    System.out.println("\nProject successfully changed!\n");
                }
                else if (option_answer.equals("f")) {

                    // Updating the Completed field in Project_info.
                    rowsAffected = statement.executeUpdate(
                            "UPDATE Project_info SET Complete = 'finalised', Completed_on = '"+LocalDate.now()+"'"
                    );

                    System.out.println("Project successfully finalised!\n");

                    // Checking if invoice needs to be generated:
                    int total = 0;
                    int paid = 0;

                    ResultSet invoice;

                    // Getting all the information:
                    invoice = statement.executeQuery(
                            "SELECT Total_fee,Amount_paid FROM Project_info WHERE Project_num = '"+user_input+"'"
                    );

                    while (invoice.next()){

                        // Getting total amount:
                        total += invoice.getInt("Total_fee");

                        // Getting amount paid:

                        paid += invoice.getInt("Amount_paid");

                    }

                    String name = "";
                    String tel = "";

                    ResultSet customer;

                    // Getting all the information:
                    customer = statement.executeQuery(
                            "SELECT Client_name,Client_tel FROM Client_info WHERE Project_num = '"+user_input+"'"
                    );

                    while (customer.next()){

                        // Getting total amount:
                        name += customer.getString("Client_name");

                        // Getting amount paid:

                        tel += customer.getString("Client_tel");

                    }

                    // Generating invoice if customer has amount outstanding.
                    int outstanding = total - paid;
                    if (outstanding > 0) {
                        System.out.println("CUSTOMER INVOICE: \n" +
                                "Project number: "+user_input+
                                "\nClient name: "+name+
                                "\nClient tel: "+tel+
                                "\nOutstanding: "+outstanding+"\n");

                    }

                }
            }

            // Closing the database entries:
            complete.close();
            results.close();
            statement.close();
            connection.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
