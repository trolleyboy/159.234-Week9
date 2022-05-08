package tutorial9.task2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming" 2nd Edition, Springer, 2020
 * 
 * @author David Parsons
 * 
 * Modified Course class that holds an ArrayList of Modules
 */

public class Course implements Serializable
{
	private static int numberOfCoursesCreated = 0;
	private String name;
	private int numberOfDays;
	private double pricePerPerson
	;
	// an array of modules
	private ArrayList<Module> modules = new ArrayList<Module>();

	/**
	 * zero arguments constructor
	 */
	public Course() 
	{
		this("Unnamed Course", 3, 1000.0);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            The name of the course
	 * @param days
	 *            The length of the course in days
	 * @param price
	 *            The price of the course per person
	 */
	public Course(String name, int days, double price) throws IllegalArgumentException
	{
		setName(name);
		setNumberOfDays(days);
		setPricePerPerson(price);
		numberOfCoursesCreated++;
	}

	/**
	 * @return How many Course objects have been created
	 */
	public static int getNumberOfCoursesCreated()
	{
		return numberOfCoursesCreated;
	}

	/**
	 * @return The name of the course
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            The name of the course
	 */
	public void setName(String name) throws NullPointerException
	{
		if(name == null)
		{
			throw new NullPointerException("Course name is null");
		}
		this.name = name;
	}

	/**
	 * @return The length of the course
	 */
	public int getNumberOfDays()
	{
		return numberOfDays;
	}

	/**
	 * @param numberOfDays
	 * @throws IllegalArgumentException
	 */
	public void setNumberOfDays(int numberOfDays) throws IllegalArgumentException
	{
		if (numberOfDays < 1 || numberOfDays > 10)
		{
			throw new IllegalArgumentException(numberOfDays + " is outside the valid range of 1 - 10");
		}
		else
		{	
			this.numberOfDays = numberOfDays;
		}
	}

	/**
	 * @return The price of the course per person
	 */
	public double getPricePerPerson()
	{
		return pricePerPerson;
	}

	/**
	 * @param price
	 *            The price of the course per person
	 */
	public void setPricePerPerson(double price)
	{
		this.pricePerPerson = price;
	}

	// 'addModule' adds a parameter module to the array.
	public void addModule(Module newModule)
	{
		modules.add(newModule);
	}

	public int getTotalCredits()
	{
		int total = 0;
		for (Module m : modules) {
			total += m.getCreditPoints();
		}
		return total;
	}

	public ArrayList<Module> getModules()
	{
		return modules;
	}

	public int getModuleCount()
	{
		return modules.size();
	}
	
	public Module getModule(int index)
	{
		return modules.get(index);
	}

	@Override
	public String toString() {
		StringBuilder moduleNames = new StringBuilder();
		for (Module module : getModules()) {
			moduleNames.append(module.getName() + ", ");
		}
		return getName() + " is a " + getNumberOfDays() + " day course costing " + getPricePerPerson() + 
		" and contains the modules " + moduleNames;
	}
}
