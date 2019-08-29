package other;


import java.util.*;

/**
 * Created by kimvra on 2019-03-20
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(0 ^ 5);
//        int[] nums = new int[]{1};
//        String s = "123";
//        String s1 = "1233";
//        System.out.println(s1.compareTo(s));
//        System.out.println(s.substring(1));
//        s.length();
//        System.out.println(s.substring(0, 1));
//        System.out.println(nums.length);
//        List<String> list = new ArrayList<>();
//        list.size();
//        list.toArray().toString();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.length();
//        stringBuilder.append('a');


//        String[] strings = {"one", "two", "three"};
//        List<String> stringList = Arrays.asList(strings);
//        stringList.set(0, "oneList");
//        System.out.println(stringList);
//        //stringList.add("four");
//        stringList.remove(2);
//        stringList.clear();
//        Boolean flag = true;
//        Boolean f = true;
//        System.out.println(flag.equals(f));
//        System.out.println(f == flag);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        System.out.println(list.retainAll(list1));
        System.out.println(list);
        System.out.println(list1);
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(1));
    }

}
