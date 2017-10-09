package group_project;

/**
 *
 * @author Wesley
 */

/**************************************************************************
*I assume that a line from the group assignment sheet saying that salaried  *
*employees get time and a half over 40 hours is incorrect.                  *
*UPDATE: Got an email from Wahjudi. That line was a typo.                   *                              
****************************************************************************/

public class SalariedEmployee extends Employee{
//Variables**************************************
    private double basePay;
   
//Accessors**************************************
    public double getBasePay() { return this.basePay;}
        
//Mutators***************************************    
    public void setBasePay(double inBasePay) { this.basePay = inBasePay;}
    
//Methods****************************************
    @Override
    public double findPay()
    {
        return getBasePay();
    }
    
    @Override
    public String toString()
    {
        String str = super.toString() + "\n" + "Base Pay:  " + this.basePay + "\t" + "Total Pay:  " + this.findPay() + "\n";
        return str;
    }
    
    @Override
    public boolean equals(Employee other)
    {
        if(other instanceof SalariedEmployee)
        {
            SalariedEmployee otherEmployee = (SalariedEmployee)other;
            return super.equals(otherEmployee) && this.basePay == otherEmployee.getBasePay();
        }
        return false;
    }
    
//Constructors***********************************
    public SalariedEmployee(String inName, int inEmpID, double inBasePay)
    {
        super(inName,inEmpID);
        this.type = "Salaried";
        this.basePay = inBasePay;
    }
}