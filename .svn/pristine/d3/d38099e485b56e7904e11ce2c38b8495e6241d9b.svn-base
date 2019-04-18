package com.cejv416.internetbill;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Jianyu Feng
 * 
 * Internet service provider three different subscription packages for the customers:
 * Package A:	For $9.95 per month 10 hours of access are provided. Additional hours are $2.00 per hour.
 * Package B:	For $14.95 per month 20 hours of access are provided. Additional hours are $1.00 per hour.
 * Package C:	For $19.95 per month unlimited access is provided.
 * 
 * ISPCharger class is to calculate the monthly charge, and provide the comparison result if there better plan available
 */
public class ISPCharger {

    // create Scanner class to read input
    private Scanner sc;
    
    // current internet package
    private InternetBean ib;
    
    // compare to other internet package
    private InternetBean compareToA;
    private InternetBean compareToB;
    private InternetBean compareToC;
    
    // package basic fee
    private static final double PACKAGEA_FEE = 9.95;
    private static final double PACKAGEB_FEE = 14.95;
    private static final double PACKAGEC_FEE = 19.95;
    
    // package including hours
    private static final double PACKAGEA_HOUR = 10;
    private static final double PACKAGEB_HOUR = 20;
    
    // fee for additional hours
    private static final double PACKAGEA_HOUR_RATE = 2.0;
    private static final double PACKAGEB_HOUR_RATE = 1.0;
    
    NumberFormat nf = NumberFormat.getInstance();
    
    // check best package
    // if bestP == true, you choosed the best package
    // if bestP == false, there is better package available
    private static boolean bestP = true;

    
    /**
     * ISPCharger constructor
     */
    public ISPCharger() {
        super();
        sc = new Scanner(System.in);
        
        // initial object for current package
        ib = new InternetBean();
        
        // initial 3 objects for comparision
        compareToA = new InternetBean();
        compareToB = new InternetBean();
        compareToC = new InternetBean();

        compareToA.setInternetPackage('A');
        compareToB.setInternetPackage('B');
        compareToC.setInternetPackage('C');

    }

    /**
     * this method is to ask user to input the package letter,
     * and will validate if the package letter is a,b,c,A,B or C
     * <p>
     * if is invalid letter, will ask user to input again
     * 
     */
    private void getPackage() {
        char iPackage = 'z';

        System.out.println("Please input the subscription package: [A, B or C]");

        // validate if user input correct package letter, only a, b, c, A, B or C is valid
        if (sc.hasNext("[abcABC]")) {
            iPackage = sc.next().toUpperCase().charAt(0);
        } else {
            iPackage = 'z';
        }
        sc.nextLine();

        while (iPackage < 'A' || iPackage > 'C') {
            System.out.println("Invalid package, please input the package again: [A, B or C]");

            if (sc.hasNext("[abcABC]")) {
                iPackage = sc.next().toUpperCase().charAt(0);
            } else {
                iPackage = 'z';
            }
            sc.nextLine();
        }

        ib.setInternetPackage(iPackage);
    }

    /**
     * this method is to ask user to input total hours number
     * <p>
     * total hours number must be great than 0, and less than 744 hours (= 31 * 24)
     * <p>
     * if the total hours number is invalid, will ask user to input again
     * 
     */
    private void getHours() {
        double hour = 0.0;

        System.out.println("Please input the total hours for the package " + ib.getInternetPackage() + ": [no more than 744 hours]");

        if (sc.hasNextDouble()) {
            hour = sc.nextDouble();
        } else {
            hour = 0.0;
        }
        sc.nextLine();

        while (hour <= 0 || hour > 744) {
            System.out.println("Invalid hours, please input the total hours for the package " + ib.getInternetPackage() + " again: [no more than 744 hours]");

            if (sc.hasNextDouble()) {
                hour = sc.nextDouble();
            } else {
                hour = 0.0;
            }
            sc.nextLine();
        }

        ib.setTotalHours(hour);
    }

    /**
     * this method is to calculate the billable hours number
     * <p>
     * based on different package, billable hours = total hours - PACKAGE_HOUR or 0.0
     * 
     * @param ib Internet package object
     * 
     */
    private void calculateBillableHours(InternetBean ib) {
        
        double billableHour = 0.0;

        double totalHour;

        totalHour = ib.getTotalHours();

        switch (ib.getInternetPackage()) {
            case 'A':
                billableHour = (totalHour > PACKAGEA_HOUR) ? totalHour - PACKAGEA_HOUR : 0.0;
                break;
            case 'B':
                billableHour = (totalHour > PACKAGEB_HOUR) ? totalHour - PACKAGEB_HOUR : 0.0;
                break;
            case 'C':
                billableHour = 0.0;
                break;
        }

        ib.setBillableHours(billableHour);
    }

