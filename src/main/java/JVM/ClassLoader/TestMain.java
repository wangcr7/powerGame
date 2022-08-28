package JVM.ClassLoader;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-08 23:03
 */
//类A在这里只是为了提供主方法，我们不用把问题搞太复杂了。此处不考虑类A的加载问题
class TestMain{
    public static void main(String[] args) {
//        System.out.println("类A的主方法执行");
//        System.out.println("先看第1点");
//        One one1;
//        System.out.println("已经定义了类One的空引用，但由于类One没有被加载，所以上一行没有‘类One被加载了’的字样");
//        System.out.println("下面要通过实例化类One来触发类One的加载了：");
//        new One();
//        System.out.println("第1点被验证完毕");
//        System.out.println("###############我是快乐的分割线##############");
//        System.out.println();

//        System.out.println("再看第2点");
//        System.out.println("下面要通过实例化类TwoFirst来触发类TwoFirst的加载了：");
//        new TwoFirst();
//        System.out.println("或者通过调用类TwoSecond的类方法来触发类TwoSecond的加载了：");
//        TwoSecond.two();
//        System.out.println("第2点被验证完毕");
//        System.out.println("###############我是快乐的分割线##############");
//        System.out.println();
//
//        System.out.println("再看第3点");
//        System.out.println("下面要通过实例化类ThreeSon来触发类Three的加载了：");
//        new ThreeSon();
//        System.out.println("以上结果可以看出实例化类ThreeSon触发了类Three的加载，且Three先加载，ThreeSon后加载");
//        System.out.println("第3点被验证完毕");
//        System.out.println("###############我是快乐的分割线##############");
//        System.out.println();
//
//        System.out.println("再看第4点");
//        System.out.println("下面要通过实例化类FourFirstSon来触发类FourFirst的加载了：");
//        new FourFirstSon();
//        System.out.println("以上结果可以看出实例化类FourFirstSon触发了类FourFirst的加载，且FourFirst先加载，FourFirstSon后加载");
//        System.out.println("或者通过调用类FourSecond的类方法来触发类FourSecond的加载了：");
//        FourSecond.four();
//        System.out.println("第4点被验证完毕");
//        System.out.println("###############我是快乐的分割线##############");
//        System.out.println();
//
        System.out.println("再看第5点");
        System.out.println("下面要通过实例化类FiveSon来触发接口Five的加载了：");
//        new FiveSon();
        Five five;
        System.out.println("以上结果可以看出实例化类FiveSon触发了接口Five的加载，且接口Five先加载，FiveSon后加载");
        System.out.println("第5点被验证完毕");
        System.out.println("###############我是快乐的分割线##############");
    }
}


//类One就是第1点所说的不含静态方法的非抽象类，注意不要把静态方法和静态代码块搞混淆了。
class One{
    //	静态代码块会随着类的加载而执行，所以可以反映所在类的加载情况
    static {
        System.out.println("类One被加载了");
    }

    void one() {
        System.out.println("类One的非静态成员方法执行");
    }
}


//类TwoFirst和TwoSecond就是第2点所说的含静态方法的非抽象类，注意不要把静态方法和静态代码块搞混淆了。
class TwoFirst{
    //	静态代码块会随着类的加载而执行，所以可以反映所在类的加载情况
    static {
        System.out.println("类TwoFirst被加载了");
    }

    static void two() {
        System.out.println("类TwoFirst的类方法执行");
    }
}
class TwoSecond{
    //	静态代码块会随着类的加载而执行，所以可以反映所在类的加载情况
    static {
        System.out.println("类TwoSecond被加载了");
    }

    static void two() {
        System.out.println("类TwoSecond的类方法执行");
    }
}


//类Three就是第3点所说的不含静态方法的抽象类，ThreeSon是它的非抽象子类
abstract class Three{
    static {
        System.out.println("抽象类Three加载");
    }

    void three() {
        System.out.println("抽象类Three类方法执行");
    };

    public Three() {
        System.out.println("抽象类Three的构造器");
    }
}
class ThreeSon extends Three{
    static {
        System.out.println("ThreeSon被加载了");
    }

    public ThreeSon() {
        System.out.println("Three的构造器");
    }
}


//类FourFirst、FourSecond就是第4点所说的含静态方法的抽象类，类FourFirstSon是类FourFirst的非抽象子类
abstract class FourFirst{
    static {
        System.out.println("抽象类FourFirst加载");
    }

    static void four() {
        System.out.println("抽象类FourFirst类方法执行");
    };
}
class FourFirstSon extends FourFirst{
    static {
        System.out.println("FourFirstSon被加载了");
    }
}
abstract class FourSecond{
    static {
        System.out.println("抽象类FourSecond加载");
    }

    static void four() {
        System.out.println("抽象类FourSecond类方法执行");
    };
}


//Five是第5点提到的接口，FiveSon是它的非抽象子类
interface Five {
    String string = "侧面印证接口的加载";
}
class FiveSon implements Five{
    static {
        System.out.println(string);
        System.out.println("FiveSon被加载了");
    }
}

