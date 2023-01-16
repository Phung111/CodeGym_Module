public class a {
    public static void main(String[] args) {
        int[][] arr2 = new int[][]{
                {5, 6, 1},
                {3, 6, 9},
                {9, 7, 7}
        };
        int sum = 0;

        for  (int i = 0; i < arr2.length ; i++){
            for (int j = 0; j < arr2.length; j++){
                sum+= arr2[0][j];
                sum+= arr2[arr2.length-1][j];
                sum+= arr2[i][0];
            }
        }
        System.out.println(sum);
    }
}
