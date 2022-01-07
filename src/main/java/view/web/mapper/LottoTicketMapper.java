package view.web.mapper;

import domain.LottoTicket;
import domain.lottonumber.BasicNumber;
import domain.lottonumber.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketMapper {

    public static LottoTicket from(String manualNumber) {
        List<LottoNumber> lottoNumbers = Arrays.stream(manualNumber.split(","))
                .map(Integer::parseInt)
                .map(BasicNumber::new)
                .collect(Collectors.toUnmodifiableList());

        return new LottoTicket(lottoNumbers);
    }
}
