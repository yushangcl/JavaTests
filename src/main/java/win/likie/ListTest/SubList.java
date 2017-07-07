package win.likie.ListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huahui.wu on 2017/5/23.
 */
public class SubList {

	public static void subListTest() {
		ArrayList list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		System.out.println(list);

		List subList = list.subList(1, 5);

		System.out.println(subList);
		System.out.println(list);

		for (int j = 0; j < 3; j++) {
			subList.add(j);
		}

//		List list1 = (List) subList.remove(1);


		System.out.println(subList);
	}

	public static void main(String[] args) {
		subListTest();
	}
}
