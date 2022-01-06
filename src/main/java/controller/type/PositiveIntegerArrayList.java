package controller.type;

import java.util.ArrayList;

public class PositiveIntegerArrayList {

    public static ArrayList<Integer> parse(String s, String regex) {
        String[] strings = s.strip().split(regex);
        ArrayList<Integer> integers = new ArrayList<>(strings.length);
        for (String string : strings) {
            integers.add(PositiveInteger.parse(string));
        }
        return integers;
    }

    public static ArrayList<Integer> parse(String s) {
        return parse(s, ",");
    }
}
