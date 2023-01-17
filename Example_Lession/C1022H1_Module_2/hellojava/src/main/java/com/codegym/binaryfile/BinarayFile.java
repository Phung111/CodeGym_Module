package com.codegym.binaryfile;

import java.io.*;

public class BinarayFile {
    public static void main(String[] args)  {
            String data = "This is a demo of the flush method";

            try {
                // Creates a FileOutputStream
                FileOutputStream file = new FileOutputStream("./data/flush.txt");

                ObjectInputStream objectInputStream;
                // Creates a BufferedOutputStream
                BufferedOutputStream buffer = new BufferedOutputStream(file);

                // Writes data to the output stream
                buffer.write(data.getBytes());

                // Flushes data to the destination
                buffer.flush();
                System.out.println("Data is flushed to the file.");
//                buffer.close();

        }
        catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeBinary1() {
        try{
            // Ki tu: 5 -> 101
            FileInputStream fileInputStream = new FileInputStream("./data/baigiang.pdf");

            FileOutputStream fileOutputStream = new FileOutputStream("./data/baigiang1.pdf");
            int bRead = -1;


            while ((bRead = fileInputStream.read()) != -1) {
                fileOutputStream.write(bRead);
            }
            fileOutputStream.close();
            fileInputStream.close();
        }
        catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeBinary() {
        int[] arr = {2};
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./data/binaray.txt");
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

            for (int i = 0; i < arr.length; i++) {
                dataOutputStream.writeInt(arr[i]);
            }

            fileOutputStream.close();
            dataOutputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
