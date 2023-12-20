import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public  class Room // room class
{
    List<Person> occupants;//Occupants list which stores person data type

    
    public Room(Person person1, Person person2) 
    {
        this.occupants = new ArrayList<>(Arrays.asList(person1, person2));//converting arrays as a set of list and storing occupants with two person objects
    }
}
