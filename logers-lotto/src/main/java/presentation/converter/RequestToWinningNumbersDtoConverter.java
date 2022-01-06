package presentation.converter;

import dto.input.WinningNumbersDto;
import spark.Request;

import java.util.List;

public class RequestToWinningNumbersDtoConverter implements Converter<Request, WinningNumbersDto> {
    private static final RequestToWinningNumbersDtoConverter instance = new RequestToWinningNumbersDtoConverter();

    private final Converter<String, List<Integer>> stringToNumbersConverter;

    public static RequestToWinningNumbersDtoConverter getInstance(){
        return instance;
    }

    private RequestToWinningNumbersDtoConverter(){
        stringToNumbersConverter = StringToNumbersConverter.getInstance();
    }

    @Override
    public WinningNumbersDto convert(Request param) {
        List<Integer> winningNumbers = stringToNumbersConverter.convert(param.queryParams("winningNumbers"));
        int bonusNumber = Integer.parseInt(param.queryParams("bonusNumber"));
        return new WinningNumbersDto(winningNumbers, bonusNumber);
    }
}
