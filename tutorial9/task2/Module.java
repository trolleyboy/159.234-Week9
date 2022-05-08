package tutorial9.task2;

import java.io.Serializable;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 *
 * 'Module' class (associated with 'Course' class)
 */

public class Module implements Serializable
{
	private String name;
	private int creditPoints;
	private String assessment;
	
	public Module(String name, int points, String assess)
	{
		setName(name);
		setCreditPoints(points);
		setAssessment(assess);
	}
    
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setCreditPoints(int creditPoints)
	{
		this.creditPoints = creditPoints;
	}
	
	public void setAssessment(String assessment)
	{
		this.assessment = assessment;
	}

	public String getName()
	{
		return name;
	}
	
	public int getCreditPoints()
	{
		return creditPoints;
	}
	
	public String getAssessment()
	{
		return assessment;
	}
}
