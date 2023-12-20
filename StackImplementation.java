/*
 * Name: Suvanga Dhakal
 * Project description: Make a new stack class and make functions that a normal stack would possess, 	
 * 						it will have peek pop, isFull(),isEmpty(), push(argument), and expand(): (To make the stack dynamic )  
 * 						First we tested this class without putting the expand method then later we decided that we need an expand method to make it dynamic
 */



public class StackImplementation<T> implements StackInterface<T> //We are inputting T data type
{
	
	T[] stack;													//This is a stack object which stores data of T type and T could be of any primary data type
	int itemsOnStack; 											//The number of items in stack 
	public StackImplementation() 								//We are making a default constructor
	    { 
	        stack = (T[]) new Object[0];						// We create an empty stack and cast it as T type
	        itemsOnStack = 0;									//The initial size of the items on Stack would be 0
	    }
	public StackImplementation (int initialSize)				//The initial sizer of the stack is passed as an argument
	{ 
		 stack = (T [ ] ) new Object[initialSize];				// we are instantiating an object from Object class and casting it as T[] array
		 itemsOnStack = 0;										//The initial size of stack is set to be 0
	}
	@Override
	public void push(T item)            //Push method for the push functionality for our stack
	{
		if(isFull()!=true)              //If isFull is not true then this if block will run
		{
			
			stack[itemsOnStack]  =item; //The stack is loaded with the item the user pushed// TODO Auto-generated method stub//
			itemsOnStack++;				//The number of items in the stack is added by 1
		}
		else 
		{
			expandArray();				//Since the Array is full as !=true statement is failed we will go through this line and expand the array by 10 
			stack[itemsOnStack]  =item; //The stack is loaded with the item the user pushed of T type// TODO Auto-generated method stub//
			itemsOnStack++;				//The number of items in the stack is added by 1 
		}
	}

	@Override
	public T peek() 					//This option will help us see the number of item in the stack 
	{
		if(!isEmpty())					//If the array is not empty the following if statement block is run
		{
			return stack[itemsOnStack-1]; //stack is showing the last item in the stack 
		}
		else if(isEmpty()==true)		  //If the stack is empty then it will print that the stack has become empty 
		{
			System.out.print("The Stack is found to be empty");//it will print this message as an error message and return null 
			return null;
		}
		// TODO Auto-generated method stub
		System.out.println("we are unable to peek");//If something extreme case occur then this will run which is impossible I think
		return null; // This will also return the null result 
	}

	@Override
	public T pop() //This will display the first item from the last as array is LIFO
	{
		// TODO Auto-generated method stub
		if(isEmpty()!=true) //If the stack is not full then the following if block will run
		{
			T unit = stack[itemsOnStack-1];//The unit is of type t and stores the last item in stack array
			stack[itemsOnStack-1] = null;//The value of last item is declared as null so that new item could be pushed in in its place if needed
			itemsOnStack--;//The number of items in the stack is decreased by 1
			return unit;//This will return the last item in the stack
		}
		else // There is only one case its either the stack is empty or not so if its not empty then
		{
			System.out.println("The Stack is empty");//The error message is printed on the console
			return null;	//This will return null
		}
		
	}

	@Override
	public boolean isFull() //We will check to see if the array stack is full or not 
	{
		// TODO Auto-generated method stub
		if(stack.length==itemsOnStack) //If the number of itemsOn the stack is equal to the length provided by the user then the stack is full
		{	
			return true;	//This will return that the stack is full
		}
		else 
		{
			return false;//If the stack is not full or has more capacity then this line of code will run
		}
		
	}

	@Override
	public boolean isEmpty() //This is a boolean type method that checks if the stack is empty or not 
	{
		// TODO Auto-generated method stub
		if(itemsOnStack==0)	//If the items in the stack is found to be 0 then it will return true  
		{
			return true;	//This returns true 
		}
		else 				//If the above statement is not run then the isEmpty boolean will return false
		{
			return false;	//This line will return code as false 
		}
		
	}
	
	protected void expandArray()//This will expand the array and make the stack dynamic in nature  
	{
		 T[] biggerStack;//A new array named bigger stack is declared of type T which is a generic type.

		 biggerStack = (T []) new Object[stack.length + 10];//This line is to instantiate a new object of type object and takes the length to be 10 more than the original size

		 for (int item = 0; item < stack.length; item ++) 
		 {
			 //This is a for loop to run the iteration as many times as needed  
			 biggerStack[item] = stack[item]; //stack is transferring all the items in the biggerStack from Stack this will run until the total number of item is transferred
		 }
	 stack = biggerStack;//Finally the stack has its own value, however it is increased by 10 in its size

	 } 	
	
	
}
