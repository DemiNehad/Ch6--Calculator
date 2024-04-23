package App;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Stateless
@Entity
public class Calculation 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double num1;
	private double num2;
	private String operation;
	
    public Calculation() {}

    public Calculation(int num1, int num2, String operation) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }
    
	public int getID()
	{
		return id;
	}

	public void setID(int id)
	{
		this.id = id;
	
	}
	public double getNum1()
	{
		return num1;
	}
	
	public void setNum1(double num1)
	{
		this.num1 = num1;
	}
	public double getNum2()
	{
		return num2;
	}
	public void setNum2(double num2)
	{
		this.num2 = num2;
	}
	 public String getOperation() 
	 {
	        return operation;
	 }

	 public void setOperation(String operation)
	 {
	        this.operation = operation;
	 }

}
