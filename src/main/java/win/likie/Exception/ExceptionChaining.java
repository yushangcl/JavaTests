package win.likie.Exception;

/**
 * Created by huahui.wu on 2017/5/23.
 */
public class ExceptionChaining {

	static void f() throws ExceptionB {
		throw new ExceptionB("exception b");
	}

	static void g() throws ExceptionC {

	}
}
