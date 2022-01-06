# 2주차 로또
## 구현 내용
### 프로젝트 구조
```
controller
  ⎩ LottoController
domain
  ├ LottoNumber
  ├ LottoNumbers
  ├ LottoRank
  ├ LottoResultCalculator
  ├ LottoTicket
  ├ RandomLottoTicket
  ⎩ WinningCondition
expection
  ⎩ InvalidInputFormatException
view
  ├ InputView
  ⎩ OutputView
Main    
```

### controller
#### `LottoController`
- 사용자로 부터 입력을 받은 데이터를 전달하거나 가공한 데이터를 출력 화면에 전달한다.

|메서드|설명|
|---|---|
|`start()`| 어플리케이션 로직을 실행한다.|

<br>

### domain
#### `LottoNumber`
- 로또 번호
- 로또 번호와 관련된 유효성 검사

#### `LottoNumbers`
- 로또 티켓에 들어가는 로또 번호 목록 (로또 번호 6개)
- 로또 번호가 중복된 것이 있는지, 로또 번호는 6개가 맞는지 유효성 검사

|메서드| 설명                                |
|---|-----------------------------------|
|`createByNumbers()`| 숫자 리스트를 전달하면 LottoNumbers를 반환한다.  |
|`contains()`| 로또 번호가 포함되어 있는지 확인한다.             |
|`countMatchNumberOfLottoNumbers()`| LottoNumbers를 전달하면 일치하는 개수를 반환한다. |

<br>

#### `LottoRank`
- 로또 등수

|메서드|설명|
|---|---|
|`parseResult()`|로또 등수 결과로 변환한다.|

<br>

#### `LottoResultCalculator`
- 로또 통계 계산기

|메서드|설명|
|---|---|
|`getLottoResultCounts()`|로또 티켓 리스트를 전달받아 로또 등수 개수를 반환한다.|
|`calculateEarningRate()`|수익률을 계산한다.|

<br>

#### `LottoTicket`
- 로또 티켓

|메서드| 설명                                  |
|---|-------------------------------------|
|`containLottoNumber()`| 로또 번호를 포함하고 있는지 확인한다.               |
|`countMatchNumberOfLottoNumbers()`| 전달하는 로또 번호 목록와 비교해서 같은 숫자 개수를 반환한다. |

<br>

#### `RandomLottoTicket`
- 랜덤으로 생성되는 로또 티켓
- `LottoTicket`을 상속받는다.

<br>

#### `WinningCondition`
- 당첨 로또 번호 목록과 보너스 로또 번호를 가지고 있다.

|메서드| 설명                                         |
|---|--------------------------------------------|
|`countMatchNumberOfLottoTicket()`| 로또 티켓을 전달하면 당첨 로또 번호와 일치하는 로또 넘버 개수를 반환한다. |
|`containsBonusLottoNumber()`| 보너스 넘버를 포함하고 있는지 확인한다.                     |

<br>

### exception
#### `InvalidInputException`
- 잘못된 형식을 입력하였을 때 발생시키는 에러

### view
#### `InputView`
- 입력에 대한 처리를 담당 (입력에 대한 유효성 검사 포함)

|메서드|설명|
|---|---|
|`inputAmountForPurchase()`|구입 금액을 입력받아 반환한다.|
|`inputBonusNumber()`|보너스 숫자를 입력받아 반환한다.|
|`inputWinningNumbers()`|당첨 번호를 입력받아 반환한다.|
|`inputNumOfLottoTicketsToInput()`|수동으로 구매할 로또 티켓의 개수를 입력 받아 반환한다.|
|`inputNumbersForPurchaseLottoTickets()`|수동으로 구매할 번호를 입력 받아 반환한다.|

<br>

#### `OutputView`
- 출력에 대한 처리를 담당

|메서드|설명|
|---|---|
|`printLotteries()`|수동으로 생성한 로또 티켓과 랜덤으로 생성한 로또 티켓을 출력한다.|
|`printErrorMessage()`|전달 받은 에러에 대한 메시지를 출력한다.|
|`printResult()`|전달 받은 통계와 수익률을 출력한다.|

## 1단계
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

### 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- **배열 대신 ArrayList를 사용한다.**

### 힌트
- 로또 자동 생성은 `Collecions.shuffle()` 메소드를 활용한다.
- `Collections.sort()` 메소드를 활용해 정렬 가능하다.
- ArrayList의 `contains()` 메서드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## 2단계
### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.

```
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

### 프로그래밍 요구사항
- enum을 적용해 프로그래밍을 구현한다.

### 힌트
- Lotto 클래스를 사용자가 구매한 Lotto와 로또 기계에 의해 추첨한 Lotto를 구분해 생성한다.
- 로또 기계가 추첨한 Lotto는 WinningLotto와 같은 방식

## 3단계
### 기능 요구사항
- 현재 로또 생성시는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구사항
- 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다.
- 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.

### 실행 결과
```
구입금액을 입력해 주세요.
14000

수동으로 구매할 로또 수를 입력해 주세요.
3

수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```