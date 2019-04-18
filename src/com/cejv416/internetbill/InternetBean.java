package com.cejv416.internetbill;

/**
 *
 * @author Jianyu Feng
 * 
 * this class is to encapsulate the main members of internet package
 * 
 */
public class InternetBean {

    private char internetPackage; //The letter representing the package: A, B or C
    private double totalHours; //The total number of hours spend in one month
    private double billableHours; //The number of hours less the hours that are part of a package (never less than 0)
    private double monthlyCost; //The monthly cost for the selected plan

    public InternetBean() {
        super();
    }

    public char getInternetPackage() {
        return internetPackage;
    }

    public void setInternetPackage(char internetPackage) {
        this.internetPackage = internetPackage;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double getBillableHours() {
        return billableHours;
    }

    public void setBillableHours(double billableHours) {
        this.billableHours = billableHours;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}
