package other;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimvra on 2019-03-20
 */
public class Test {
    public static void main(String[] args) throws Exception {
    }

    private static int func() {
        try{
            System.out.println("try中的语句");
            return 0;
        }catch(Exception e){
            System.out.println("catch中的语句");
            return 0;
        }finally{
            System.out.println("finally中的语句");
        }
    }

}
