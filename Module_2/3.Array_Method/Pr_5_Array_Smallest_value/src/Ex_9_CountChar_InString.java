public class Ex_9_CountChar_InString {
    public static void main(String[] args) {
        String string = "hikigaya";
        char keyword = 'a';
        int count = countCharInString(string, keyword);
        System.out.println(string);
        System.out.println(keyword);
        System.out.println(count);
        System.out.println("---------");
        String position = findIndexContainChar(string, keyword);
        System.out.println("position: " + position);

    }

    public static int countCharInString(String string, char keyword){
        int count = 0;
            for (int i= 0; i < string.length(); i++){
                if (string.charAt(i) == keyword) {
                    count++;
                }
            }
        return count;
    }

    public  static String findIndexContainChar(String string, char keyword){
        String str = "";
        int k = 0;
        for (int i= 0; i < string.length(); i++){
            for (int j = 0; j < string.length(); j++){
                if (string.charAt(j) == keyword) {
                    k = j; //k = 7
                }
            }
            if (string.charAt(i) == keyword) {
                str += i;
                if (i != k){
                    str += ",";
                }
            }
        }
        return str;
    }
}
