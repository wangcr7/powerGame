package JVM;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @program: Real_Madrid_2020
 * @description:  Class.forName(String className)使用装载当前类的类装载器来装载制定的类，
 *              因为class.forName(String name)方法内部调用了Class.forName(className,true,this.getClass().getClassLoader())方法
 *              classLoader.loadClass(StringclassName,boolean resolve);需要手动制定装载器的实例
 * @author: wang chi
 * @create: 2020-06-04 20:55
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
//        Launcher


//        Driver

//        DriverManager
        String url = "jdbc:mysql://localhost:3306/testdb";
        Connection conn = DriverManager.getConnection(url, "root", "root");

        ClassLoader myLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
//                System.out.println("a");
                return super.findClass(name);
            }

            //            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                try {
//                    String fileName = name.substring(name.lastIndexOf(".") + 1)+".class";
//                    InputStream is = getClass().getResourceAsStream(fileName);
//                    if (is == null) {
//                        return super.loadClass(name);
//                    }
//                    byte[] b = new byte[is.available()];
//                    is.read(b);
//                    return defineClass(name, b, 0, b.length);
//                } catch (IOException e) {
//                    throw new ClassNotFoundException(name);
//                }
//            }

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        };

        Object obj = myLoader.loadClass("JVM.ClassLoaderTest").newInstance();
//        Object obj = Class.forName("JVM.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println("shen--->"+obj.getClass().getClassLoader());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
