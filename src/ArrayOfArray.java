/*
* Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers
* and returns an array of the products.
*
* For example, given:
* [1, 7, 3, 4]
*
* your method would return:
* [84, 12, 28, 21]
*
* by calculating:
* [7 * 3 * 4,  1 * 3 * 4,  1 * 7 * 4,  1 * 7 * 3]
*
* Do not use division in your solution.
*
* Solution attempt:
*
* */

import java.util.Arrays;

public class ArrayOfArray {

    public static void main(String[] args) {
        int[] intArray = {1, 7, 3, 4};
        System.out.println("productArray:");
        System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(intArray)));
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] inputArray) {
        // need an array of at least 2 numbers
        if (inputArray.length < 2) {
            throw new IllegalArgumentException("Product of numbers at other indices requires at least 2 numbers");
        }

        int[] productsArray = new int[inputArray.length];

        // for each integer, find the product of all the integers
        // before it, storing the total product so far each time
        // [0] is always 1
        int productSoFar = 1;

        // intArray = {1, 7, 3, 4}
        // i = 0, productsArray = [1, 0, 0, 0], productsSoFar = 1 = (1 * 1)
        // i = 1, productsArray = [1, 1, 0, 0], productsSoFar = 7 = (1 * 1 * 7)
        // i = 2, productsArray = [1, 1, 7, 0], productSoFar = 21 = (1 * 1 * 7 * 3)
        // i = 3, productsArray = [1, 1, 7, 21], productSoFar = 84 = (1 * 1 * 7 * 3 * 4)
        for (int i = 0; i < inputArray.length; i++) {
            productsArray[i] = productSoFar;
            productSoFar *= inputArray[i];
        }

        // now for each integer, find the product of all the integers
        // AFTER it, storing the total product so far each time
        // [array.length - 1] is always 1
        productSoFar = 1;

        // intArray = {1, 7, 3, 4}
        // j = 3, productsArray = [1, 1, 7, 21 * 1], productsSoFar = 4 = (4 * 1)
        // j = 2, productsArray = [1, 1, 7 * 4, 21], productsSoFar = 12 = (3 * 4 * 1)
        // j = 1, productsArray = [1, 1 * 12, 28, 21], productSoFar = 84 = (7 * 3 * 4 * 1)
        // j = 0, productsArray = [1 * 84, 12, 28, 21], productSoFar = 84 = (1 * 7 * 3 * 4 * 1)
        for (int j = inputArray.length - 1; j >= 0 ; j--) {
            productsArray[j] *= productSoFar;
            productSoFar *= inputArray[j];
        }

        return productsArray;
    }
}
