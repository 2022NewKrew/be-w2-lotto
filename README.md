# be-w2-lotto
웹 백엔드 2주차 로또 구현

## 기능 요구사항

- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [ ] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.



## 프로그래밍 요구사항

- [ ] indent depth를 2단계에서 1단계로 줄여라.
- [ ] else 를 사용하지 마라.
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - [x] method가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] 배열 대신 ArrayList를 사용한다.
- [ ] enum을 적용해 프로그래밍을 구현한다.



## 구현 사항

- LottoApplication 의 main 메서드에서 애플리케이션이 실행됩니다.
  - LottoApplication 은 LottoMachine 객체를 생성한 후 start() 메소드를 호출합니다.
- LottoMachine
  - LottoMachine 은 생성되면 numberList에 1부터 45까지의 숫자를 담습니다.
  - start() 메소드가 호출되면 다음의 로직을 수행합니다.
    - purchaseAmount 에 구매 금액을 담습니다.
    - 구매 금액으로 구매할 수 있는 만큼 Lotto를 구입하여 lottoList에 담습니다.
    - lottoList를 출력합니다.
    - winningNumberList 에 당첨 번호를 담습니다.
    - lottoList 에 담긴 Lotto들의 당첨여부를 확인합니다. 이때, Enum 클래스 Rank 의 각 등수별 당첨자 수를 업데이트합니다.
    - lotto 의 결과를 출력합니다.
- Lotto
  - numberList에 복권 번호 6개를 담고 있는 클래스입니다.
- Rank
  - 당첨 정보를 담고 있는 클래스입니다.
- InputView
  - 입력을 받는 메소드를 가진 클래스입니다.
- OutputView
  - 출력을 하는 메소드를 가진 클래스입니다.

