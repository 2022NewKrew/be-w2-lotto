package com.kakao.lotto.view;

import com.kakao.lotto.model.ConstLottoConfig;
import com.kakao.lotto.model.LottoNumber;

public class PreLottoResultInput {
    private final LottoNumber lottoNumber;
    private final int bonus;

    private PreLottoResultInput(Builder builder){
        lottoNumber = builder.preLottoNumber;
        bonus = builder.bonus;
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public int getBonus() {
        return bonus;
    }

    /**
     * author    : brody.moon
     * version   : 1.0
     * User Input 을 생성하는 inner Builder 클래스입니다.
     */
    public static class Builder {

        private LottoNumber preLottoNumber;
        private int bonus;


        /**
         * 전체 입력이 사용자 입력을 처리해서 받기 때문에 빈 생성자만 생성하였습니다.
         */
        public Builder() {

        }

        /**
         * 이전 로또 정보를 입력받는 메서드입니다.
         *
         * @return builder 클래스 자신
         */
        public Builder setPreLottoNumber() {
            this.preLottoNumber = ChangeVaildInput.inputIntArrayStringManufactor(ConstStringSpace.INPUT_PREVIOUS_NUMBERS);

            return this;
        }

        /**
         * 보너스 번호 정보를 입력받는 메서드입니다.
         * @return  builder 클래스 자신
         */
        public Builder setBonusNumber(){
            this.bonus = ChangeVaildInput.inputIntStringManufactor(ConstStringSpace.INPUT_BONUS_NUMBER,number -> number,
                    number -> preLottoNumber.getAll().contains(number) || (number <= 0 || number > ConstLottoConfig.LOTTO_NUMBER_RANGE));

            return this;
        }

        /**
         * Builder 클래스를 바탕으로 UserLottoInput 객체를 생성합니다.
         *
         * @return UserLottoInput 객체
         */
        public PreLottoResultInput build() {
            return new PreLottoResultInput(this);
        }
    }
}
