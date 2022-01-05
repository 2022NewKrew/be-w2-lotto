# be-w2-lotto
웹 백엔드 2주차 로또 구현

## Step1

### 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

### 프로그래밍 요구사항
* indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
    * method가 한 가지 일만 하도록 최대한 작게 만들어라.
* 배열 대신 ArrayList를 사용한다.

### 힌트
* 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
* Collections.sort() 메소드를 활용해 정렬 가능하다.
* ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

## Step2

### 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.

### 프로그래밍 요구사항
* enum을 적용해 프로그래밍을 구현한다.

### 힌트
* Lotto 클래스를 사용자가 구매한 Lotto와 로또 기계에 의해 추첨한 Lotto를 구분해 생성한다.
    * 로또 기계가 추첨한 Lotto는 WinningLotto와 같은 방식

## Step3

### 기능 요구사항
* 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

### 프로그래밍 요구사항
* 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다.
* 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.