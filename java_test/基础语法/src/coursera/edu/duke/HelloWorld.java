package coursera.edu.duke;


import edu.duke.FileResource;

public class HelloWorld {
    public static void runHello() {
        FileResource res = new FileResource("基础语法/resource/hello_unicode.txt");
        //获取相对路径 右键文件名- Copy Relative Path
        for (String line : res.lines()) { //res.lines().for
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        runHello();
    }

}
