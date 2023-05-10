package my.test;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/31 14:06
 * @description:
 */
public class Test {




    public static void main(String[] args) {
        InterfaceClass interfaceClass = new A();
        InterfaceClass.method1();
    }
}

class A implements InterfaceClass{

    @Override
    public void method() {

    }

    public A() {
    }
}
