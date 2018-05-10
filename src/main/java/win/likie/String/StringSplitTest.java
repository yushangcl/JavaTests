package win.likie.String;

/**
 * split()遇到的坑
 *
 * @author huahui.wu. (;￢＿￢)
 * Created on 2018/4/25.
 */
public class StringSplitTest {

    public static void main(String[] args) {
        String str = "1.1.23";
        String[] strs = str.split(".");
        System.out.println(strs.length); //0

        // .和\都需要转义  \\. \\\
        strs = str.split("\\.");
        System.out.println(strs.length);//3

        //最后一个""会直接去掉
        String str1 = "1,2,3,";
        strs = str1.split(",");
        System.out.println(strs.length);//3
    }
}
