import java.util.*;

public class Poised_Project_Manager_main {

    public static void main(String[] args) {

        // Asking user to enter the menu options:
        // Using the selection to initiate the following codes:
        // Using main boolean for my menu.
        // The menu will prompt when a user is done with an option until an exit command ("e") is given.

        System.out.println("WELCOME TO PROJECT MANAGER\n");
        boolean menu_options = false;
        while (menu_options == false) {

            // Using try / catch to make sure to menu option is inputted correctly.
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please select one of the following option:\n" +
                        "a - Add Project.\n" +
                        "d - Edit Project.\n" +
                        "i - View incomplete projects.\n" +
                        "o - View overdue projects.\n" +
                        "e - To exit.\n" +
                        "Please enter your option now: ");
                String user_selection = input.next();

                // If user selects 'a' the questions will be asked for all the information on the project:
                if (user_selection.equals("a")) {
                    // Calling my information method:
                    Information_methods.project_info();
                }

                // If user selects 'd' the editing of a project will initiate:
                else if (user_selection.equals("d")) {
                    // Calling my project editing method:
                    Project_editor.Editing_project();

                }

                // If user selects 'i' then all the incomplete tasks will display:
                else if (user_selection.equals("i")) {
                    // Calling my incomplete projects method:
                    System.out.println("The following projects are incomplete: ");
                    C_or_D_Methods.incomplete_projects();
                }

                // if user selects 'o' then  all the overdue projects will display:
                else if (user_selection.equals(("o"))){
                    // Calling my overdue projects method:
                    System.out.println("These projects are overdue: ");
                    C_or_D_Methods.Overdue();
                }

                // If user selects 'e' the program will stop:
                else if (user_selection.equals("e")) {
                    System.out.println("Program ended!");
                    menu_options = true;
                }

                // If user selects anything else the program will give an error:
                else {
                    System.out.println("\nPlease make sure you have entered an option correctly!\n");
                }

            }
            // Catching any input errors.
            catch (InputMismatchException e){
                System.out.println("\nPlease make sure you have entered an option correctly!\n");
            }
        }
    }
}
