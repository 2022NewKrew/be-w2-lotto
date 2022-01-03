package com.kakao.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LottoInput {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Integer inputMoney() {
        Integer money = null; // 기본값은 null 이므로, 에러가 발생하면 null 반환
        try {
            money = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally { // 반드시 값을 반환
            return money;
        }
    }
}
