# be-w2-lotto
웹 백엔드 2주차 로또 구현

-------


## LottoGame

> 로또를 진행하는 모든 과정을 모아놓은 클래스입니다.

- `.proceed`: 로또게임의 모든 단계를 진행하는 메서드
- `.searchResult`: 모든 로또번호들을 순환하며, 당첨 갯수를 업데이트하는 메서드
- `.intersection`: 당첨 번호와 비교하여 몇 개가 일치하는 지 반환하는 메서드
- `.updateRank`: 일치하는 등수를 `LottoRank`를 활용해 찾고, 해당 등수의 value를 증가시키는 메서드
- `.calculatePrize`: 총 수익률을 계산하는 메서드

<br>

## domain.Input

> 전반적인 입,출력을 상속을 통해 적용한 클래스입니다.

- `Input`
  - `SingleInput`: 단일 입력을 위한 클래스
    - `PriceInput`: 구입금액 입력을 위한 클래스
    - `BonusNumberInput`: 보너스 볼 입력을 위한 클래스
  - `MultipleInput`: 다중 입력을 위한 클래스(정수형)
    - `WinningInput`: 당첨 번호를 입력하기 위한 클래스

<br>

## domain.LottoInput

> Input.java에서 정의한 클래스들을 패키지 밖에서 적용하기 위한 클래스입니다.

- `.prepurchase`: 구매하기 전, 금액 입력을 받고 몇 장을 구매하였는지 반환하는 메서드
- `.postpurchase`: 구매 후, 당첨번호를 입력하고 해당 리스트를 반환하는 메서드
- `.getBonusNumber`
- `.getInputPrice`

<br>

## domain.LottoGenerator

> 각 로또종이를 생성하고, 이를 리스트로 저장하는 클래스입니다.

- `.generateLotto`: **종이 수 만큼** 로또종이를 생성하는 메서드
- `.getLottoPapers`

<br>

## domain.LottoNumber

> 한 장의 로또 종이의 숫자들을 생성하는 클래스입니다.

- `.generateNumbers` : 한 장의 로또종이를 생성하는 메서드
- `.getNumbers`

<br>

## view.ViewLotto

> 로또 게임 과정에서 출력하고자 하는 내용들을 모아놓은 클래스입니다. 각 메서드는 static으로 이루어져 있습니다.

- `.printLotto`: 생성한 로또종이들을 출력하는 메서드입니다.
- `.printResult`: 당첨 통계를 출력하는 메서드입니다.
- `.printPriceRatio`: 수익률을 출력하는 메서드입니다.

<br>

## domain.LottoRank

> 로또 등수 확인을 위해 Map을 활용했었는데, 이를 enum으로 리팩토링하였습니다.
- `resultRank`(등수), `countOfMatch`(일치하는 숫자 수), `winningPrize`(당첨금액)로 구성
- `.valueOf`: 일치하는 숫자 수, 보너스 볼 당첨 여부를 통해 **LottoRank의 모든 값 중** 해당 등수에 맞는 `LottoRank`를 반환
- `.findRank`: 현재 입력받은 `LottoRank`가 입력받은 값과 일치하는지를 확인하고, 결과값을 반환하는 메서드
- `.getResultRank`
- `.getCountOfMatch`
- `.getWinningPrize`

<br>
<br>

--------

## STEP 2 추가 & 수정 사항
- `Map`을 활용하던 데이터를 `enum`으로 변환, `LottoRank` 생성
  - 변환에 따라 데이터를 적용하던 부분 수정
  - `LottoRank`는 `resultRank`, `countOfMatch`, `winningPrize`로 구성
- `LottoGame.updateRank` 추가
  - LottoRank에서 등수를 확인하고, 당첨된 갯수를 업데이트하는 메서드
- `ViewLotto.printRank` 추가
  - 당첨 통계쪽에서, 각 등수를 출력하는 메서드를 분리, Stringbuilder 활용
- `Input -> BonusInput` 추가
  - 보너스 당첨번호를 입력받기 위한 단일입력 클래스 추가
- `LottoPaper` -> `LottoNumber`로 리팩토링
- `LottoGame.calculatePrize` 수정
  - 수익률 공식 변화에 따른 수정

<br>

## 이후 계획

- ~~1단계에서 `Map`으로 받아오던 데이터 `enum`으로 변경~~
- ~~2단계 진행~~
- 예외처리 & 테스트 적용
- 로또 종이를 위한 클래스를 따로 생성하여 적용 예정