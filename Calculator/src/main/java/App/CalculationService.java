package App;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CalculationService 
{
	@PersistenceContext(unitName= "CalculatorDB")
	private EntityManager entitymanag;
	
	double result = 0;
	
	int num1;
	int num2;
	char operation;
	@POST
	@Path("calc")
	 public double performCalculation(Calculation calculation)
	{
	        double result;
	        double num1 = calculation.getNum1();
	        double num2 = calculation.getNum2();
	        String operation = calculation.getOperation();
	        switch (operation) {
	            case "+":
	                result = num1 + num2;
	                break;
	            case "-":
	                result = num1 - num2;
	                break;
	            case "*":
	                result = num1 * num2;
	                break;
	            case "/":
	                if (num2 == 0) 
	                {
	                	throw new IllegalArgumentException("Division by zero is not allowed.");
	                }
	                result = num1 / num2;
	                break;
	            default:
	            	throw new IllegalArgumentException("Invalid operation: " + calculation.getOperation());
	        }
	        entitymanag.persist(calculation); // Persist the calculation entity
	        return result;
	    }

	    @GET
	    @Path("calculations")
	    public List<Calculation> getAllCalculations() {
	        return entitymanag.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
	    }
	}


