package other;


import java.util.ArrayList;

/**
 * Created by kimvra on 2019-03-20
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String s1 = new String("EA");
        String s2 = "EA";
        System.out.println(s1 == s2);// false
        s1.intern();
        System.out.println(s1 == s2);// false
        s1 = s1.intern();
        System.out.println(s1 == s2);// false
        String s3 = new String("Spo") + new String("rts");
        s3.intern();
        String s4 = "Sports";
        System.out.println(s3 == s4);
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
