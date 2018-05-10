package win.likie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author huahui.wu.
 * Created on 2018/4/2.
 */
public class Employee {

    public static void main(String[] args) throws Exception {
        //new
        Employee employee = new Employee();
        //newInstance
        Employee employee1 = Employee.class.newInstance();
        Class.forName("win.likie.Employee").newInstance();
        //Constructor
        Constructor<Employee> constructor = Employee.class.getConstructor();
        //clone
        Employee employee2 = (Employee) employee.clone();
        //Serialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(employee2);
        out.close();
        //Deserialization
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        Employee employee3 = (Employee) in.readObject();
        in.close();

    }
}
