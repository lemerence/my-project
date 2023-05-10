package my.jvm.volatileSample;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/2/9 10:32
 * @description:
 */
public class Test {


    //    @Data
    @AllArgsConstructor
    public static class Person {
        private int age;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }

    public static void main(String[] args) {
//        Person p1 = new Person(1, "y");
//        Person p2 = new Person(1, "y");
//
//        System.out.println("hash:"+p1.hashCode()+","+p2.hashCode());
//        System.out.println(p1.hashCode()==p2.hashCode());
//        System.out.println(p1.equals(p2));
//
//        String s1="Ma";
//        String s2="NB";
//        System.out.println(s1.hashCode()==s2.hashCode());  //true
//        System.out.println(s1.equals(s2));  //false
//
//        System.out.println(Math.round(-1.5));
//
//        Integer method = method();
//        System.out.println(method);
//
//
//        String str1="i";
//        String str2=new String("i");
//        System.out.println(str1==str2);


//        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
//        linkedHashSet.add("1");
//        linkedHashSet.addAll(List.of("2","3","3"));
//        System.out.println(linkedHashSet);

//
//        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put("1","1");
//        linkedHashMap.put("2","1");
//        linkedHashMap.put("2","1");
//        System.out.println(linkedHashMap);


        int i = -1;
        System.out.println("初始数据： " + i);
        System.out.println(String.format("初始数据对应的二进制字符串：%s ,size: %d " , Integer.toBinaryString(i),Integer.toBinaryString(i).length()));
        i <<= 10;
        System.out.println("左移 10 位后的数据 " + i);
        System.out.println("左移 10 位后的数据对应的二进制字符 " + Integer.toBinaryString(i));


    }

    /**
     * HashSet
     */
    private static Map<Integer, Object> map = new HashMap<>();
    private static final Object PRESENT = new Object();

    public static boolean addAll(Collection<Integer> c) {
        boolean modified = false;
        for (Integer e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    public static boolean add(Integer i) {
        Object put = map.put(i, PRESENT);
        return put ==null;
    }


}


