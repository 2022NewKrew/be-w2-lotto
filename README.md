# be-w2-lotto
웹 백엔드 2주차 로또 구현

-------


## LottoGame

> 로또를 진행하는 모든 과정을 모아놓은 클래스입니다.

- `.proceed`: 로또게임의 모든 단계를 진행하는 메서드
- `.searchResult`: 몇 개가 일치하는 지 확인하고, 결과 map에 추가하는 메서드
- `.intersection`: 당첨 번호와 비교하여 몇 개가 일치하는 지 반환하는 메서드
- `.calculatePrize`: 총 수익률을 계산하는 메서드

<br>

## domain.Input

> 전반적인 입,출력을 상속을 통해 적용한 클래스입니다.

- `Input`
  - `SingleInput`: 단일 입력을 위한 클래스
    - `PriceInput`: 구입금액 입력을 위한 클래스
  - `MultipleInput`: 다중 입력을 위한 클래스(정수형)
    - `WinningInput`: 당첨 번호를 입력하기 위한 클래스

<br>

## domain.LottoInput

> Input.java에서 정의한 클래스들을 패키지 밖에서 적용하기 위한 클래스입니다.

- `.prepurchase`: 구매하기 전, 금액 입력을 받고 몇 장을 구매하였는지 반환하는 메서드
- `.postpurchase`: 구매 후, 당첨번호를 입력하고 해당 리스트를 반환하는 메서드
- `.getInputPrice`: 구입 금액을 반환하는 메서드

<br>

## domain.LottoGenerator

> 각 로또종이를 생성하고, 이를 리스트로 저장하는 클래스입니다.

- `.generateLotto`: **종이 수 만큼** 로또종이를 생성하는 메서드
- `.getLottoPapers`: 생성한 로또종이들로 이루어진 리스트를 반환

<br>

## domain.LottoPaper

> 한 장의 로또 종이를 생성하는 클래스입니다.

- `.generatePaper` : 한 장의 로또종이를 생성하는 메서드
- `.getPaper`: 생성한 로또 종이를 반환하는 메서드

<br>

## view.ViewLotto

> 로또 게임 과정에서 출력하고자 하는 내용들을 모아놓은 클래스입니다. 각 메서드는 static으로 이루어져 있습니다.

- `.printLotto`: 생성한 로또종이들을 출력하는 메서드입니다.
- `.printResult`: 당첨 통계를 출력하는 메서드입니다.
- `.printPriceRatio`: 수익률을 출력하는 메서드입니다.


<br>
<br>

--------

## 이후 계획

- 1단계에서 `Map`으로 받아오던 데이터 `enum`으로 변경
- 예외처리
- 로또 종이를 위한 클래스를 따로 생성하여 적용 예정
- 2단계 진행