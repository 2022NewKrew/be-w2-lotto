# be-w2-lotto
# 웹 백엔드 2주차 로또 구현

## 로또 1단계 구현
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
```java
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
- 배열 대신 ArrayList를 사용한다.

### 구현 내용
- LottoMachine 클래스
    - 사용자에게 보여지는 로직을 처리하는 부분, 입출력을 담당하고 Lotto 인스턴스의 메서드 호출
- Lotto 클래스
    - 복권 가격, 당첨금 등의 민감한 정보를 담고 있고 복권 번호를 생성하는 등의 핵심 로직을 클래스
- Lottery 클래스
    - 생성된 개별 복권에 해당하는 클래스
    - 당첨 번호와 일치하는 숫자의 수를 세는 메서드를 통해 당첨 여부 확인 가능

## 로또 2단계 구현
### 기능 요구사항
- 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항
- enum을 적용해 프로그래밍을 구현한다.

### 구현 내용
- enum 적용
    - 일치하는 숫자 개수에 따른 당첨금 정보 포함
    - 일치하는 숫자 개수와 보너스 숫자를 입력 시 등수 리턴
- LottoMachine -> LottoController 이름 변경
- Lottery -> LottoTicket 이름 변경
- LottoController의 입출력 관련 부분 LottoView 로 이전
- LottoController가 너무 거대해져서 로또 당첨 여부를 확인하는 로직을 TicketReader 클래스로 이전
- 입력 값들에 대한 예외 처리