package carrot.ez.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IOUtil {

    private static final Scanner sc = new Scanner(System.in);

    public long inputLong(String msg) {
        System.out.println(msg);
        return Long.parseLong(sc.nextLine());
    }

    public List<Integer> inputSplitInt(String msg, String regex) {
        System.out.println(msg);
        return inputSplitInt(regex);
    }

    public List<Integer> inputSplitInt(String regex) {
        return Arrays.stream(sc.nextLine().split(regex))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputInt(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }
}
