package JVM;

/**
 * @program: Real_Madrid_2020
 * @description:
 * @author: wang chi
 * @create: 2020-06-04 20:35
 */
public class Parent {

    static {
        System.out.println("Parent Static...");
    }

    public Parent(){
        System.out.println("Parent init...");
    }
}
