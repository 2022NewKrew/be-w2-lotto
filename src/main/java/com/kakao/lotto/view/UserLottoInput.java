package com.kakao.lotto.view;

import com.kakao.lotto.model.ConstLottoConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author    : brody.moon
 * version   : 1.0
 * User Input 을 받는 클래스입니다.
 * 실제 Input 을 받는 부분은 ChangeVaildInput 클래스에서 처리하고 정상적인 가공된 입력을 가지고 있는 클래스입니다.
 * 저번에 static 메서드로 초기화를 해보아서 이번엔 builder pattern 을 사용해 보았습니다.
 */
public class UserLottoInput {
    /**
     * 사용자 입력 로또들을 저장하는 변수와 자동으로 생성한 로또의 갯수, 전체 로또의 갯수를 멤버로 가지고 있습니다.
     * 필요 없어 보이는 멤버의 경우 printResult 에서 사용하기 위해 저장해 두었습니다.
     */
    private final List<int[]> createdCustomLotto;
    private final int numberOfAutoNumber;
    private final int numberOfAllNumber;

    private UserLottoInput(Builder builder) {
        this.createdCustomLotto = builder.createdCustomLotto;
        this.numberOfAllNumber = builder.numberOfAllNumber;
        this.numberOfAutoNumber = builder.numberOfAllNumber - builder.numberOfCustomNumber;
    }

    public List<int[]> getCreatedCustomLotto() {
        return createdCustomLotto;
    }

    public int getNumberOfAutoNumber() {
        return numberOfAutoNumber;
    }

    public int getNumberOfAllNumber() {
        return numberOfAllNumber;
    }

    /**
     * author    : brody.moon
     * version   : 1.0
     * User Input 을 생성하는 inner Builder 클래스입니다.
     */
    public static class Builder {
        private List<int[]> createdCustomLotto;
        private int numberOfCustomNumber;
        private int numberOfAllNumber;


        /**
         * 전체 입력이 사용자 입력을 처리해서 받기 때문에 빈 생성자만 생성하였습니다.
         */
        public Builder() {

        }

        /**
         * 총 생성할 로또 갯수를 입력받아 저장하는 메서드입니다.
         *
         * @return builder 클래스 자신
         */
        public Builder setNumberOfAllNumber() {
            this.numberOfAllNumber = ChangeVaildInput.inputIntStringManufactor(ConstStringSpace.HOW_MUCH_IS_IT, number -> number / ConstLottoConfig.LOTTO_PRICE);
            ChangeVaildInput.bufferClear();

            return this;
        }

        /**
         * 사용자 입력을 받을 로또 갯수를 입력받아 저장하는 메서드입니다.
         * 사용자 입력이 총 갯수를 넘어설 경우를 대비해 둘 중 작은값으로 저장 되게 만들었습니다.
         *
         * @return builder 클래스 자신
         */
        public Builder setNumberOfCustomNumber() {
            this.numberOfCustomNumber = ChangeVaildInput.inputIntStringManufactor(ConstStringSpace.INPUT_NUMBER_OF_CUSTOMLOTTOS, number -> number);
            this.numberOfCustomNumber = Math.min(numberOfAllNumber, numberOfCustomNumber);

            ChangeVaildInput.bufferClear();
            return this;
        }

        /**
         * 사용자 입력으로 유효한 로또들을 입력받은 갯수 만큼 저장하는 메서드입니다.
         *
         * @return builder 클래스 자신
         */
        public Builder setCustomLottos() {
            this.createdCustomLotto = new ArrayList<>();
            if (this.numberOfCustomNumber != 0)
                createdCustomLotto = Stream.generate(ChangeVaildInput::inputIntArrayStringManufactor)
                        .limit(this.numberOfCustomNumber)
                        .collect(Collectors.toList());

            ChangeVaildInput.close();

            return this;
        }

        /**
         * Builder 클래스를 바탕으로 UserLottoInput 객체를 생성합니다.
         *
         * @return UserLottoInput 객체
         */
        public UserLottoInput build() {
            return new UserLottoInput(this);
        }
    }
}
