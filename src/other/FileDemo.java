package other;

import java.io.File;

/**
 * Created by kimvra on 2019-06-26
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/Users/kimvra/Desktop/file.txt");
        System.out.println(file.exists());
    }
}
