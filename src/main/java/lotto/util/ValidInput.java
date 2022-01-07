package lotto.util;

import java.util.List;

import static lotto.util.ConstantValue.*;

/**
 * 입력 값의 오류를 판단하는 클래스
 */
public class ValidInput {

    /**
     * 입력값이 기준보다 낮은 경우 예외를 발생시키는 메소드
     * @param standardValue 기준 값
     * @param inputValue 입력 값
     */
    public static void inputUnderValue(int standardValue, int inputValue){
        if(standardValue > inputValue){
            throw new InvalidInputException(
                    String.format("(입력: %d , 최소 :%d) 기준보다 낮아 적절하지 않은 입력입니다.", inputValue, standardValue)
            );
        }
    }

    /**
     * 입력값이 범위 안에 있지 않다면 예외를 발생시키는 메소드
     * @param startValue 범위 내의 가장 작은 값
     * @param endValue 범위 내의 가장 큰 값
     * @param inputValue 입력 값
     */
    public static void wrongRangeValue(int startValue, int endValue , int inputValue){
        if( inputValue < startValue || endValue < inputValue){
            throw new InvalidInputException("범위에 맞지 않는 입력입니다.");
        }
    }

    /**
     * 가능한 로또 범위 밖의 값이 있다면, 예외를 발생시키는 메소드
     * 정렬된 상태로 입력을 받기에, 맨 앞과 맨 뒤만 확인
     * @param lottoNumbers 입력받은 로또 번호들
     */
    public static void wrongLottoNumber(List<Integer> lottoNumbers){
        if(lottoNumbers.get(FIRST_IDX) < LOTTO_START_NUMBER || lottoNumbers.get(LAST_IDX) > LOTTO_LAST_NUMBER){
            throw new InvalidInputException("로또 숫자 범위에 맞지 않는 입력이 있습니다.");
        }
    }

    /**
     * 로또 번호 입력 시 갯수가 맞지 않는 경우 예외를 발생시키는 메소드
     * @param numInputString 입력 받은 숫자들의 문자열 배열
     */
    public static void wrongSize(String[] numInputString){
        if(numInputString.length != SIZE_OF_LOTTO){
            throw new InvalidInputException(
                    String.format("(현재: %d개, 기준: %d개) 번호 입력 갯수가 잘못되었습니다.",numInputString.length, SIZE_OF_LOTTO)
            );
        }
    }

    /**
     * 중복 번호 입력으로 전체 로또 번호의 갯수가 기준보다 작아지는 경우, 예외를 발생시키는 메소드
     * @param numList 로또 번호들로 이루어진 Integer가 들어있는 리스트
     */
    public static void wrongSize(List<Integer> numList){
        if(numList.size() != SIZE_OF_LOTTO){
            throw new InvalidInputException(
                    String.format("(현재: %d개, 기준: %d개) 중복 번호 입력, 번호 갯수가 잘못되었습니다.",numList.size(), SIZE_OF_LOTTO)
            );
        }
    }
}
