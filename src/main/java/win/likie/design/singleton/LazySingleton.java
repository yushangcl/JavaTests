package win.likie.design.singleton;

/**
 * 单例模式(懒汉模式) -- 内存模型之重排序
 * Created by huahui.wu on 2017/7/6.
 */
public class LazySingleton {

	private static LazySingleton lazySingleton;

	private LazySingleton() {

	}

	/**
	 * 是否 Lazy 初始化：是
	 * 是否多线程安全：否
	 * 实现难度：易
	 * 描述：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
	 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
	 *
	 * @return
	 */
	public static LazySingleton getInstance1() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	/**
	 * 是否 Lazy 初始化：是
	 * 是否多线程安全：是
	 * 实现难度：易
	 * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
	 * 优点：第一次调用才初始化，避免内存浪费。
	 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
	 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
	 *
	 * @return
	 */
	public static synchronized LazySingleton getInstance2() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	/**
	 * 如果检查第一个singleton不为null,则不需要执行下面的加锁动作，极大提高了程序的性能；
	 * 如果第一个singleton为null,即使有多个线程同一时间判断，但是由于synchronized的存在，只会有一个线程能够创建对象；
	 * 当第一个获取锁的线程创建完成后singleton对象后，其他的在第二次判断singleton一定不会为null，则直接返回已经创建好的singleton对象；
	 *
	 * @return
	 */
	public static LazySingleton getInstance3() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}


	//使用 volatile 关键字修饰singleton1 防止编译器重排序
	private static volatile LazySingleton lazySingleton1;

	/**
	 * 双检锁/双重校验锁（DCL，即 double-checked locking）
	 *
	 * JDK 版本：JDK1.5 起
	 * 是否 Lazy 初始化：是
	 * 是否多线程安全：是
	 * 实现难度：较复杂
	 * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
	 * getInstance() 的性能对应用程序很关键。
	 * @return
	 */
	public static LazySingleton getInstance4() {
		if (lazySingleton1 == null) {
			synchronized(LazySingleton.class) {
				if (lazySingleton1 == null) {
					lazySingleton1 = new LazySingleton();
				}
			}
		}
		return lazySingleton1;
	}

}
