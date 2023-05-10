package y2022.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: yst
 * @version: 1.0
 * @date: 2023/1/12 15:13
 * @description: https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/solution/
 */
public class StrReplace {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    public String evaluate(String s, List<List<String>> knowledge) {

        if (s==null || "".equals(s)){
            return s;
        }

        List<String> list = getStr(s);
        if (list.size() == 0) {
            return s;
        }

        Map<String,String> map = covertKnowledge(knowledge);



        for (String str : list) {
            String value = map.get(str);
            s = s.replaceAll(str,value==null?"?":value);
        }

        return s;
    }

    private List<String> getStr(String s) {

        List<String> list = new ArrayList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder() ;
        for (char c : s.toCharArray()) {

            if (LEFT == c){
                flag = true;
            }

            if (flag) {
                sb.append(c);
            }

            if (RIGHT == c) {
                list.add(sb.toString());
                flag = false;
                sb = new StringBuilder();
            }
        }

        return list;
    }

    private Map<String, String> covertKnowledge(List<List<String>> knowledge) {
        if (knowledge==null || knowledge.size() == 0){
            return new HashMap<>();
        }
        return knowledge.stream().collect(Collectors.toMap((item) -> LEFT+item.get(0)+RIGHT, (item) -> item.get(1)));
    }

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        list1.add("name");
        list1.add("bob");
        List list2 = new ArrayList();
        list2.add("age");
        list2.add("two");
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        String evaluate = new StrReplace().evaluate("(name)is(age)yearsold",list);
        System.out.println(evaluate);
    }
}
