package group_project;

/**
 *
 * @author Wesley
 */

public class CommissionedEmployee extends Employee{
//Variables**************************************
    private double basePay;
    private double weeklySales;
    private double commissionRate; //I assume for the rest of this program that commissionRate is handled as a number < 1. E.G. 20% would be .2
    
//Accessors**************************************
    public double getBasePay() { return this.basePay;}
    public double getWeeklySales() { return this.weeklySales; }
    public double getCommissionRate() { return this.commissionRate;}
    
//Mutators***************************************
    public void setBasePay(double inBasePay) { this.basePay = inBasePay;}
    public void setWeeklySales(double inWeeklySales) { this.weeklySales = inWeeklySales;}
    public final void setCommissionRate(double inCommissionRate) 
    { 
        //In case someone tries to input a number higher than 1 to represent a 
        //percentage this method will correct it to decimal form needed for other methods
        if(inCommissionRate <= 1)
            this.commissionRate = inCommissionRate;
        else
            this.commissionRate = inCommissionRate/100;
    }
    
//Methods****************************************
    @Override
    public double findPay()
    {
        return this.basePay + (this.weeklySales * this.commissionRate);   
    }
    
    @Override
    public String toString()
    {
        String str = super.toString() + 
            "\n" + "BasePay:  " + this.basePay + "\t" + "Weekly Sales:  "+ this.weeklySales + "\t" + "CommissionRate:  " +
            this.commissionRate + "\t" + "Total Pay:  " + this.findPay() + "\n";
        return str;
    }
    
    @Override 
    public boolean equals(Employee other)
    {
        if(other instanceof CommissionedEmployee)
        {
            CommissionedEmployee otherEmployee = (CommissionedEmployee)other;
            return super.equals(otherEmployee) && this.basePay == otherEmployee.getBasePay() && this.commissionRate == otherEmployee.getCommissionRate();
        }
        return false;
    }
    
//Constructors***********************************
    public CommissionedEmployee(String inName, int inEmpID, double inBasePay, double inWeeklySales, double inCommissionRate)
    {
        super(inName, inEmpID);
        this.type = "Commissioned";
        this.basePay = inBasePay;
        this.weeklySales = inWeeklySales;
        this.setCommissionRate(inCommissionRate);
    }
}