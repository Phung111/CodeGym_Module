package orther;

import utils.ValidateUtils;

import java.util.Scanner;

public class Format {
    static Scanner scanner = new Scanner(System.in);

    public static boolean isContinue(String string,String string2) {
        do {
            System.out.println("--Bạn có muốn " + string + "?--");
            System.out.println("[1] Đồng ý");
            System.out.println("[2] Huỷ " + string2);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("--Chọn sai chức năng--");
                    System.out.println("--Nhập lại--");
                    break;
            }
        } while (true);
    }
    public static String inputLong() {
        boolean isLong = true;
        String longNumber;
        do {
            longNumber = scanner.nextLine();
            if (longNumber.isEmpty()){
                longNumber = "";
                break;
            } else {
                isLong = ValidateUtils.isLongNumber(String.valueOf(longNumber));
                if (isLong == false){
                    System.out.println("--Dữ liệu nhập không đúng--");
                    System.out.println("--Nhập lại--");
                }
            }
        } while (isLong == false);
        return longNumber;
    }


}
