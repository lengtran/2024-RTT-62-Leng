package org.Projects.May_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayInsertFunction {
    //creating a function which will require a return

    public static int[] insert(int[] source, int insertPosition, int valueToInsert) {

        // 1) create a new array of size + 1
        int[] result = new int[source.length + 1];

        // 2) copy the first part of the array (before position 2) from the old to the new
        for (int pos = 0; pos < insertPosition; pos++) {
            result[pos] = source[pos];
        }

        // 3) actually insert the value we want in position 2
        result[insertPosition] = valueToInsert;

        // 4) copy over the rest of the array
        for (int pos = insertPosition; pos < source.length; pos++) {
            result[pos + 1] = source[pos];
        }
        return result;
    }
    public static int[] delete(int[] source, int deletePosition) {

        int[] deletedResult = new int[source.length - 1];

        for (int pos = 0; pos < deletePosition; pos++) {
            deletedResult[pos] = source[pos];
        }
        //prints out the index position for deletion.
//            System.out.println(pos);
//
//            //prints out the value of the deleted position.
//            System.out.println(deletedResult[pos]);

        //copy the last elements into a pos-1 in the new array
        for (int pos = deletePosition; pos < source.length; pos++) {
            deletedResult[pos - 1] = source[pos];
        }
//            for (int value : deletedResult) {
//                System.out.println(value);
//            }

        return deletedResult;
    }

    public static void main (String[]args){

        // original array
        // pos   01234
        // value 12345

        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));

        // array after inserting
        // pos   012345
        // value 129345

        array = insert(array, 2, 9);
        System.out.println(Arrays.toString(array));

        array = insert(array, 0, 0);
        System.out.println(Arrays.toString(array));

        array = delete(array, 2);
        System.out.println(Arrays.toString(array));
    }

}