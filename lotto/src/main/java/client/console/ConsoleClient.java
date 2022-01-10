package client.console;

import static utils.ErrorMessage.INVALID_INPUT_NUMBER_NEGATIVE;
import static utils.ErrorMessage.INVALID_OVER_BUY_LIMIT;
import static utils.ErrorMessage.format;

import client.LottoClient;
import domain.lotto.Lotto;
import domain.lotto.LottoNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.StringUtils;

public class ConsoleClient implements LottoClient {

  private final BufferedReader reader;

  public ConsoleClient() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  @Override
  public void run() throws IOException {

    System.out.println("구입금액을 입력해 주세요.");
    int purchaseAmount = getUnsignedIntegerFromReader();

    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    int availableQuantity = getMaxPurchaseQuantity(purchaseAmount);
    int manualBuyQuantity = getManualBuyQuantity(availableQuantity);

    System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    List<Lotto> lottoList = getManualLottoList(manualBuyQuantity);

  }


  private int getMaxPurchaseQuantity(int amount) {
    return amount / Lotto.PRICE;
  }


  private int getManualBuyQuantity(int buyLimitation) throws IOException {
    int manualBuyQuantity = getUnsignedIntegerFromReader();
    if (manualBuyQuantity > buyLimitation) {
      throw new IllegalArgumentException(
          format(INVALID_OVER_BUY_LIMIT, buyLimitation, manualBuyQuantity));
    }
    return manualBuyQuantity;
  }


  private List<Lotto> getManualLottoList(int quantity) throws IOException {
    List<Lotto> lottoList = new ArrayList<>(quantity);
    for (int i = 0; i < quantity; i++) {
      Lotto lotto = Lotto.of(getValidLottoNumbers());
      lottoList.add(lotto);
    }
    return lottoList;
  }


  private List<LottoNumber> getValidLottoNumbers() throws IOException {
    List<LottoNumber> lottoList = StringUtils.integersSplitByDelimiter(reader.readLine())
        .stream()
        .map(LottoNumber::of)
        .collect(Collectors.toList());
    Lotto.validCheck(lottoList);
    return lottoList;
  }


  private int getUnsignedIntegerFromReader() throws IOException {
    String input = reader.readLine().strip();
    int parsedNumber;
    try {
      parsedNumber = Integer.parseUnsignedInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException(
          format(INVALID_INPUT_NUMBER_NEGATIVE, input));
    }
    return parsedNumber;
  }

}
