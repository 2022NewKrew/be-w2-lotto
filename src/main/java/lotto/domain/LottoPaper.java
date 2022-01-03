package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoPaper {
    private static final List<Integer> allNumbers =
            IntStream.rangeClosed(1, 45)
                    .boxed()
                    .collect(Collectors.toList());
    private static final int SIZE_OF_NUMBERS = 6;
    private List<Integer> paper;


    public LottoPaper(){
        generatePaper();
    }


    private void generatePaper(){
        Collections.shuffle(allNumbers);
        paper =  new ArrayList<>(allNumbers.subList(0, SIZE_OF_NUMBERS));
        Collections.sort(paper);
    }

    public List<Integer> getPaper() {return paper;}
}
