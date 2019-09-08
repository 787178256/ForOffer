package other;


/**
 * Created by kimvra on 2019-03-20
 */
public class Test {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(52 & 35);
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
