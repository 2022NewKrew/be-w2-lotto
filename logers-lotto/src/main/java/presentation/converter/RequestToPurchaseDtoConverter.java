package presentation.converter;

import dto.input.PurchaseDto;
import spark.Request;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RequestToPurchaseDtoConverter implements Converter<Request, PurchaseDto> {
    private static final RequestToPurchaseDtoConverter instance = new RequestToPurchaseDtoConverter();

    private final Converter<String, List<Integer>> stringToNumberConverter;

    private RequestToPurchaseDtoConverter(){
        stringToNumberConverter = StringToNumbersConverter.getInstance();
    }

    public static RequestToPurchaseDtoConverter getInstance(){
        return instance;
    }

    @Override
    public PurchaseDto convert(Request param) {
        int purchasePrice = Integer.parseInt(param.queryParams("inputMoney"));
        List<List<Integer>> numberLists = parseLottoNumberLists(param.queryParams("manualNumber"));
        return new PurchaseDto(purchasePrice, numberLists);
    }

    private List<List<Integer>> parseLottoNumberLists(String numberListsString){
        return Arrays.stream(numberListsString.split("\n"))
                .map(stringToNumberConverter::convert)
                .collect(toList());
    }
}
