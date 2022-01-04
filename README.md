# be-w2-lotto
웹 백엔드 2주차 로또 구현

#2일차
### 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.
* enum 적용할것.

### TODO
* winningLottoLine 객체를 만들자.
  * 이건 하나니까 static하게
* Line<Integer>로 주고 받지 말고 객체의 형태로 돌아다니게 하자.
* Result Manager에 enum 적용하기.
* 로또 생성 다시 구현할 것.
  * shuffle 이용하면 더 좋다는걸 왜 몰랐을까!
* private 생성자에 AssertionError 적용