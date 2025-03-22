import java.util.Arrays;

class SortedArray {

    public void findIntersection(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int[] tempResult = new int[Math.min(arr1.length, arr2.length)];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                //System.out.println("Inside duplicatecheck: k" + k + "arr1[i]" + arr1[i]);
                if (k == 0 || tempResult[k - 1] != arr1[i]) {

                    tempResult[k++] = arr1[i];
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("Common Element array: " + Arrays.toString(Arrays.copyOf(tempResult, k)));
    }
}


public class GetCommonElements {
    public static void main(String[] args) {
        
        int[] array1 = {1, 8, 12, 13, 22, 25, 36};
        int[] array2 = {2, 12, 14, 16, 17, 25};

        SortedArray obj = new SortedArray();
        obj.findIntersection(array1, array2);

    }
}
