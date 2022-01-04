# be-w2-lotto
웹 백엔드 2주차 로또 구현

#2일차
### 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.
* enum 적용할것.

### TODO
* Line<Integer>로 주고 받지 말고 객체의 형태로 돌아다니게 하자.
* Result Manager에 enum 적용하기.
* 로또 생성 다시 구현할 것.
  * shuffle 이용하면 더 좋다는걸 왜 몰랐을까!
* private 생성자에 AssertionError 적용
* TestCode...

###DONE
* controller -> controller 이름변경
* WiningLottoLine 도메인 추가
  * 예외처리 부분을 WinningLottoLine 에서 담당
* nNumber 도메인 추가
  * random하게 생성하는 로직 또한 tail latency가 작은 방향으로 개선