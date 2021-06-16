import java.sql.*;
import java.time.*;

public class C_or_D_Methods {

    // This method will allow the user to see what projects still need to be completed.
    public static void incomplete_projects() {

        // Connect to the Poised_data database, via the jdbc:mysql: channel on localhost (this PC)
        // Use username "otheruser", password "swordfish".

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Poised_data?useSSL=false",
                    "otheruser",
                    "swordfish"
            );


            // Create a direct line to the database for running our queries
            Statement statement = connection.createStatement();
            ResultSet results;

            // Doing stuff to my database table:

            results = statement.executeQuery(
                    "SELECT Project_num,Project_name,Complete FROM Project_info WHERE Complete = 'No' "
            );

            // Displaying all the incomplete projects:
            while (results.next()) {

                System.out.println("Incomplete projects: \n");
                System.out.println("Project number: "+ results.getString("Project_num") + "\nProject name: " +results.getString("Project_name") +
                        "\nCompleted: "+ results.getString("Complete")+"\n");
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void Overdue() {

        // Connect to the Poised_data database, via the jdbc:mysql: channel on localhost (this PC)
        // Use username "otheruser", password "swordfish".

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Poised_data?useSSL=false",
                    "otheruser",
                    "swordfish"
            );


            // Create a direct line to the database for running our queries
            Statement statement = connection.createStatement();
            ResultSet results;

            // Doing stuff to my database table:

            results = statement.executeQuery(
                    "SELECT Project_num,Project_name,Complete,Project_deadline FROM Project_info WHERE Project_deadline < '"+LocalDate.now()+"' and Complete = 'No' "
            );

            // Displaying all the Overdue projects:
            while (results.next()) {

                System.out.println("Overdue projects: \n");
                System.out.println("Project number: "+ results.getString("Project_num") + "\nProject name: " +results.getString("Project_name") +
                        "\nCompleted: "+ results.getString("Complete")+ "\nDeadline: "+results.getString("Project_deadline")+"\n");
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
