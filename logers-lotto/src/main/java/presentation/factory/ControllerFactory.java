package presentation.factory;

import presentation.controller.LottoController;
import presentation.converter.Converter;
import presentation.converter.StringToNumberListsConverter;
import presentation.converter.StringToNumbersConverter;
import service.LottoService;

import java.util.List;

public class ControllerFactory {
    private static LottoController lottoController = null;

    private ControllerFactory(){}

    public static LottoController getLottoController(){
        if(lottoController == null){
            lottoController = createLottoController();
        }

        return lottoController;
    }

    private static LottoController createLottoController(){
        final Converter<String, List<List<Integer>>> stringToNumberListsConverter
                = StringToNumberListsConverter.getInstance();

        final Converter<String, List<Integer>> stringToNumbersConverter
                = StringToNumbersConverter.getInstance();

        return new LottoController(8080, new LottoService(),
                stringToNumberListsConverter, stringToNumbersConverter);
    }
}
