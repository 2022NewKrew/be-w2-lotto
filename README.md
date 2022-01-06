# be-w2-lotto
웹 백엔드 2주차 로또 구현

# 기능목록
## 1단계
### 요구사항
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다. 
- [x] 로또 1장의 가격은 1000원이다.
- [x] indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라. 
  - depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다. 
- [x] else를 사용하지 마라. 
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다. 
  - method가 한 가지 일만 하도록 최대한 작게 만들어라. 
- [x] 배열 대신 ArrayList를 사용한다.
- [x] 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.

## 2단계
### 요구사항
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.
- [x] enum을 적용해 프로그래밍을 구현한다.

### 피드백 반영
- [X] Controller에서 Money클래스 분리
  - [참고자료](https://limdingdong.tistory.com/9)
- [X] LottoNumber에 제약조건 추가
- [X] Lotto의 purchaseLotto에서 IntStream을 사용하지 않도록 변경
  - RandomNumbers에 숫자의 개수를 6개로 끊는 부분 구현
- [x] LottoNumber안에 Comparable을 구현하여 Get을 사용하지 않도록 변경
- [x] WinningNumber를 LottoNumber로 대체
- [X] Lotto와 LottoNumber 클래스에 validate 메소드 옮기기
- [X] WinningNumbers에 있는 로또 당첨 확인 관련 로직에서 Getter 빼기
  - Getter를 이용해 객체를 불러오는 객체로 메소드 옮기기
  - LottoNumber에서 equals 재정의하기
- [X] RandomNumbers도 util로 빼거나, RandomUtil에 로직을 구현하기
- [X] LottoNumber 1~45까지의 객체를 캐싱하기
  - [참고자료](https://tecoble.techcourse.co.kr/post/2020-06-24-caching-instance/)
