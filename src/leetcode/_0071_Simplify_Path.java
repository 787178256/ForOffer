package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by kimvra on 2019-07-26
 */
public class _0071_Simplify_Path {
    private static String simplifyPath(String path) {
        Queue<String> stack = new LinkedList<>();
        String[] strings = path.split("/");
        for (String s : strings) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    ((LinkedList<String>) stack).removeLast();
                }
            } else if (!"".equals(s) && !".".equals(s)){
                stack.add(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(((LinkedList<String>) stack).get(0));
            ((LinkedList<String>) stack).removeFirst();
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/home";
        String path1 = "/../";
        String path2 = "/home//foo/";
        String path3 = "/a/./b/../../c/";
        String path4 = "/a/../../b/../c//.//";
        List<String> list = Arrays.asList(path, path1, path2, path3, path4);
        list.stream().forEach(s -> System.out.println(Arrays.toString(s.split("/"))));
        System.out.println(simplifyPath(path));
        System.out.println(simplifyPath(path1));
        System.out.println(simplifyPath(path2));
        System.out.println(simplifyPath(path3));
        System.out.println(simplifyPath(path4));
    }

    @Test
    public void test() {
        String path = "/home";
        String path1 = "/../";
        String path2 = "/home//foo/";
        String path3 = "/a/./b/../../c/";
        String path4 = "/a/../../b/../c//.//";
        //Assert.assertEquals("/home", simplifyPath(path));
        Assert.assertEquals("/", simplifyPath(path1));
        Assert.assertEquals("/home//foo/", simplifyPath(path2));
        Assert.assertEquals("/c", simplifyPath(path3));
        Assert.assertEquals("/c", simplifyPath(path4));
    }
}
