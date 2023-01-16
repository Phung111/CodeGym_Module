public class Ex_4_FindLargestValue_ArrayLv2 {
    public static void main(String[] args) {
//        int[][] matrix = new int[2][3];
        int[][] arr = {
                {1,2,3,7},
                {4,5,7},
                {7}
        };
        int maxValue = findLargestValueArrayLv2(arr);
        printArrayLv2(arr);
        System.out.println("--------");
        System.out.println(maxValue);

        String position = findIdexMaxArray(arr);
        System.out.println("--------");
        System.out.println("The positions max value: " + position);
    }
    public static void printArrayLv2(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }
    public static int findLargestValueArrayLv2(int[][] arr){
        int max = arr[0][0];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] > max){
                    max = arr[row][column];
                }
            }
        }
        return max;
    }
    public static String findIdexMaxArray(int [][] arr) {
        String str = "";
        int k = 0;
        int l = 0;

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                int max = arr[0][0];
                for (int row2 = 0; row2 < arr.length; row2++) {
                    for (int column2 = 0; column2 < arr[row2].length; column2++) {
                        if (arr[row2][column2] >= max){
                            max = arr[row2][column2]; //max = 7
                            k = row2; // k = 2
                            l = column2; // l = 0
                        }
                    }
                }
                if (arr[row][column] == max) {
                    str += "["+row+"]["+column+"]";
                    if (row != k && column!= l) {
                        str += ",";
                    }
                }
            }
        }
        return str;
    }
//    int[] arr =  {7, 6, 7, 1, 3};



}
