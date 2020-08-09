package javaRoot.javaVersion.java8.Other;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author hsc
 * @date 2020-05-10 15:49:11
 */
public class index {

    public static void test1(){
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }


    /**
     * Optional
     *
     *可以将 Optional 看做是包装对象（可能是 null, 也有可能非 null）的容器。
     * 设计它的目的是为了防止空指针异常（NullPointerException），要知道在 Java 编程中，
     * 空指针异常可是臭名昭著的。
     *
     * 当你定义了 一个方法，这个方法返回的对象可能是空，也有可能非空的时候，
     * 你就可以考虑用 Optional 来包装它，这也是在 Java 8 被推荐使用的做法。
     */
    public static void test2(){
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
    }
}
