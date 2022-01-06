package domain.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 유저가 구매한 로또들의 집합. 수동입력 추가
 *
 * @author leo.jung
 * @since 1.1
 */
public class LottoWallet implements Iterable<Lotto> {

  private final List<Lotto> lottoHolder;

  private LottoWallet() {
    this.lottoHolder = new ArrayList<>();
  }


  public static LottoWallet createEmpty() {
    return new LottoWallet();
  }


  public void addAll(List<Lotto> lottoList) {
    lottoHolder.addAll(lottoList);
  }


  public void addRandomGenerated(int randomGenerateQuantity) {
    if (randomGenerateQuantity < 0) {
      return;
    }
    lottoHolder.addAll(generateLottoList(randomGenerateQuantity));
  }


  public int size() {
    return lottoHolder.size();
  }


  public int manualGeneratedSize() {
    return (int) lottoHolder.stream()
        .filter(Lotto::isManualGenerated)
        .count();
  }


  public int randomGeneratedSize() {
    return (int) lottoHolder.stream()
        .filter(Lotto::isRandomGenerated)
        .count();
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder('\n'
        + "수동으로 " + manualGeneratedSize() + "장, "
        + "자동으로 " + randomGeneratedSize() + "개를 구매했습니다." + '\n'
    );
    lottoHolder.forEach(lotto -> sb.append(lotto).append('\n'));
    sb.append('\n');
    return sb.toString();
  }


  private List<Lotto> generateLottoList(int randomGenerateQuantity) {
    return Stream.generate(Lotto::ofRandom)
        .limit(randomGenerateQuantity)
        .collect(Collectors.toList());
  }


  @Override
  public Iterator<Lotto> iterator() {
    return lottoHolder.iterator();
  }


  @Override
  public void forEach(Consumer<? super Lotto> action) {
    lottoHolder.forEach(action);
  }

}
