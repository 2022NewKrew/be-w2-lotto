package domain.lotto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또들의 집합
 *
 * @author leo.jung
 * @since 1.1
 */
public class LottoList implements Iterable<Lotto> {

  private final List<Lotto> lottoHolder;

  private LottoList() {
    this.lottoHolder = new ArrayList<>();
  }


  private LottoList(List<Lotto> lottoHolder) {
    this.lottoHolder = lottoHolder;
  }


  public static LottoList createEmpty() {
    return new LottoList();
  }


  public static LottoList of(List<Lotto> lottoHolder) {
    return new LottoList(lottoHolder);
  }


  public void add(Lotto lotto) {
    lottoHolder.add(lotto);
  }


  public void addAll(LottoList lottoList) {
    lottoHolder.addAll(lottoList.lottoHolder);
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


  private List<Lotto> generateLottoList(int randomGenerateQuantity) {
    return Stream.generate(Lotto::ofRandom)
        .limit(randomGenerateQuantity)
        .collect(Collectors.toList());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    lottoHolder.forEach(lotto -> sb.append(lotto).append('\n'));
    return sb.toString();
  }


  public Stream<Lotto> stream() {
    return lottoHolder.stream();
  }


  @Override
  public Iterator<Lotto> iterator() {
    return lottoHolder.iterator();
  }


  @Override
  public void forEach(Consumer<? super Lotto> action) {
    lottoHolder.forEach(action);
  }


  public List<Lotto> getLottoHolder() {
    return lottoHolder;
  }

}
