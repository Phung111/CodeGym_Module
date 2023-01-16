import java.util.ArrayList;
import java.util.List;

public class LongestString {
    static int[] list = {1,25,45,48,46,98,1,20,53,35,67,84,100};
    public static void main(String[] args) {
       List listTemp = getLongestStringLienTiep(list);
        for (int i = 0; i < listTemp.size(); i++) {
            System.out.printf(listTemp.get(i) + " ");
        }
    }

    public static List getLongestStringLienTiep(int[] list){
        List listTemp = new ArrayList();
        int count = 0;
        for(int k = 0; k < list.length-1;k++){
            for (int i = count; i < list.length-1;i++){
                if(list[i] <= list[i+1]){
                    listTemp.add(list[i]);
                    count++;
                }
            }
        }
        return listTemp;
    }
}
