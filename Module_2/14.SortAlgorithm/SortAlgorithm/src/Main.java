public class Main {
    static int[] list = {2,9,5,4,8,1};
    public static void main(String[] args) {
//        bubbleSort(list);
//        selectSort(list);
        insertionSort(list);

        showList(list);
    }

    public static void insertionSort(int[] list){
        for(int i = 0; i <list.length;i++){
            int e = list[i];
            int j;
            for(j = i-1; j>=0 && list[j] > e ; j--){
                list[j+1] = list[j];
            }
            list[j+1] = e;
        }
    }

    public static void selectSort(int[] list){
        for(int i = 0; i <list.length;i++){
            int min = list[i];
            int indexMin = i;
            for(int j = i; j< list.length;j++){
                if(min > list[j]){
                    min = list[j];
                    indexMin = j;
                }
            }
            list[indexMin] = list[i];
            list[i] = min;
        }
    }
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;
        for (int i = 1; i < list.length && needNextPass; i++ ){
            needNextPass = false;
            for(int j = 0; j < list.length-i;j++){
                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    public static void showList(int[] list){
        for (int i = 0; i< list.length; i++){
            System.out.printf(Main.list[i] + " ");
        }
    }
}