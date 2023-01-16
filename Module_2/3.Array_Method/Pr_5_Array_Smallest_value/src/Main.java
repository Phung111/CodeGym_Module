public class Main {
    public static void main(String[] args) {
        int[]arr = {14, 5, 7, 78, 45, 12};
        printArray(arr);
        System.out.println("Smallest value in array is: " + arr[smallestValue(arr)]);
    }
    public static int smallestValue(int[] arr){
        int min = arr[0];
        int position = 0;
        for(int i = 1; i < arr.length ; i++){
            if (arr[i] < min){
                min = arr[i];
                position = i;
            }
        }
        return position;
    }

    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}