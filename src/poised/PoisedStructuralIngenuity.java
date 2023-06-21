package poised;

// Importing relevant modules
import java.util.Scanner;
import java.util.ArrayList;

public class PoisedStructuralIngenuity
{
    public static void main(String[] args)
    {
        // Attributes
        int mainOption, existProjOption, projNum;
        String projName, projType, erfNum, projAddress, projDeadline;
        double projAmount, paidToDate;
        ContractualParty architect = new ContractualParty("", "", "",
                "", "", ""),
                contractor = new ContractualParty("", "", "",
                "", "", ""),
                client = new ContractualParty("", "", "",
                "", "", "");

        // List of newly created project objects
        ArrayList<NewProject> projectList = new ArrayList<>();


        // Main Menu Display
        while (true)
        {
            System.out.println("\nPOISED STRUCTURAL INGENUITY");
            String mainMenu = """
                
                1 - Add New Project
                2 - Existing Projects
                3 - Exit program

                Select an option above:\s""";

            // User input validation - calling input validation method
            mainOption = intInputValidation(mainMenu);

            if (mainOption == 1)
            {
                // New project information
                System.out.println("\nNEW PROJECT INFORMATION");

                // Creating new Scanner object
                Scanner input = new Scanner(System.in);

                System.out.print("New project number: ");
                projNum = input.nextInt();
                input.nextLine();   // Clear '\n' character from scanner after integer input

                System.out.print("New project name: ");
                projName = input.nextLine();

                System.out.print("Building Type: ");
                projType = input.nextLine();

                System.out.print("ERF number: ");
                erfNum = input.nextLine();

                System.out.print("Project physical address: ");
                projAddress = input.nextLine();

                System.out.print("Estimated project deadline: ");
                projDeadline = input.nextLine();

                System.out.print("Estimated project amount (ZAR): R ");
                projAmount = input.nextDouble();

                System.out.print("Amount settled to date: R ");
                paidToDate = input.nextDouble();

                // New contractual party information
                System.out.println("\nEnter Contractual Parties information below");

                for (int i = 0; i < 3; i++)
                {
                    switch (i)
                    {
                        case 0 ->
                        {
                            // Architect object
                            System.out.println("\nEnter details of Architect");
                            architect = createParty("Architect");
                        }
                        case 1 ->
                        {
                            // Contractor object
                            System.out.println("\nEnter details of Contractor");
                            contractor = createParty("Contractor");
                        }
                        case 2 ->
                        {
                            // Client object
                            System.out.println("\nEnter details of Client");
                            client = createParty("Client");
                        }
                    }
                }

                // Creating new project object/instance and adding to projectList
                NewProject project = new NewProject(projNum, projName, projType, erfNum,
                        projAddress, projDeadline, projAmount, paidToDate, client, architect, contractor);

                // Adding new project object to project Array List
                projectList.add(project);
                System.out.println("\nProject " + projName + " successfully added!\n");
            }

            else if (mainOption == 2)
            {
                System.out.println("\nPOISED PROJECTS");
                String existingProjects = """
                    
                    1 - Search Project by Number
                    2 - Back to Main Menu
                    
                    Select an option above:\s""";

                // User input validation - calling input validation method
                existProjOption = intInputValidation(existingProjects);

                switch (existProjOption)
                {
                    case 1 ->
                    {
                        // Checking to see if there are any projects recorded
                        boolean recordedProjects = check(projectList);

                        if (recordedProjects)
                        {
                            System.out.println("Returning to Main Menu...\n");
                        }
                        else
                        {
                            // If there are projects recorded, display and enable user to update
                            show(projectList);
                            updateProject(projectList);
                        }
                    }
                    case 2 ->
                    {
                        System.out.println("Returning to Main Menu...\n");
                    }
                    default ->
                    {
                        System.out.println("Invalid input, returning to Main Menu...");
                    }
                }
            }

            else if (mainOption == 3)
            {
                System.out.println("Logging off...");
                break;
            }

            else
            {
                System.out.println("Invalid input, please try again:");
            }
        }
    }

    // Methods
    public static int intInputValidation()
    {
        // This method will validate integer inputs
        Scanner input = new Scanner(System.in);

        // User input validation - integers
        while (!input.hasNextInt())
        {
            System.out.print("Invalid input, try again: ");
            input.next();
        }
        return input.nextInt();
    }

