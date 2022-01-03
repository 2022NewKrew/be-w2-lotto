package com.kakao.io;

import com.kakao.data.io.LottoOutputData;
import com.kakao.model.Lotto;
import com.kakao.model.Lottos;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

class LottoOutput {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void printString (String str) {
        try {
            bw.write(str);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printResult (Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();

        StringBuilder sb = new StringBuilder();
        printResultComment(sb, lottoList.size());
        printLottoData(sb, lottoList);

        try {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 출력문자열 생성
    private static void printResultComment(StringBuilder sb, int numberOfLottos) {
        String format = String.format(LottoOutputData.RESULT_COMMENT_OF_PURCHASE, numberOfLottos);
        sb.append(format);
    }
    private static void printLottoData(StringBuilder sb, List<Lotto> lottoList) {
        for(Lotto lotto: lottoList) {
            sb.append(lotto);
            sb.append("\n");
        }
    }
}
