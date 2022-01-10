# be-w2-lotto
웹 백엔드 2주차 로또 구현

## Step1
### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.
### 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
    - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## Step2
2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.

- 에러처리 필요
- 코드 분리 필요

## Step3

### Check List (Step1 review 반영)
-[X] Lotto객체 에서 숫자 생성 메소드 빼내어 따로 Lotto 객체를 만들어주는 Factory 객체 구현
  - Lotto Generator 구현
-[X] DTO 객체에서 static 필드들 domain 객체로 이동
  - Configure 객체로 빼냄
-[X] DTO 객체 필드 불변으로 생성 필요
  - DTO객체 필드를 불변으로 생성 하기위해 final과 Collections.unmodifiableList을 이용하였다.
  - 명확한 네이밍을 위해 DTO를 VO로 바꿨다.
-[X] LottoResult 에서 result 생성 함수 별도 분리
-[X] View 복잡한 연산 Service로 빼내기
-[X] commit message conventions 학습 및 commit 나누기
-[ ] test 메소드 네이밍 및 작성법 학습

### 기능 요구사항
- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
  입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
## Step4

### 기능 요구사항
- 웹 UI 적용
