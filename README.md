# be-w2-lotto
웹 백엔드 2주차 로또 구현

#2일차
### 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.
* enum 적용할것.

### TODO
* private 생성자에 AssertionError 적용
* TestCode...

###DONE
* controller -> controller 이름변경
* WiningLottoLine 도메인 추가
  * 예외처리 부분을 WinningLottoLine 에서 담당
* nNumber 도메인 추가
  * random하게 생성하는 로직 또한 tail latency 가 작은 방향으로 개선
* DTO 추가
  * 숫자 6개가 들어가는 nNumber 만 먼저 추가
* enum Class MatchScore 구현
* WinningLottoLine에 보너스 볼에 대한 자료구조 추가
* 보너스 볼을 위한 로직 구현