# be-w2-lotto
웹 백엔드 2주차 로또 구현

#3일차
### 피드백
* DTO 객체가 단순히 데이터 저장과 get set만 할 수 있게
* result DTO 객체 만들어보기
* 변수 작명 성실히
* 줄바꿈.
  * 그런데 이건 인텔리제이가 자꾸...
* MatchScore에서 Don't care을 enum이나 상수로 변환
* MatchScore 객체와 맞힌 개수 저장하는 기능 분리
* 컨트롤러가 객체를 생성하지 않도록!
* 복잡한 수식을 컨트롤러에 노출하지 말자.

### 요구사항
* 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.
* 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.
* 예외가 발생하는 부분에 대해 자바 Exception을 적용해 예외처리한다. 
* 사용자가 입력한 값에 대한 예외 처리를 철저히 한다.

### TODO
* MatchScore 객체 분리
  * enum만 하는 객체와 중간 결과를 저장하는 객체를 분리
* Controller를 static 메소드의 집합으로
* 변수명 변경
* private 생성자에 AssertionError 적용
* 수동 입력 부분 구현
* Exception
* 또 테스트 코드 작업.
* Interface 조금 더 잘 쓸 수 있지 않을까?

### DONE
* LottoLine을 분리하고 NNumber에 존재했던 생성 기능을 가져오자.
  * 분리한 LottoLine은 Interface로 관리
* ResultDTO 생성