package CopyFileText;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public static void main(String[] args) {
        CopyFileText copyFileText = new CopyFileText();
        List<Integer> listInt = copyFileText.readFile("./data/copy.txt");

        writeData(listInt,"./data/paste.txt");
    }

    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }

    public static <T> void writeData(List<T> list, String filePath) {
        try {
            File file = new File(filePath);

            PrintWriter printWriter = new PrintWriter(file);

            for (int i = 0; i < list.size(); i++) {
                printWriter.write(list.get(i).toString());
                if (i != list.size() - 1) {
                    printWriter.write("\n");
                }
            }
            printWriter.close();

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
