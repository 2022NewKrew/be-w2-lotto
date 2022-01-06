import dto.input.PurchaseDto;
import dto.input.WinningNumbersDto;
import presentation.controller.LottoController;
import presentation.converter.Converter;
import presentation.converter.RequestToPurchaseDtoConverter;
import presentation.converter.RequestToWinningNumbersDtoConverter;
import service.LottoService;
import spark.Request;

public class LottoDriver {
    public static void main(String[] args) {
        final Converter<Request, PurchaseDto> purchaseDtoConverter
                = RequestToPurchaseDtoConverter.getInstance();
        final Converter<Request, WinningNumbersDto> winningNumbersDtoConverter
                = RequestToWinningNumbersDtoConverter.getInstance();

        new LottoController(8080, new LottoService(),
                purchaseDtoConverter, winningNumbersDtoConverter).run();
    }
}
