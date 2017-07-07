package win.likie.Exception;

/**
 * Created by huahui.wu on 2017/5/23.
 */
public class ExceptionChaining1 {
	static void f() throws ExceptionB {
		throw new ExceptionB("exception b");
	}
	static void g() throws ExceptionC {
		try {
			f();
		} catch (ExceptionB e) {
			throw new ExceptionC(e.getMessage());
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
