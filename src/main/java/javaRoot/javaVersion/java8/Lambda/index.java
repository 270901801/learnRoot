package javaRoot.javaVersion.java8.Lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author hsc
 * @date 2020-05-10 15:46:05
 */
public class index {

    public static  List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

    /**
     * 以前的写法
     */
    public static void test1(){

    }

    /**
     * lambda写法
     */
    public static void test2(){

        //以前的写法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //一般的写法
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        
        //更加简略的
        Collections.sort(names,(String a,String b)-> b.compareTo(a));

        //最简略的
        names.sort((a,b)->b.compareTo(a));

    }

    /**
     * 函数式接口 Functional Interface
     *
     * 不是每个接口都可以缩写成 Lambda 表达式。只有那些函数式接口（Functional Interface）才能缩写成 Lambda 表示式。
     * 函数式接口（Functional Interface）就是只包含<b>一个抽象方法的声明</b>。
     */
    public static void test4(){
        //注意：上面的示例代码，即使去掉 @FunctionalInterface 也是好使的，它仅仅是一种约束而已。
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    /**
     * 内置的函数式接口
     */
    public static void test3(){

        /**
         * Predicate 断言
         *
         * Predicate 是一个可以指定入参类型，并返回 boolean 值的函数式接口。
         * 它内部提供了一些带有默认实现的方法，可以 被用来组合一个复杂的逻辑判断
         * （and, or, negate）：
         */
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        /**
         * Function
         * Function 函数式接口的作用是，我们可以为其提供一个原料，
         * 他给生产一个最终的产品。通过它提供的默认方法，组合,链行处理(compose, andThen)：
         */
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"



        /**
         * 生产者
         *
         * Supplier 与 Function 不同，它不接受入参，直接为我们生产一个指定的结果，有点像生产者模式：
         */
        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();   // new Person


        /**
         * 消费者
         *
         * 对于 Consumer，我们需要提供入参，用来被消费，如下面这段示例代码：
         */
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));


        /**
         * Comparator
         *
         * Comparator 在 Java 8 之前是使用比较普遍的。Java 8 中除了将其升级成了函数式接口，还为它拓展了一些默认方法：
         */
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        comparator.compare(p1, p2);             // > 0
        comparator.reversed().compare(p1, p2);  // < 0

    }

    /**
     * 便捷的引用类的构造器及方法
     *
     * Java 8 中允许你通过 :: 关键字来引用类的方法或构造器。
     * 上面的代码简单的示例了如何引用静态方法，当然，除了静态方法，我们还可以引用普通方法
     */
    public static void test5(){
        //引用静态方法
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123

        //引用普通方法
        Something something = new Something();
        Converter<String, String> converter1 = something::startsWith;
        String converted1 = converter1.convert("Java");
        System.out.println(converted);    // "J"

        // 直接引用 Person 构造器
        //
        // Person::new 这段代码，能够直接引用 Person 类的构造器。
        // 然后 Java 编译器能够根据上下文选中正确的构造器去实现 PersonFactory.create 方法。
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

    }


    public static void main(String[] args) {
        test3();
    }
}

class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

// Person 工厂
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}



@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

