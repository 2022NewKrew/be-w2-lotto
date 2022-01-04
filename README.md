# be-w2-lotto
웹 백엔드 2주차 로또 구현

### 기능
- 사용자 입력 받아 랜덤 로또 생성
- 로또 결과 및 통계

... 테스트 아직 안해봤어여 ...

### 구조
```
App - LottoController  - Domain - Lotto
                                - LottoRank
                                - LottoResult
                                - WinningLotto
                      
                       - View   - LottoView
    
    - InputController
```

App
- 객체 생성 및 관리

LottoController
- 로또 객체 생성 및 결과 관리

InputController
- 사용자의 입력 관리

Lotto
- 사용자가 뽑은 로또 넘버 관리

LottoRank
- 등수에 따른 금액

WinningLotto
- 기계가 뽑은 로또

LottoResult
- 로또 결과 관리 객체

LottoView
- 로또 관한 View

### 기능요구사항
```
로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
로또 1장의 가격은 1000원이다.
2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.
```