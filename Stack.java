import java.util.*;


public class Stack {

    List<Integer> array;

    public Stack()
    {
        //Creating new arrayList when a new stack object is created
        array=new ArrayList();
    }
    public void push(int val)
    {
        //Add new value to the stack;
        array.add(val);
    }

    public int pop()
    {
        //get the last inserted element from the arrayList and remove it if stack is not empty
        //If stack is empty return -1
        int element;
        if(array.size()>0)
        {
            element=array.get(array.size()-1);
            array.remove(array.size()-1);
        }
        else
        {
            element =-1;
        }
        return element;
    }

    public int peek()
    {

        //Method to get the last element from the arrayList
        int element;
        if(array.size()>0)
        {
            element=array.get(array.size()-1);
           // array.remove(array.size()-1);
        }
        else
        {
            element=-1;
        }
        return element;
    }

    public boolean isEmpty()
    {
        //Method to check if stack is empty or not.
        return (array.size()<=0);
    }
}


