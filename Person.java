import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Importing all the necessary libraries
class Person 
{
    int id;//Integer id to store unique id/name input case person 0 is first case
    List<Integer> preferences;//This will store the list of preferences

    public Person(int id, List<Integer> preferences) //Making a constructor 
    {
        this.id = id;					//passing the arguments
        this.preferences = preferences;
    }

   
	public List<Integer> getPreferences() //getter methods for the preferences 
	{
        return preferences;
    }

    public int getId()//Getter method for getting the id  
    {
        return id;
    }
}