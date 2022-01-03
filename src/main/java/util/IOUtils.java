package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IOUtils {
	public static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

	public static List<Integer> stringTokenizerToIntegerList(StringTokenizer st) {
		List<Integer> list = new ArrayList<>();

		while (st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		return list;
	}
}
