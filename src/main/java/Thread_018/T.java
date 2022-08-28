package Thread_018;



/**
 * @program: TestJava
 * @description: 不要以字符串常量作为锁定对象，程序中 m1 和 m2 锁定的是同一个对象
 * @author: wang chi
 * @create: 2020-05-21 18:15
 */
public class T {

    String s1 = "hello";
    String s2 = "hello";

    void m1 (){
        synchronized (s1){

        }
    }

    void m2 (){
        synchronized (s2){

        }
    }
}
