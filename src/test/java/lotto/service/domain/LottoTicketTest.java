package lotto.service.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {


    private final LottoNumbers lottoNumbers = new LottoNumbers(List.of(new Integer[]{1, 2, 3, 4, 5, 6}));
    private final LottoTicket ticket = new LottoTicket(lottoNumbers);


    @Test
    void setPrizeDetailsTest(){

        //given
        List<Integer> winningNumber = List.of(new Integer[]{1,2,3,4,5,7});
        int bonusNumber = 6;

        //when
        ticket.setPrizeDetails(winningNumber, bonusNumber);

        //then
        assertEquals(LottoPrizeDetails.SECOND_PRIZE, ticket.getPrizeDetails());

    }



}