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

## Step4

### 요구사항
* https://lucas.codesquad.kr/2022-kakao/course/%EC%9B%B9%EB%B0%B1%EC%97%94%EB%93%9C/Lotto/SparkJava 를 참고해서 구현한다.
* 스프링은 사용하지 않는다.
* 콘솔 UI 대신 웹 UI를 적용한다.
* 웹 페이지 템플릿

#### 힌트
* 브라우저에서 http://localhost:8080 에 접속하면 index.html 파일 내용을 응답으로 보낸다.
* 값을 입력한 후 "로또 구매" 버튼을 클릭하면 /buyLotto URL로 서버에 데이터를 전달한다. 
  * 서버는 /buyLotto URL에 대응하는 post 메소드를 추가한다.
  * 서버는 request의 queryParams("inputMoney") 메소드를 통해 클라이언트에서 전달한 로또 구입 금액을 받는다.
  * 서버는 request의 queryParams("manualNumber") 메소드를 통해 클라이언트에서 전달한 수동으로 구매하는 로또를 받는다.
  * 수동으로 구매하는 로또 목록을 split("\r?\n")으로 분리한다.
  * 분리한 데이터를 Lotto로 생성해 show.html 파일에 전달한 후 응답으로 보낸다.
* show.html에서 구매한 로또 목록을 출력하는 방법은 다음과 같다.

~~~
{{#lottos}}
  <tr>
    <th>{{@index}}</th>
    <td>{{lotto}}</td>
  </tr>
{{/lottos}}
~~~

* 값을 입력한 후 "당첨 번호" 버튼을 클릭하면 /matchLotto URL로 서버에 데이터를 전달한다.
  * 서버는 /matchLotto URL에 대응하는 post 메소드를 추가한다.
  * 서버는 request의 queryParams("winningNumber") 메소드를 통해 클라이언트에서 전달한 당첨번호 값을 추출한다.
  * 서버는 request의 queryParams("bonusNumber") 메소드를 통해 클라이언트에서 전달한 보너스 번호 값을 추출한다.
  * 구매한 로또와 당첨번호를 비교한 결과를 result.html에 전달한다.
  * result.html은 당첨 결과를 html로 생성한다.
