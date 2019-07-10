package other;

/**
 * Created by kimvra on 2019-07-10
 */
public class Bucket {
    private int tokens;

    private int speed = 1;

    private Long now = System.currentTimeMillis();

    private int size = 100;

    public boolean getToken() {
        tokens += (System.currentTimeMillis() - now) * speed;
        if (tokens > size) {
            tokens = size;
        }
        now = System.currentTimeMillis();
        if (tokens > 0) {
            tokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        Bucket bucket = new Bucket();
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
                Thread.sleep(500);
            }
            System.out.println("i==" + i + ", tokenNum==" + bucket.tokens + ", result==" + bucket.getToken());
        }
    }
}
