package ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BinaryFastCopy {

        public static void main(String[] args) {
                File src = new File("G:/Temp/eclipse.zip");
                File dest = new File("G:/Temp/eclipse2.zip");
                try {
                        FileInputStream input = new FileInputStream(src);
                        FileOutputStream output = new FileOutputStream(dest);
                        BufferedInputStream bInput = new BufferedInputStream(input);
                        BufferedOutputStream bOutput = new BufferedOutputStream(output);
                        
                        long starTime = System.currentTimeMillis();
                        int i = 0;
                        while (true) {
                                //int data = input.read();
                                int data = bInput.read();
                                if (data == -1) {
                                        break;
                                }
                                bOutput.write(data);
                                //System.out.println(++i);
                        }
                        long endTime = System.currentTimeMillis();
                        long elapsedTime = endTime - starTime;
                        System.out.println("파일 복사 완료 : " + (elapsedTime / 1000.0) + "초 걸림");
                        bInput.close();
                        bOutput.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

}
