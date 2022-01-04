# be-w2-lotto
웹 백엔드 2주차 로또 구현

#1일차
### 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.
* indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
* depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
* method가 한 가지 일만 하도록 최대한 작게 만들어라.
* 배열 대신 ArrayList를 사용한다.
### DONE
* 입력 부분 구현
* 출력 부문 구현
* StartManager 구현
* domain 구현
  * 여러 줄을 총괄하는 MyLottoLines 구현
  * 한 줄만을 관리하는 LottoLine 구현
* ResultManager 구현
* Bugfix
  * 한개의 로또에서 중복된 숫자가 나오는 버그
    * 랜덤 생성 시 로또에 포함된 숫자인지 체크
  * 모든 로또가 같은 숫자를 가지고 있는 버그
    * LottoLine class의 lottoLine 멤버변수의 static 키워드를 삭제