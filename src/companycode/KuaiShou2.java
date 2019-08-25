package companycode;

/**
 * Created by kimvra on 2019-08-25
 */
import java.util.HashMap;
import java.util.Scanner;


public class KuaiShou2 {
    static boolean canBeOne(int a) {
        HashMap<Long, Boolean> hm = new HashMap<>();
        long m = a;
        long res = 0;
        while (true) {
            while (m != 0) {
                long temp = m % 10;
                res += temp * temp;
                m = m / 10;
            }
            if(res == 1)
                return true;
            if(!hm.getOrDefault(m,false)){
                hm.put(res,true);
                m = res;
                res = 0;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++){
            int m = sc.nextInt();
            if(canBeOne(m) == true){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }

}