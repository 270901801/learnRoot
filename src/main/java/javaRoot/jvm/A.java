package javaRoot.jvm;

/**
 * @author hsc
 * @date 2020-06-16 21:52:52
 */
class B {
            private int a = 1234;

            static long C = 1111;

            public long test(long num) {
                long ret = this.a + num + C;
                return ret;
            }
        }

public class A {
            private B b = new B();

            public static void main(String[] args) {
                A a = new A();
                long num = 4321 ;

                long ret = a.b.test(num);

                System.out.println(ret);
            }
        }

