package javaRoot.javaVersion.java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author hsc
 * @date 2020-05-10 15:46:15
 *
 * 使用 java.util.Stream 对一个包含一个或多个元素的集合做各种操作。
 * 这些操作可能是 中间操作 亦或是 终端操作。
 * 终端操作会返回一个结果，而中间操作会返回一个 Stream 流。
 * 需要注意的是，你只能对实现了 java.util.Collection 接口的类做流的操作。
 *
 * Map 不支持 Stream 流。
 * Stream 流支持同步执行，也支持并发执行。
 */
public class index {

    private static List<String> stringCollection =
            Arrays.asList("ddd2","aaa2","bbb1","aaa1","bbb3","ccc","bbb2","ddd1");

    /**
     *Filter 过滤
     */
    public static void Filter(){


        //Filter 的入参是一个 Predicate, 上面已经说到，Predicate 是一个断言的中间操作，
        // 它能够帮我们筛选出我们需要的集合元素。
        // 它的返参同样 是一个 Stream 流，我们可以通过 foreach 终端操作，来打印被筛选的元素：
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// "aaa2", "aaa1"
        //foreach 是一个终端操作，它的返参是 void, 我们无法对其再次进行流操作。
    }

    /**
     * Sorted 排序
     *
     * Sorted 同样是一个中间操作，它的返参是一个 Stream 流。
     * 另外，我们可以传入一个 Comparator 用来自定义排序，如果不传，则使用默认的排序规则。
     *
     * 需要注意，sorted 不会对 stringCollection 做出任何改变，stringCollection 还是原有的那些个元素，且顺序不变：
     */
    public static void Sorted(){
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// "aaa1", "aaa2"
    }


    /**
     * Map 转换
     *
     * 中间操作 Map 能够帮助我们将 List 中的每一个元素做功能处理。
     * 例如下面的示例，通过 map 我们将每一个 string 转成大写：
     *
     * 另外，我们还可以做对象之间的转换，业务中比较常用的是将 DO（数据库对象） 转换成 BO（业务对象） 。
     */
    public static void Map(){
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
    }

    /**
     * Match 匹配
     *
     * 顾名思义，match 用来做匹配操作，它的返回值是一个 boolean 类型。
     * 通过 match, 我们可以方便的验证一个 list 中是否存在某个类型的元素。
     */
    public static void Match(){
        // 验证 list 中 string 是否有以 a 开头的, 匹配到第一个，即返回 true
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        // 验证 list 中 string 是否都是以 a 开头的
        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        // 验证 list 中 string 是否都不是以 z 开头的,
        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

    }


    /**
     * Count 计数
     *
     * count 是一个终端操作，它能够统计 stream 流中的元素总数，返回值是 long 类型。
     */
    public static void Count(){
        // 先对 list 中字符串开头为 b 进行过滤，让后统计数量
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3

    }

    /**
     * Reduce
     *
     * Reduce 中文翻译为：减少、缩小。
     * 通过入参的 Function，我们能够将 list 归约成一个值。它的返回类型是 Optional 类型。
     */
    public static void Reduce(){
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
    }


}
