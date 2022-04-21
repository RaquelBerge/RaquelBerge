package finalProject;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class countryList {

    Scanner scanner = new Scanner(System.in);

    public void Latvia(Connection conn,int children, double minimum, double grossIncome, boolean disability, boolean pensioner)throws Exception{

        String sql = "INSERT INTO usersLatvia(pensioner, disability, minimum, grossIncome, children) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setBoolean(1, pensioner);
        preparedStatement.setBoolean(2, disability);
        preparedStatement.setDouble(3, minimum);
        preparedStatement.setDouble(4, grossIncome);
        preparedStatement.setInt(5,children);


        int pens;
        if (pensioner = true) {
            pens = 300;
        } else {
            pens = 0;
        }
        int dis;
        if (disability = true) {
            dis = 150;
            minimum = 0;
        } else {
            dis = 0;
        }
        //social tax
        double socialTax = grossIncome * 0.105;
        System.out.println("Your social tax is " + socialTax);

        //income tax rate
        double yearIncome = grossIncome * 12;

        if(yearIncome <= 20004){
            double incomeTaxRate = 0.20;
        } else if (yearIncome <= 78100){
            double incomeTaxRate = 0.23;
        } double incomeTaxRate = 0.31;
        System.out.println("Your income tax rate is " + incomeTaxRate);

        //income tax
        double incomeTax = (grossIncome - socialTax - children * 250 - minimum - dis - pens) * incomeTaxRate;

        //netSalary
        double netIncome = grossIncome - socialTax - incomeTax;
        System.out.println("Your net income is: " + netIncome);
    }

    public void Spain(Connection conn,int industry, double grossIncome, double rent, double mortgage, double donations)throws SQLException{

        String sql = "INSERT INTO usersSpain (industry, grossIncome, rent, mortgage, donations) VALUES (?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1,industry);
        preparedStatement.setDouble(2, grossIncome);
        preparedStatement.setDouble(3, rent);
        preparedStatement.setDouble(4, mortgage);
        preparedStatement.setDouble(5,donations);


        if(industry == 1){double socialTaxRate = 0.1d;} double socialTaxRate = 0.05d;
        System.out.println("Your income tax rate is " + socialTaxRate);
        //social tax
        double socialTax = grossIncome * socialTaxRate;
        System.out.println("Your social tax is " + socialTax);
        //income tax rate
        double yearIncome = grossIncome * 12;

        if(yearIncome <= 12450){
            double incomeTaxRate = 0.19;
        } else if (yearIncome <= 20200){
            double incomeTaxRate = 0.24;
        } else if (yearIncome <=35200){
            double incomeTaxRate = 0.30;
        }else if(yearIncome <= 60000){
            double incomeTaxRate = 0.37;
        } double incomeTaxRate = 0.45;
        System.out.println("Your income tax rate is " + incomeTaxRate);

        //income tax
        double incomeTax = (grossIncome - socialTax - rent - mortgage - donations) * incomeTaxRate;
        //netSalary
        double netIncome = grossIncome - socialTax - incomeTax;
        System.out.println("Your net income is: " + netIncome);
    }

    public void Vatican(Connection conn, boolean pop, boolean god, double grossIncome)throws  SQLException {

        String sql = "INSERT INTO usersVatican (pop, god, grossIncome) VALUES (?, ?, ?);";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setBoolean(1, pop);
        preparedStatement.setBoolean(2, god);
        preparedStatement.setDouble(3, grossIncome);


        double incomeTaxRate;
        if(pop == true) {incomeTaxRate = 0.05d;} else {incomeTaxRate = 0;}

        double GODincomeTaxRate;
        if(god == true) {GODincomeTaxRate = 0;} else {GODincomeTaxRate = 0.20d;}

        System.out.println("Your income tax rate is " + incomeTaxRate);
        //income tax
        double incomeTax = grossIncome * incomeTaxRate;
        double GODincomeTax = grossIncome * GODincomeTaxRate;
        //netSalary
        double netIncome = grossIncome + incomeTax - GODincomeTax;
        System.out.println("Your net income is: " + netIncome);
    }

    public void Monaco(Connection conn, int months, double deposit, double grossIncome)throws SQLException{

        String sql = "INSERT INTO usersMonaco (month, deposit, grossIncome) VALUES (?, ?, ?);";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setInt(1, months);
        preparedStatement.setDouble(2, deposit);
        preparedStatement.setDouble(3, grossIncome);


        double incomeTaxRate = 0;
        if (months < 3 && deposit >= 500000d) {
            incomeTaxRate = 0;
        }
        else if (months > 3){
            incomeTaxRate = 0.5d;
        }

        System.out.println("Your income tax rate is " + incomeTaxRate);
        //income tax
        double incomeTax = grossIncome * incomeTaxRate;
        //netSalary
        double netIncome = grossIncome + incomeTax;
        System.out.println("Your net income is: " + netIncome);
    }

    public void Wonderland(Connection conn, int pet, double grossIncome)throws SQLException{

        String sql = "INSERT INTO usersWonderland (pet, grossIncome) VALUES (?, ?);";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);


        preparedStatement.setInt(1, pet);
        preparedStatement.setDouble(2, grossIncome);


        double incomeTaxRate;
        if(pet == 1) {incomeTaxRate = 0.05d;} else {incomeTaxRate = 0.1d;}

        System.out.println("Your income tax rate is " + incomeTaxRate);
        //income tax
        double incomeTax = grossIncome * incomeTaxRate;
        //netSalary
        double netIncome = grossIncome - incomeTax;
        Random generator = new Random();
        double num = generator.nextDouble()*(0.5d-0) + 0;
        double randTax = grossIncome * num;
        System.out.println("Your random tax: " + num);

        System.out.println("Your net income is: " + netIncome);

        double netIncome2 = grossIncome - randTax - incomeTax;
        System.out.println("Your net income is: " + netIncome2);
    }

}
