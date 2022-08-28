package jvm.ClassLoader;

import java.io.*;


/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-05 10:42
 */
public class MyClassLoader extends ClassLoader {

    /**
     * 类加载的名字
     */
    private String name;
    /**
     * 加载类的路径
     */
    private String path;
    /**
     * class 文件的扩展名
     */
    private final String fileType = ".class";

    @Override
    public String toString() {
        return this.name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public MyClassLoader(String name){
        super();
        this.name = name;
    }

    public MyClassLoader(ClassLoader parent,String name){
        //显示指定该类加载器的父 类加载器
        super(parent);
        this.name = name;
    }

    /**
     * 实现自定义的类加载器必须重写findClass方法，否则ClassLoader类中的findClass()方法是抛出了异常
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Class findClass(String name)throws ClassNotFoundException{
        byte[] data = this.loadClassData(name);
        return this.defineClass(name,data,0,data.length);
    }
    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            //com.dream.it---->com\dream\it
            this.name = this.name.replace(".","\\");
            is = new FileInputStream(new File(path + name + fileType));
            int ch;
            while(-1 != (ch = is.read())){
                //将数据写入到字节数组输出流对象中去
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {

//        Object object = new Object();
//        object.
//        MyClassLoader loader1 = new MyClassLoader("loader1");
//        loader1.setPath("d:/myapp/serverlib/");
//        //loader1作为loader2的父 类加载器
//        MyClassLoader loader2 = new MyClassLoader(loader1,"loader2");
//        loader2.setPath("d:/myapp/clientlib");
        //父类加载器为null，表明其父类加载器为根类加载器
        MyClassLoader loader3 = new MyClassLoader(null,"loader3");
        loader3.setPath("d:/myapp/otherlib");

//        test(loader2);
        test(loader3);
    }

    public static void test(ClassLoader cl) throws Exception {
        Class clazz = cl.loadClass("Sample");
        Object object = clazz.newInstance();
    }

}
