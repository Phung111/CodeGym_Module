public class Ex_8_SumCross_ArrayLv2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,7},
                {7,8,10}
        };

        printArrayLv2(arr);
        System.out.println("-------");
        int sumLeft = sumCrossLeftArrayLv2(arr);
        System.out.println("Total cross from left: " + sumLeft );
        System.out.println("-------");
        int sumRight = sumCrossRightArrayLv2(arr);
        System.out.println("Total cross from right: " + sumRight );
    }
    public static int sumCrossLeftArrayLv2(int[][] arr){
        int sum = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if ( row == column) {
                    sum += arr[row][column];
                }

            }
        }
        return sum;
    }
    public static int sumCrossRightArrayLv2(int[][] arr){
        int sum = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if ( row + column == arr.length-1) {
                    sum += arr[row][column];
                }

            }
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
