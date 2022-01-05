# be-w2-lotto
웹 백엔드 2주차 로또 구현

### RUN with Gradle!
```
$ cd lotto
$ ./gradlew build
$ ./gradlew run --console=plain
```

### Step3 변경사항
1. build.gradle 수정
- plugins : 'application' 추가하여 ./gradlew run 으로 동작 가능하게 변경
2. WinningLottery 구현 수정
- Lotto 객체를 멤버변수로 가지기보다 Lotto 클래스를 상속하는 방식으로 구현
- 전체적인 코드로직이 좀더 직관적이게 되었고, 많은 로직을 수정하지 않아도 되었다.(뿌듯)
- 근데, WinningLottery 가 Lotto 를 상속하는 것이 개념적으로 적절한지는 좀더 고민..
