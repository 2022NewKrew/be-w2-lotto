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
    - `ManualInput`: 수동으로 입력할 로또의 갯수를 입력하기 위한 클래스
  - `MultipleInput`: 다중 입력을 위한 클래스(정수형)
    - `.getIntegers`: 여러 정수의 입력값을 받기 위한 메서드
    - `WinningInput`: 당첨 번호를 입력하기 위한 클래스
    - `ManualNumberInput`: 입력받은 갯수만큼 수동 번호 로또를 입력하기 위한 클래스
      - `.convertToList`: 입력받은 수동 로또들을 리스트에 추가

<br>

## domain.LottoInput

> Input.java에서 정의한 클래스들을 패키지 밖에서 적용하기 위한 클래스입니다.

- `.prepurchase`: 구매하기 전, 금액 입력을 받고 몇 장을 구매하였는지 반환하는 메서드
- `.postpurchase`: 구매 후, 당첨번호를 입력하고 해당 리스트를 반환하는 메서드
- `.manualPurchase`: 수동 번호 입력을 하고 싶은 갯수를 반환하는 메서드
- `.getBonusNumber`
- `.getInputPrice`
- `.getManualNumbers`

<br>

## domain.LottoGenerator

> 각 로또종이를 생성하고, 이를 리스트로 저장하는 클래스입니다.

- `.generateLotto`: **갯수 만큼** 로또 번호를 생성하는 메서드
- `.manualGenerate`: 입력받은 수 만큼 수동 입력 로또를 생성하여 추가하는 메서드
- `.autoGenerate`: 수동 입력 후 남은 갯수만큼 자동입력하는 메서드
- `.getLottoPapers`

<br>

## domain.LottoNumber

> 한 장의 로또 종이의 숫자들을 생성하는 클래스입니다.

- 생성자
  - argument 없이 생성하는 경우, 자동 생성
  - argument 받아 생성하는 경우, 수동 생성
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

## domain.LottoPaper

> 클래스 간 데이터 이동을 하는 과정에서 전부 LottoPaper를 받도록 하나의 객체로 합쳤습니다.

- 멤버 변수
  - `inputPrice`: 구매 금액
  - `numOfNumbers`: 번호 한 줄의 총 갯수
  - `lottoNumbers`: 번호 한 줄로 이루어진 객체 `LottoNumber` 들이 들어있는 리스트
  - `.add`: 로또 숫자들 리스트에 `LottoNumber`를 추가하는 메서드

<br>
<br>

--------

## STEP 3 추가 & 수정 사항

- `LottoPaper` 생성
  - 데이터를 주고 받는 과정에서, `LottoPaper`라는 클래스의 객체를 주고 받도록 전반적인 코드를 변화시켰습니다.
- `Input` 코드 추가 & 변경
  - 수동 입력을 위한 `ManualInput`, `ManualNumberInput` 생성
  - `SingleInput` 과 하위 클래스 변경
    - 전반적으로 중복되는 코드가 있어, `SingleInput`에서 생성자를 활용하고 출력문은 하위 클래스에서 적용하는 방식으로 변경하였습니다.
- `LottoGenerate.generateLotto` 변경
  - 수동 입력을 받는 과정을 위한 `.manualGenerate`과 자동 입력을 위한 `.autoGenerate`으로 분리하여 구현하였습니다.
- `LottoNumber` 생성자 추가
  - 수동 번호 입력을 받는 경우, 해당 값을 바로 저장하는 형태를 추가하였습니다.
- `LottoGame.calculatePrize` 자료형 변경
  - 1등을 하는 경우, 입력 값이 너무 커서 수익률이 음수로 나타나는 경우를 자료형을 바꿔 수정하였습니다.

<br>

## 이후 계획

- ~~1단계에서 `Map`으로 받아오던 데이터 `enum`으로 변경~~
- ~~2단계 진행~~
- ~~로또 종이를 위한 클래스를 따로 생성하여 적용 예정~~
- 3단계 진행
- 예외처리 & 테스트 적용