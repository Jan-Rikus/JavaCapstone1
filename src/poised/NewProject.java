package poised;

// This class holds the information to create a new project object

public class NewProject
{
    // Attributes
    int projectNo;
    String projectName, buildingType, erfNo, projectAddress, projectDeadline;
    double projectQuote, amountPaid;
    ContractualParty client, architect, contractor;

    // Constructor Method
    public NewProject(int projectNo, String projectName, String buildingType, String erfNo,
                      String projectAddress, String projectDeadline,
                      double projectQuote, double amountPaid,
                      ContractualParty client, ContractualParty architect, ContractualParty contractor)
    {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.erfNo = erfNo;
        this.projectAddress = projectAddress;
        this.projectDeadline = projectDeadline;
        this.projectQuote = projectQuote;
        this.amountPaid = amountPaid;
        this.client = client;
        this.architect = architect;
        this.contractor = contractor;
    }

    // Getter and Setter Methods
    public String getBuildingType()
    {
        return this.buildingType;
    }

    public String getProjectDeadline()
    {
        return this.projectDeadline;
    }

    public void setProjectDeadline(String newDeadline)
    {
        this.projectDeadline = newDeadline;
    }

    public double getAmountPaid()
    {
        return this.amountPaid;
    }

    public void setAmountPaid(double updatedAmountPaid)
    {
        this.amountPaid = updatedAmountPaid;
    }

    // Display poised.NewProject object data
    public String displayProject()
    {
        String output = "\nPROJECT " + projectName + " DETAILS:";
        output += "\nProject No: " + projectNo;
        output += "\nProject Name: " + projectName;
        output += "\nBuilding Type: " + buildingType;
        output += "\nERF No: " + erfNo;
        output += "\nProject Address: " + projectAddress;
        output += "\nProject Deadline: " + projectDeadline;
        output += "\nProject Quote: R" + projectQuote;
        output += "\nAmount Paid to date: R" + amountPaid;
        output += "\n_____________________________________";

        return output;
    }
}
