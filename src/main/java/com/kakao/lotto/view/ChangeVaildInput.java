package com.kakao.lotto.view;

import com.kakao.lotto.model.ConstLottoConfig;
import com.kakao.lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

/**
 * author    : brody.moon
 * version   : 1.1
 * 사용자 입력을 원하는 형태로 가공하고, 잘못된 입력을 새로 받는 클래스입니다.
 * 모든 멤버들을 static 으로 선언하였습니다.
 */
public class ChangeVaildInput {
    /**
     * 스캐너를 멤버 변수로 두어 input 을 받습니다.
     * 모든 입력 프로세스가 끝났을 때 close 로 닫을 수 있게 하였습니다.
     */
    public static final Scanner sc = new Scanner(System.in);

    /**
     * 정수형 입력 처리 메서드입니다.
     * 로또 구매 금액을 로또 갯수로 바꾸어 반환하는 기능과 유저 입력 갯수를 반환하는 기능을 구분하기 위해 함수형 파라메터를 사용하였습니다.
     *
     * @param printString 출력할 문자열
     * @param operator    여러 입력에 대해 다른 기능을 수행할 함수형 파라메터
     * @return 유효한 정수값
     */
    public static int inputIntStringManufactor(String printString, IntUnaryOperator operator) {
        int validInput = -1;

        do {
            System.out.println(printString);

            validInput = readInt();
        } while (validInput < 0);

        return operator.applyAsInt(validInput);
    }

    /**
     * 정수를 입력 받습니다.
     * 유효한 입력이 아닐 경우 -1을 반환합니다.
     *
     * @return 입력한 정수값 ( 유효한 범위가 아니거나 문자열인 경우 -1 반환)
     */
    private static int readInt() {
        int tempInput = -1;

        try {
            tempInput = sc.nextInt();
        } catch (Exception e) {
            sc.nextLine();
        }

        return tempInput;
    }

    /**
     * 사용자 입력 로또 번호 입력을 처리하는 메서드입니다.
     * 사용자 입력을 유효한 입력이 될 때 까지 반복합니다.
     *
     * @return 유효한 로또 번호
     */
    public static LottoNumber inputIntArrayStringManufactor() {
        LottoNumber tempLottoNumber;

        do {
            System.out.println(ConstStringSpace.INPUT_CUSTOMLOTTOS_NUMBER);

            tempLottoNumber = createLottoStream();
        } while (tempLottoNumber.size() != ConstLottoConfig.LOTTO_PICK_NUMBER);
        return tempLottoNumber;
    }

    /**
     * 사용자 입력을 받아 int[] 로 가공해줍니다.
     *
     * @return 유효한 입력만 int[] 로 가공해서 반환
     */
    private static LottoNumber createLottoStream() {
        return new LottoNumber(Arrays.stream(sc.nextLine().split(ConstStringSpace.STRING_SEPERATOR))
                .filter(tempString -> tempString.length() != 0 && !ConstStringSpace.STRING_SEPERATOR.equals(tempString))
                .map(String::trim)
                .filter(ChangeVaildInput::isLottoDigit)
                .distinct()
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList()));
    }

    /**
     * 가공 전의 문자열을 int로 형변환 되는지, 형변환 후 로또 숫자 범위에 해당하는지 확인합니다.
     *
     * @param string 입력을 split 으로 나눈 서브문자열
     * @return 로또 번호로 사용할 수 있는지 없는지 반환
     */
    private static boolean isLottoDigit(String string) {
        try {
            int tempInt = Integer.parseInt(string);
            return isLottoRange(tempInt);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 현재 정수값이 로또 번호로 사용할 수 있는지 확인합니다.
     *
     * @param number 정수값
     * @return 정수 범위가 로또 범위인지 아닌지 반환
     */
    private static boolean isLottoRange(int number) {
        if (number > 0 && number < ConstLottoConfig.LOTTO_NUMBER_RANGE + 1) {
            return true;
        }

        return false;
    }

    /**
     * 입력 버퍼를 비우는 메서드입니다.
     */
    public static void bufferClear() {
        sc.nextLine();
    }

    /**
     * 사용자 입력이 종료 되었을 때 Scanner 객체를 close 해주는 함수입니다.
     */
    public static void close() {
        sc.close();
    }

}
