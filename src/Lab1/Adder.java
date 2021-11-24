package Lab1;

import org.jetbrains.annotations.TestOnly;

import java.util.function.Function;

public class Adder {

     public static int[] adder(int[] list, Function<Integer, Integer> adder){
         int[] toReturn = new int[list.length];
         for (int i = 0; i <  list.length; i++)
             toReturn[i] = adder.apply(list[i]);

         return toReturn;
    }

    public static void main (String[] args){
        int[] list = {1, 2, -5, -4, 0, 6};
        int[] newList = adder(list, x -> x + 2);
        // OR:
        //Function<Integer, Integer> addTwo = x -> x + 2;
        //int[] newList = adder(list, addTwo);
    }
}
