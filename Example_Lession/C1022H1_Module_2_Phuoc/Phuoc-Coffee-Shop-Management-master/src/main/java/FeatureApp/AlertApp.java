package FeatureApp;

public  class AlertApp {

    public static void alertApp(String option) {
        String output = "";
        String confirm = " \033[0;1m[\033[1;92mY\033[0;1m] \033[0;32mYes \033[0m- \033[0;1m["+PrintColor.RED+"N\033[0;1m]"+PrintColor.RED+ "No\033[0m\n";
        if (option.equals("Add-Success"))output = PrintColor.GREEN_BACKGROUND+"■ Add successfully!"+PrintColor.RESET;
        if (option.equals("Access-Success"))output = PrintColor.GREEN_BACKGROUND+"■ Access successfully!"+PrintColor.RESET;
        if (option.equals("Update-Success"))output = PrintColor.GREEN_BACKGROUND+"■ Update successfully!"+PrintColor.RESET;
        if (option.equals("Remove-Success")) output = "\033[0;92m■ Product is removed successfully!"+PrintColor.RESET;
        if (option.equals("Student-Remove-Confirm")) output = "■ Are your sure want to remove it?" + confirm;
        System.out.println(output);
    }


}