    /**
     * this method is to calculate total monthly charge
     * <p>
     * total charge = basic monthly cost + billable hours charge
     * 
     * @param ib Internet package object
     * 
     */
    private void calculateCharge(InternetBean ib) {
        
        double billableHour = 0.0;
        double monthlyCost = 0.0;

        // get billable hours
        billableHour = ib.getBillableHours();

        switch (ib.getInternetPackage()) {
            case 'A':
                monthlyCost = PACKAGEA_FEE + billableHour * PACKAGEA_HOUR_RATE;
                break;
            case 'B':
                monthlyCost = PACKAGEB_FEE + billableHour * PACKAGEB_HOUR_RATE;
                break;
            case 'C':
                monthlyCost = PACKAGEC_FEE;
                break;
        }

        ib.setMonthlyCost(monthlyCost);
    }

    /**
     * this method is to calculate billable hours and monthly charge
     * <p>
     * basically, it is to calculate what the same usage will cost based on the package object parameter
     * 
     * @param ib Internet package object
     * 
     * 
     */
    private void compareCharge(InternetBean ib) {
        
        // get the same total hours from current input pakcage
        ib.setTotalHours(this.ib.getTotalHours());
        
        calculateBillableHours(ib);
        calculateCharge(ib);

    }

    /**
     * this method is to display the comparison result only if there better package available 
     * 
     * @param ib Internet package object
     * 
     */
    private void displayCompareCharge(InternetBean ib) {
        nf.setMaximumFractionDigits(2);

        if (this.ib.getMonthlyCost() - ib.getMonthlyCost() > 0) {
            System.out.print("\n");
            System.out.println("==================================");
            System.out.println(" Consider update to package " + ib.getInternetPackage() + " ?");
            System.out.println("    Total hours: " + nf.format(ib.getTotalHours()));
            System.out.println(" Billable hours: " + nf.format(ib.getBillableHours()));
            System.out.println("     New charge: " + NumberFormat.getCurrencyInstance().format(ib.getMonthlyCost()));
            System.out.println("    You'll save: " + NumberFormat.getCurrencyInstance().format(this.ib.getMonthlyCost() - ib.getMonthlyCost()));
            System.out.println("==================================");

            bestP = false; // to determin there is better package available
        }


    }

    /**
     * this method is to display the main monthly statement
     * <p>
     * and show the comparison result if there better package available
     * or tell user the best package is chose
     */
    private void displayCharge() {
        nf.setMaximumFractionDigits(2);

        // display the current package monthly cost
        System.out.println("==================================");
        System.out.println(" Your internet monthly statement ");
        System.out.println("----------------------------------");
        System.out.println("        Package: " + ib.getInternetPackage());
        System.out.println("    Total hours: " + nf.format(ib.getTotalHours()));
        System.out.println(" Billable hours: " + nf.format(ib.getBillableHours()));
        System.out.println("   Total charge: " + NumberFormat.getCurrencyInstance().format(ib.getMonthlyCost()));
        System.out.println("==================================");

        // display comparision of what the same usage would cost in the each other plans 
        InternetBean[] allPackage = {compareToA, compareToB, compareToC};
        for (InternetBean i : allPackage) {
            if (ib.getInternetPackage() != i.getInternetPackage()) {
                compareCharge(i);
                displayCompareCharge(i);
            }
        }
        
        // or current package cost is the lowest one
        if (bestP) {
            System.out.println(" You choosed the best package!");
            System.out.println("==================================");
        }

    }

    /**
     * this method is to perform all above methods
     */
    public void perform() {
        // request package
        getPackage();
        
        // request total hours
        getHours();
        
        // calculate billable hours for current package
        calculateBillableHours(ib);
        
        // calculate monthly cost for current package
        calculateCharge(ib);
        
        // display current package monthly statement
        // plus comparision if there better package available
        displayCharge();
    }

    /**
     * uncommon the following code to test this java file
     */

//    public static void main(String[] args) {
//        ISPCharger ic = new ISPCharger();
//
//        ic.perform();
//
//    }
}
