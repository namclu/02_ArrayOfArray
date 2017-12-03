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
* Solution attempt: brute force
* */

public class ArrayOfArray {

    public static void main(String[] args) {
        int[] inputArray = {1, 7, 3, 4};
        int[] productArray = getProductsOfAllIntsExceptAtIndex(inputArray);

        System.out.println("productArray:");
        for (int myArray: productArray) {
            System.out.println(myArray);

        }
    }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] inputArray) {
        int[] productArray = new int[inputArray.length];

        // i = 0,  i < 4
        for (int i = 0; i < inputArray.length; i++) {
            int product = 1;

            // j = 0, 1, 2, 3, j < 4
            for (int j = 0; j < inputArray.length; j++) {
                // false,
                if (i != j) {
                    // product = 1, 1 * 7 = 7, 7 * 3 = 21, 21 * 4 = 84
                    product *= inputArray[j];
                    System.out.println(product);
                }
            }
            // [84, ]
            productArray[i] = product;
            System.out.println("---");
        }
        return productArray;
    }
}
