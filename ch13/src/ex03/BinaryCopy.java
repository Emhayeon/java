package ex03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BinaryCopy {

        public static void main(String[] args) {
                File src = new File("G:/Temp/eclipse.zip");
                File dest = new File("G:/Temp/eclipse2.zip");
                try {
                        FileInputStream input = new FileInputStream(src);
                        FileOutputStream output = new FileOutputStream(dest);
                        long starTime = System.currentTimeMillis();
                        int i = 0;
                        while (true) {
                                int data = input.read();
                                if (data == -1) {
                                        break;
                                }
                                output.write(data);
                                System.out.println(++i);
                        }
                        long endTime = System.currentTimeMillis();
                        long elapsedTime = endTime - starTime;
                        System.out.println("파일복사완료" + (elapsedTime / 1000.0) + "초 걸림");
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

}
