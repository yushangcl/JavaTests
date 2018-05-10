package win.likie.String;

/**
 * Created by huahui.wu on 2017/7/28.
 */
public class StringIntern {

    public static void main(String[] args) {
        String s = "";
        System.out.println(s.equals(s.intern()));

    }

}
