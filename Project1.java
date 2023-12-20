/*
 * Name: Suvanga Dhakal
 * Professor: Dr.Heuring
 * Project: Finding stable roomate using backtracking and recursion algorithm using own stack
 * 
 */
import java.util.*;

public class Project1 
{
    public static void main(String[] args)//Main method 
    {
        Scanner input = new Scanner(System.in);//making input as scanner object

        int n = input.nextInt();//Taking total number of people input
        int roomsnum = n / 2;//Total room num
        List<Person> people = new ArrayList<>();//people storing person objects in a list

        for (int i = 0; i < n; i++)//for loop for preferences inputs  and people list being added with persons objects
        {
            List<Integer> preferences = new ArrayList<>();//this will store all the preference input
            for (int j = 0; j < n - 1; j++)//for storing total preferences 
            {
                int m = input.nextInt();//total inputs of people
                preferences.add(m);//adding preferences in a preference list
            }
            people.add(new Person(i, preferences));//this will add person objects with their unique id
        }

        List<Room> result = backtrack(people, n);//Result will store backtrack result 
        if (result != null)//if the result has some value 
        {
            for (int i = 0; i < result.size(); i++)
            {
                Room room = result.get(i);//The first combination is stored and like wise one at a time
                System.out.println("Room " + i + ": Person " + room.occupants.get(0).id + " and Person " + room.occupants.get(1).id);
            }	//Printing the final result 
        } else {
            System.out.println("No stable room assignment found.");//if the result list is empty, we could not find any combination
        }
    }

    private static boolean isPersonInAnyRoom(Person person, List<Room> rooms)//checks if there is anyone in the room to check and see to not lrert any member being leftover 
    {
        for (Room room : rooms)//loop to store room with all the rooms value one at a time 
        {
            if (room.occupants.contains(person)) //checks if there is any remaining person
            {
                return true;//if there is then it will return true to the backtrack method it goes
            }
        }
        return false;//else returns false as a default
    }

    private static List<Room> backtrack(List<Person> people, int n) 
    {
        StackImplementation<List<Room> > stack = new StackImplementation<>();//stack is created with our own stack class
        stack.push(new ArrayList<>());//pushing an empty array list

        while (!stack.isEmpty()) //Checking if stack is empty
        {
            List<Room> currentRooms = stack.pop();//this will pop one stack at a time to fill the currentrooms

            if (currentRooms.size() == people.size() / 2)//to check the combinations 
            {
                if (isStable(currentRooms))//If it is stable, it returns current room as the answer of stable assignment 
                {
                    return currentRooms;
                }
                continue;
            }

            for (int i = 0; i < people.size(); i++) //This loop will help us store person in the room
            {
                Person person1 = people.get(i);//this will get the first person stored with person1 object
                if (!isPersonInAnyRoom(person1, currentRooms))//checks if there is any remaining people 
                {
                    for (int j = i + 1; j < people.size(); j++) //loop to store the second person
                    {
                        Person person2 = people.get(j);//this will put person2 as second member for the room
                        if (!isPersonInAnyRoom(person2, currentRooms)) //checks if the person 2 is assigned in any room
                        {
                            Room newRoom = new Room(person1, person2);//it will create a new room if not
                            List<Room> newRooms = new ArrayList<>(currentRooms);//new rooms stores current rooms
                            newRooms.add(newRoom);//current rooms is added to new room
                            stack.push(newRooms);//we will add the new room to the stack
                        }
                    }
                }
            }
        }

        return null;
    }

    public static boolean isStable(List<Room> roomList)//This will check to see if it has a stable arrangment
    {
        for (Room room : roomList)//room stores all the roomlist values and iterates 
        {
            for (Room otherRoom : roomList) //the other room is run
            {
                if (room != otherRoom) 
                {
                    Person personA = room.occupants.get(0);//first person of the room
                    Person personB = room.occupants.get(1);//second person of the room above
                    Person otherPersonA = otherRoom.occupants.get(0);//first person of the other room
                    Person otherPersonB = otherRoom.occupants.get(1);//second person of the other room

                    if (personA.getPreferences().indexOf(otherPersonA.getId()) < personA.getPreferences().indexOf(personB.getId()) &&//This will diagonally check for preference
                        otherPersonA.getPreferences().indexOf(personA.getId()) < otherPersonA.getPreferences().indexOf(otherPersonB.getId())) 
                    {//This will return if this room arrangement is stable or not in a stable arrangement 
                        return false;
                    }
                    	//Diagonally checking the same thing with criss cross method to check if we are performin an unstable room assignment
                    if (personA.getPreferences().indexOf(otherPersonB.getId()) < personA.getPreferences().indexOf(personB.getId()) &&
                        otherPersonB.getPreferences().indexOf(personA.getId()) < otherPersonB.getPreferences().indexOf(otherPersonA.getId())) {
                        return false;
                    }
                }
            }
        }
        return true;//returns true if we find an assignment which is stable
    }
}
