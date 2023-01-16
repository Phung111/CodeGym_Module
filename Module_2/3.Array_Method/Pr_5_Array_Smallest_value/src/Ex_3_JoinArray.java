public class Ex_3_JoinArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        printArray(arr1);
        System.out.println("--------");
        printArray(arr2);
        int[] arrNew = joinArray(arr1,arr2);
        System.out.println("--------");
        printArray(arrNew);
//        printArray(arr);
    }
    public static int[] joinArray(int[] arr1,int[] arr2) {
        int[] arrNew = new int[arr1.length + arr2.length];
        for (int i = 0; i< arr1.length ; i++){
            arrNew[i] = arr1[i];
        }
        int index = arr1.length;
        for (int i = 0; i< arr2.length ; i++){
            arrNew[index] = arr2[i];
            index++;
        }
        return arrNew;

    }
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

