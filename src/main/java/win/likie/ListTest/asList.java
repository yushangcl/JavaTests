package win.likie.ListTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huahui.wu on 2017/5/23.
 */
public class asList {

	public static void asListTest() {
		ArrayList list = new ArrayList();

		for (int i =0; i < 10; i++) {
			list.add(i);
		}

		List list1 = Arrays.asList(list);

		//Arrays.asList 转换后的集合不能进行修改操作
		list1.remove(0);
	}

	public static void main(String[] args) {
		asListTest();
	}
}
