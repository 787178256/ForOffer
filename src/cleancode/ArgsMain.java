package cleancode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by kimvra on 2020/4/30
 */
@Slf4j
public class ArgsMain {
    public static void main(String[] args) {
        try {
            log.info("args:{}", Arrays.toString(args));
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String direction = arg.getString('d');
            System.out.println("logging:" + logging);
            System.out.println("port:" + port);
            System.out.println("direction:" + direction);
        } catch (ArgsException e) {

        }
    }
}
