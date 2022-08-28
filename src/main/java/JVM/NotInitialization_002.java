package JVM;



/**
 * @program: Real_Madrid_2020
 * @description: 并没有触发类 com.guazi.JVM.SubClass_001 的初始化阶段。但是这段代码里面触发了另一个名为“[Lcom.guazi.JVM.SubClass_001”的类的初始化阶段
 * 对于用户代码来说，这并不是一个合法的类型名称，它是一个由虚拟机自动生成的、直接继承于java.lang.Object的子类，创建动作由字节码指令newarray触发,这个类代表了一个元素类型为com.guazi.JVM.SubClass_001的一维数组，
 * @author: wang chi
 * @create: 2020-06-03 13:31
 */
public class NotInitialization_002 {

    public static void main(String[] args) {
        SubClass_001 [] subClass_001s = new SubClass_001[10];
    }
}
