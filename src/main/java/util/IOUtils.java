package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class IOUtils {
	public static final Scanner SCANNER = new Scanner(System.in);

	public static List<Integer> stringTokenizerToIntegerList(StringTokenizer st) {
		List<Integer> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		return list;
	}
}
