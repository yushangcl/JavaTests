package win.likie.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author huahui.wu.
 * Created on 2018/4/9.
 */
public class CollectionTest {

    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();

        List<Integer> num = new ArrayList<>();
        num.add(3);
        num.add(-1);
        num.add(-5);
        num.add(10);
        collectionTest.search(num);
        collectionTest.unmodifiable(num);
    }


    private void search(List<Integer> num) {

        System.out.println(num);
        System.out.println(Collections.max(num));
        System.out.println(num);
        System.out.println(Collections.min(num));
        //将元素替换成新的元素
        Collections.replaceAll(num, -1, -7);
        System.out.println(num);
        //统计元素出现的次数
        System.out.println(Collections.frequency(num, 3));
        //对List 排序
        Collections.sort(num);
        System.out.println(num);
        //对List进行二分查找，返回索引，注意List必须是有序的
        System.out.println(Collections.binarySearch(num, -5));
    }

    private void unmodifiable(List<Integer> num) {
        //返回指定collection 的不可编辑视图
        Collection unmodifiable = Collections.unmodifiableCollection(num);
        //该方法将会抛出 UnsupportedOperationException
        unmodifiable.add(1);
    }


}
