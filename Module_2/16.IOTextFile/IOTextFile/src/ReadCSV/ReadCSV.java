package ReadCSV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadCSV {
    public static void main(String[] args) {
        ReadCSV readCSV = new ReadCSV();
        List<String> listString = readCSV.readFileCSV(".data/csv.csv");
        //D:\Code_Gym\Module_2\16.IOTextFile\IOTextFile\data
        for (String string: listString ){
            String[] words = string.split(",|,'|','|'");
            for(String word : words){
                System.out.printf(word + " ");
            }
            System.out.println("\n");
        }
    }

    public <T> List<T> readFileCSV(String filePath){
        List<T> strings = new ArrayList<>();
        try{
            File file = new File(filePath);

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                strings.add((T) line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return strings;
    }

}
