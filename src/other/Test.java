package other;


import java.util.ArrayList;

/**
 * Created by kimvra on 2019-03-20
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l1.add("1");
        l2.add(1);
        System.out.println(l1.get(0).getClass());
        System.out.println(l2.get(0).getClass());
        System.out.println(l1.getClass() == l2.getClass());
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
