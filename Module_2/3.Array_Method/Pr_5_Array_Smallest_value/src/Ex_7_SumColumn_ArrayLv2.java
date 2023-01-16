public class Ex_7_SumColumn_ArrayLv2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,7},
                {4,5,7},
                {7,8,9}
        };
        int columnIn = 1;
        printArrayLv2(arr);
        System.out.println("-------");
        int sum = sumColumnArrayLv2(arr, columnIn);
        System.out.println("Total column " + columnIn + " : " + sum );


    }
    public static int sumColumnArrayLv2(int[][] arr, int columnIn){
        int sum = 0;
        for (int row = 0; row < arr.length; row++) {
//            for (int column = 0; column < arr[row].length; column++) {
//                sum += arr[row][columnIn];
//            }
            sum += arr[row][columnIn];
        }
        return sum;
    }
    public static void printArrayLv2(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
    }

}