    public static int intInputValidation(String option)
    {
        // This method will validate integer inputs for numerated menu options
        System.out.print(option);
        Scanner input = new Scanner(System.in);

        // User input validation - integers
        while (!input.hasNextInt())
        {
            System.out.print("Invalid input, try again: ");
            input.next();
        }
        return input.nextInt();
    }

    public static ContractualParty createParty(String position)
    {
        // This method will create the contractual parties objects
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Surname: ");
        String surname = input.nextLine();

        System.out.print("Contact Number: ");
        String contact = input.nextLine();

        System.out.print("Email Address: ");
        String emailAddress = input.nextLine();

        System.out.print("Physical Address: ");
        String resAddress = input.nextLine();

        // Creating new contractual party object/instance
        return new ContractualParty(position, name, surname,
                contact, emailAddress, resAddress);
    }

    public static boolean check(ArrayList<NewProject> arr)
    {
        /* This method will check whether there are existing projects created
            when user wants to edit an existing projects */

        boolean status = false;
        if (arr.isEmpty())
        {
            System.out.println("There are currently no projects recorded");
            status = true;
        }
        return status;
    }

    public static void show(ArrayList<NewProject> arr)
    {
        /* This method will print out all existing projects recorded
            inorder for user to edit specific projects */

        for (NewProject newProject : arr) {
            String project = newProject.displayProject();
            System.out.println(project + "\n");
        }
    }

    public static void updateProject(ArrayList<NewProject> arr)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the project number: ");
        int projNum = intInputValidation();

        for (NewProject newProject : arr)
        {
            if (newProject.projectNo == projNum)
            {
                System.out.println("\nUPDATE PROJECT");
                String update = """
                        1 - Update project deadline
                        2 - Update total amount of the fee paid to date
                        3 - Update contractor's contact details
                        4 - Return to Main Menu
                                                
                        Select an option above:\s""";

                // Validate integer input
                int updateOption = intInputValidation(update);

                switch (updateOption)
                {
                    case 1 ->
                    {
                        System.out.print("Enter the projects new deadline: ");
                        String updatedDeadline = input.nextLine();
                        newProject.setProjectDeadline(updatedDeadline);

                        System.out.println("Project deadline successfully updated!");
                    }
                    case 2 ->
                    {
                        boolean loop = true;
                        while (loop)
                        {
                            System.out.print("Enter the updated amount (Do not add Currency Symbol, value only): ");
                            String updatedAmount = input.nextLine();
                            double uAmount;
                            boolean check;

                            try
                            {
                                // Validating double input value for fee amount
                                Double.parseDouble(updatedAmount);
                                check = true;
                            }
                            catch (NumberFormatException e)
                            {
                                check = false;
                            }

                            if (check)
                            {
                                uAmount = Double.parseDouble(updatedAmount);
                                newProject.setAmountPaid(uAmount);
                                System.out.println("Project amount to date successfully updated!");
                                loop = false;
                            }
                            else
                            {
                                System.out.println("Invalid input, please try again...");
                            }
                        }
                    }
                    case 3 ->
                    {
                        System.out.println("\nUpdate Contractor's contact information");
                        String contactToUpdate = """
                                1 - Update contact number
                                2 - Update email address
                                                        
                                Select an option above:\s""";

                        // Validate integer input
                        int updateChoice = intInputValidation(contactToUpdate);

                        switch (updateChoice)
                        {
                            case 1 ->
                            {
                                System.out.print("New contact number: ");
                                String updatedContactNum = input.nextLine();
                                newProject.contractor.setContactNum(updatedContactNum);

                                System.out.println("Contractor's contact number successfully updated!");
                            }
                            case 2 ->
                            {
                                System.out.print("New email address: ");
                                String updatedEmailAddress = input.nextLine();
                                newProject.contractor.setEmail(updatedEmailAddress);

                                System.out.println("Contractor's email successfully updated!");
                            }
                        }
                    }
                    case 4 ->
                    {
                        System.out.println("Returning to Main Menu...");
                    }
                }
            }
            else
            {
                System.out.println("Invalid input, returning to Main Menu...");
            }
        }
    }
}

// End of project (TBC)
