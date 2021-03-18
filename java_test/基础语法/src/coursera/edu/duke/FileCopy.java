package coursera.edu.duke;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//拷贝文件
public class FileCopy {

    public static void main(String[] args) throws IOException {
        //创建输入输出流
        FileInputStream fileInputStream = new FileInputStream("基础语法/resource/img.png");
        FileOutputStream fileOutputStream = new FileOutputStream("基础语法/resource/result.png");
        //判断输入流是否完全读入

        while (fileInputStream.available() > 0) {
//            int data = fileInputStream.read();
//            fileOutputStream.write(data);
            //读入输出
            fileOutputStream.write(fileInputStream.read());
        }
        //关闭流
        fileInputStream.close();
        fileOutputStream.close();


    }

}
