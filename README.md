# be-w2-lotto
웹 백엔드 2주차 로또 구현

### RUN with Gradle!
```
$ cd lotto
$ ./gradlew build
$ ./gradlew run --console=plain
```

### Step3 변경사항
1. **build.gradle 수정**
- plugins : 'application' 추가하여 ./gradlew run 으로 동작 가능하게 변경
2. **WinningLottery 구현 수정**
- Lotto 객체를 멤버변수로 가지기보다 Lotto 클래스를 상속하는 방식으로 구현
- 전체적인 코드로직이 좀더 직관적이게 되었고, 많은 로직을 수정하지 않아도 되었다.(뿌듯)
- 근데, WinningLottery 가 Lotto 를 상속하는 것이 개념적으로 적절한지는 좀더 고민..

3. **Statistics 추상클래스로 변경, 자식으로 YieldStatistics 구현체 구현**

- Statistics 의 기능을 당첨된 로또 정보 처리, YieldStatistics 는 추가 수익률 계산만 하도록 해 책임을 좀더 분산시켰습니다.

4. **수동 입력 기능 추가**

- Lotto 클래스에 randomGenerated 속성 추가, 로또 입력 인터페이스에 수동 입력 추가했습니다. 

5. **BonusNumber 클래스 따로 추가**

- Integer 를 단순히 래핑한 클래스이지만, 이를 통해 BonusNumber의 유효성 검증에 대한 책임을 WinningLottery로 부터 분리할 수 있었습니다.

6. **도메인 별 예외처리 구현, view 입력값 예외처리 구현**

- 확실히, 도메인의 책임들을 작은 클래스단위로 위임하니, 하나의 클래스가 가지는 예외처리 부담이 적었습니다.



### 느낀점?

- 확실히 로또 도메인에 대한 책임들을 작은 클래스단위로 위임하니, 요구사항 추가를 위한 코드 수정이 적었으며, 다른 모듈을 거의 건드리지 않고, 전체 동작과 로직도 영향을 받지 않았습니다.
- 또 각 도메인클래스에 대한 예외처리 부담이 분산되면서도 유기적으로 동작함을 느꼈습니다...
- 근데.. Lotto 클래스에 static 메서드가 많은데 잘 구현한게 맞는지.. 아니면 LottoUtils 같은 따로 유틸클래스를 만드는 것이 좋은지.. Lotto 도메인의 공통성 기능이라고 생각해서 Lotto 클래스 안에 같이 정의를 했습니다. 그러나 코드가 전반적으로 지저분해진거 같기도 해서.. static 메서드를 다른 방식으로 분리하는 것이 나을지 고민입니다.



### TODO...

테스트코드.. 의 작성... 구현하면서 같이..
