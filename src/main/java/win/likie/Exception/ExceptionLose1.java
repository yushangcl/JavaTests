package win.likie.Exception;

/**
 * Created by huahui.wu on 2017/5/23.
 */
public class ExceptionLose1 {
	static void f() throws ExceptionB{
		throw new ExceptionB("exception b");
	}

	static void g() throws ExceptionC {
		try {
			f();
		}catch (ExceptionB e) {
			ExceptionC c = new ExceptionC("exception a");
			throw c;
		}
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (ExceptionC e) {
			e.printStackTrace();
		}
	}
}
