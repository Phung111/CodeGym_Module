public class Ex_2_AddElementToArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        printArray(arr);
        int[] arrNew = addElementToArray(2,10, arr);
        System.out.println("--------");
        printArray(arrNew);
//        printArray(arr);
    }
    public static int[] addElementToArray(int index, int value, int[] arr) {
        int[] arrNew = new int[arr.length + 1];
        for (int i = 0; i < index; i++) {
            arrNew[i] = arr[i];
        }
        arrNew[index] = value;
        for (int i = index + 1; i < arrNew.length; i++) {
            arrNew[i] = arr[i-1];
        }
        return arrNew;
    }
    public static void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
