package win.likie.design.singleton;

/**
 * 单例模式（饿汉）
 * Created by huahui.wu on 2017/7/6.
 */
public class EagerSingleton {

	//在类加载时就完成了初始化，所以类加载较慢，但获取对象的速度快
	private  static EagerSingleton singleton1 = new EagerSingleton(); //静态私有成员，已初始化

	private EagerSingleton() {

	}

	/**
	 * 是否 Lazy 初始化：否
	 * 是否多线程安全：是
	 * 实现难度：易
	 * 描述：这种方式比较常用，但容易产生垃圾对象。
	 * 优点：没有加锁，执行效率会提高。
	 * 缺点：类加载时就初始化，浪费内存。
	 * 它基于 classloder 机制避免了多线程的同步问题，不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
	 * 在单例模式中大多数都是调用 getInstance 方法， 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
	 * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
	 * @return
	 */
	public static EagerSingleton getInstance1() {
		return singleton1;
	}

	//---------------------------------------------------

	/**
	 * 静态方式
	 */
	private static EagerSingleton singleton2 = null;

	static {
		singleton2 = new EagerSingleton();
	}

	public static EagerSingleton getInstance2() {
		return singleton2;
	}

	//--------------------------------------------------



	/**
	 * 登记式/静态内部类
	 *
	 * 是否 Lazy 初始化：是
	 * 是否多线程安全：是
	 * 实现难度：一般
	 * 描述：这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
	 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
	 * 这种方式同样利用了 classloder 机制来保证初始化 instance 时只有一个线程，它跟第 3 种方式不同的是：第 3 种方式只要 Singleton 类被装载了，
	 * 那么 instance 就会被实例化（没有达到 lazy loading 效果），而这种方式是 Singleton 类被装载了，instance 不一定被初始化。
	 * 因为 SingletonHolder 类没有被主动使用，只有显示通过调用 getInstance 方法时，才会显示装载 SingletonHolder 类，从而实例化 instance。
	 * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，
	 * 因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。
	 * 这个时候，这种方式相比第 3 种方式就显得很合理。
	 * @return
	 */
	private static class SingletonHolder{
		private static final EagerSingleton SINGLETON = new EagerSingleton();
	}

	public static final EagerSingleton getInstance3() {
		return SingletonHolder.SINGLETON;
	}


}
