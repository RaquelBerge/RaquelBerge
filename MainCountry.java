package finalProject;
import java.sql.*;
import java.util.Scanner;

public class MainCountry {
    private static Scanner scanner = new Scanner(System.in);
    private static CountryList countryList = new CountryList();

    public static void main(String[] args) throws Exception {

        boolean quit = false;
        int choice = 0;
        int generalChoice = 1;
        final String dbURL = "jdbc:mysql://localhost:3306/java27";
        final String user = "root";
        final String password = "PASSWORD";

        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

            readUsersLatvia(conn);
            readUsersSpain(conn);
            readUsersVatican(conn);
            readUsersMonaco(conn);
            readUsersWonderland(conn);

            printInstructions();

            System.out.println("Are you self-employed or employer? \n 1 - self-employed \n 2 - employer");
            generalChoice = scanner.nextInt();
            if(generalChoice == 1){
                System.out.println("Please use another application.");
            } else if(generalChoice == 2){
                scanner.nextLine();
            System.out.println("Enter your name and surname:");
            String name = scanner.nextLine();

            while (!quit) {
                System.out.printf("%s, Enter your country number:\n", name);
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        Latvia(conn);
                        break;
                    case 1:
                        Spain(conn);
                        break;
                    case 2:
                        Vatican(conn);
                        break;
                    case 3:
                        Monaco(conn);
                        break;
                    case 4:
                        Wonderland(conn);
                        break;
                    case 5:
                        quit = true;
                        break;
                }
            }
            } else {
                System.out.println("Please enter 1 or 2!");
            }
        } catch (SQLException e) {
            System.out.println("Error, try again!");
        }
    }

    public static void printInstructions() {

        System.out.println("\nPlease choose country in which you are are having income:");
        System.out.println("\t 0 - Latvia");
        System.out.println("\t 1 - Spain");
        System.out.println("\t 2 - Vatican");
        System.out.println("\t 3 - Monaco");
        System.out.println("\t 4 - Wonderland");
        System.out.println("\t 5 - To quit the application");
    }

    public static void Latvia(Connection conn) throws Exception {

        System.out.println("Enter number of children under 18 years old:");
        int children = scanner.nextInt();
        System.out.println("Enter your not applicable minimum:");
        double minimum = scanner.nextDouble();
        System.out.println("Enter your gross income:");
        double grossIncome = scanner.nextDouble();
        System.out.println("Do you have disability? True/False");
        boolean disability = scanner.nextBoolean();
        System.out.println("Are you a pensioner? True/False");
        boolean pensioner = scanner.nextBoolean();

        try {
            countryList.Latvia(conn, children, minimum, grossIncome, disability, pensioner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Spain(Connection conn) throws SQLException {

        System.out.println("If you work in private sector please press 1, if in governmental sector press 2.");
        int industry = scanner.nextInt();
        System.out.println("Enter your gross income:");
        double grossIncome = scanner.nextDouble();
        System.out.println("Enter your rent:");
        double rent = scanner.nextDouble();
        System.out.println("Enter your mortgage:");
        double mortgage = scanner.nextDouble();
        System.out.println("Enter your donations:");
        double donations = scanner.nextDouble();
        countryList.Spain(conn, industry, grossIncome, rent, mortgage, donations);
    }

    public static void Vatican(Connection conn) throws SQLException {
        System.out.println("Are you a pop?");
        boolean pop = scanner.nextBoolean();
        System.out.println("Do you believe in God?");
        boolean god = scanner.nextBoolean();
        System.out.println("Enter your gross income:");
        double grossIncome = scanner.nextDouble();
        countryList.Vatican(conn, pop, god, grossIncome);
    }

    public static void Monaco(Connection conn) throws SQLException {
        System.out.println("How many months are you residenting in Monaco?");
        int months = scanner.nextInt();
        System.out.println("Enter amount of deposit in Monaco bank:");
        double deposit = scanner.nextDouble();
        System.out.println("Enter amount of gross Income in Monaco bank:");
        double grossIncome = scanner.nextDouble();
        countryList.Monaco(conn, months, deposit, grossIncome);
    }

    public static void Wonderland(Connection conn) throws SQLException {
        System.out.println("Do you have pets? For cat press 1, for dog press 2.");
        int pet = scanner.nextInt();
        System.out.println("Enter your gross income:");
        double grossIncome = scanner.nextDouble();
        countryList.Wonderland(conn, pet, grossIncome);
    }

    public static void readUsersLatvia(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usersLatvia;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int personID = resultSet.getInt("PersonID");
            int pensioner = resultSet.getInt("Pensioner");
            int disability = resultSet.getInt("Disability");
            double minimum = resultSet.getDouble("Minimum");
            double grossIncome = resultSet.getDouble("GrossIncome");
            int children = resultSet.getInt("Children");

            String output = "Users Latvia info: \n\t id: %d \n\t Pensioner: %d \n\t" +
                    "Disability: %d \n\t Minimum: %.2f \n\t Gross Incomes: %.2f \n\t Children: %d";

            System.out.println(String.format(output, personID, pensioner, disability, minimum, grossIncome, children));
        }
    }

    public static void readUsersSpain(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usersSpain;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int personID = resultSet.getInt("PersonID");
            double grossIncome = resultSet.getDouble("GrossIncome");
            int industry = resultSet.getInt("Industry");
            double rent = resultSet.getDouble("Rent");
            double mortgage = resultSet.getDouble("Mortgage");
            double donations = resultSet.getDouble("Donations");

            String output = "Users Spain info: \n\t id: %d \n\t Gross Incomes: %.2f \n\t Industry: %d \n\t " +
                    "Rent: %.2f \n\t Mortgage: %.2f \n\t Donations: %.2f";

            System.out.println(String.format(output, personID, grossIncome, industry, rent, mortgage, donations));
        }
    }

    public static void readUsersVatican(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usersVatican;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int personID = resultSet.getInt("PersonID");
            double grossIncome = resultSet.getDouble("GrossIncome");
            int pop = resultSet.getInt("Pop");
            int god = resultSet.getInt("God");

            String output = "Users Vatican info: \n\t id: %d \n\t Gross Incomes: %.2f  \n\t Pop: %d \n\t God: %d";

            System.out.println(String.format(output, personID, grossIncome, pop, god));
        }
    }

    public static void readUsersMonaco(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usersMonaco;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int personID = resultSet.getInt("PersonID");
            double grossIncome = resultSet.getDouble("GrossIncome");
            int month = resultSet.getInt("Month");
            double deposit = resultSet.getDouble("Deposit");

            String output = "Users Monaco info: \n\t id: %d \n\t  Gross Incomes: %.2f \n\t Month: %d \n\t Deposit: %.2f";

            System.out.println(String.format(output, personID, grossIncome, month, deposit));
        }
    }

    public static void readUsersWonderland(Connection conn) throws SQLException {
        String sql = "SELECT * FROM usersWonderland;";

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {

            int personID = resultSet.getInt("PersonID");
            double grossIncome = resultSet.getDouble("GrossIncome");
            int pet = resultSet.getInt("Pet");

            String output = "Users Wonderland info: \n\t id: %d  \n\t Gross Incomes: %.2f \n\t Pet %d";

            System.out.println(String.format(output, personID, grossIncome, pet));
        }
    }
}
