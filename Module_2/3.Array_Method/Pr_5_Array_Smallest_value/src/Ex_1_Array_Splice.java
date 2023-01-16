public class Ex_1_Array_Splice {
    public static void main(String[] args) {
        int[] arr =  {5, 6, 7, 1, 3};
        int number = 4;
        printArray(arr);
        alertValueInArray(checkValueInArray(arr, number), number);

    }

    public static void spiceArrayIndex(int index, int[] arr) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static boolean checkValueInArray(int[] arr, int number){
        boolean check = false;
        for (int i = 0; i < arr.length;i++){
            if (arr[i] == number) {
                check = true;
                break;
            }
        }

        return check;
    }
    public static void alertValueInArray(boolean check, int number){
        if (check){
            System.out.println(number + " have in array");
        } else {
            System.out.println(number + " dont have in array");
        }
    }
}
