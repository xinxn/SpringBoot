package com.xin.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class LambdaTest {

    public static void main(String[] args) {

     LambdaTest.localDateTest1();
    }

    public static void OptionalTest1() {
        Optional<ForkJoin> op = Optional.of(new ForkJoin());
        System.out.println(op.map( (e) -> e).get());
    }

    public static void OptionalTest() {
        Optional<ForkJoin> op = Optional.of(new ForkJoin());
        System.out.println(op.get());

        // NPE
        Optional<ForkJoin> op2 = Optional.of(null);
        System.out.println(op2);

    }

    public static void parallelStreamTest() {
        // 并行流 多个线程执行
        List<Integer> numbers = Arrays.asList(1, 8, 3, 6, 5, 4, 7, 2, 9);
        numbers.parallelStream()
                .forEach(System.out::print);
        System.out.println("=========================");
        numbers.parallelStream()
                .forEachOrdered(System.out::print);

        //
        System.out.println("=========================");
        numbers.stream()
                .sequential()
                .forEach(System.out::print);

    }

    public static void localDateTest2() {

        //获取当前日期,只含年月日 固定格式 yyyy-MM-dd    2018-05-04
        LocalDate today = LocalDate.now();
        System.out.println("today：" + today);
        // 根据年月日取日期，5月就是5，
        LocalDate oldDate = LocalDate.of(2019, 5, 1);
        System.out.println("oldDate：" + oldDate);
        // 根据字符串取：默认格式yyyy-MM-dd，02不能写成2
        LocalDate yesteday = LocalDate.parse("2019-05-03");
        System.out.println("yesteday：" + yesteday);
        // 如果不是闰年 传入29号也会报错
        LocalDate.parse("2019-02-28");
    }

    public static void localDateTest1(){
        // DateTimeFormatter: 格式化时间/日期
        // 自定义格式
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String strDate1 = ldt.format(formatter);
        String strDate = formatter.format(ldt);
        System.out.println(strDate);
        System.out.println(strDate1);

        // 使用api提供的格式
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt2 = LocalDateTime.now();
        String strDate3 = dtf.format(ldt2);
        System.out.println(strDate3);

        // 解析字符串to时间
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(df);
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        LocalDateTime ldt4 = LocalDateTime.parse("2017-09-28 17:07:05",df);
        System.out.println("LocalDateTime转成String类型的时间："+localTime);
        System.out.println("String类型的时间转成LocalDateTime："+ldt4);

    }

    public static void localTest() {
        LocalTime nowTime = LocalTime.now();
        System.out.println("今天的时间：" + nowTime);//今天的时间：15:33:56.749
        int hour = nowTime.getHour();//时
        System.out.println("hour：" + hour);
        int minute = nowTime.getMinute();//分
        System.out.println("minute：" + minute);
        int second = nowTime.getSecond();//秒
        System.out.println("second：" + second);
        int nano = nowTime.getNano();//纳秒
        System.out.println("nano：" + nano);
    }

    public static void laTest3(){
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("1","张飒");
        hashmap.put("2","张三");
        hashmap.put("3","张三丰");
        hashmap.put("4","李四");
        hashmap.put("5","王五");
        hashmap.put("6","王二小");
        hashmap.put("7","王小二");


        Set<Map.Entry<String, String>> keyValues = hashmap.entrySet();
        for (Map.Entry<String, String> entry : keyValues) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }


        //使用keySet得到所有的键值
        Set<String> ketSet = hashmap.keySet();
        Iterator<String> iterator = ketSet.iterator(); // 得到迭代器

        //使用Lambda方式输出
        System.out.println("lambda方式输出:");
        iterator.forEachRemaining(element -> {
            String value = hashmap.get(element);
            System.out.println(element + "->" + value);
        });


    }


    public static void laTest2(){
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("Tome");
        list.add("王小二");
        list.add("西门庆");
        System.out.println(list.indexOf("Tome"));
        list.stream().filter(p -> "Tome".equals(p)).forEach(index -> {
            System.out.println(list.indexOf(index));
        });;

    }

    public static void laTest() {
        //匿名内部类
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = cpt.compare(3, 4);

        TreeSet<Integer> treeSet = new TreeSet<>(cpt);
        treeSet.add(compare);
        for (Integer string:treeSet){
            System.out.println(string);
        }



        System.out.println("=========================");

        //使用lambda表达式
        Comparator<Integer> cpt2 = (x,y) -> Integer.compare(x,y);
        int compare1 = cpt2.compare(5, 5);
        TreeSet<Integer> set2 = new TreeSet<>(cpt2);

        System.out.println(compare1);
    }
}
