# be-w2-ticket
웹 백엔드 2주차 로또 구현

## 기능 요구사항

- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다. 당첨 통계에 2등도 추가해야 한다.



## 프로그래밍 요구사항

- [x] indent depth를 2단계에서 1단계로 줄여라.
- [x] else 를 사용하지 마라.
- [x] 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - [x] method가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] 배열 대신 ArrayList를 사용한다.
- [x] enum을 적용해 프로그래밍을 구현한다.



## 구현 사항

- LottoApplication
  - LottoApplication 의 main 메소드에서 애플리케이션이 실행됩니다.
  - LottoApplication 의 main 메소드가 사용자의 역할을 하며, InputView 로 애플리케이션에 입력을 하고, 입력값을 바탕으로 RequestDto 를 생성, Controller 를 호출하여, Controller 가 반환한 응답을 OutputView 를 통해 출력받습니다.
- LottoController
  - 사용자로부터 받은 요청에 맞는 Service 를 호출하여 응답을 반환합니다.

- LottoService
  - 도메인에 있는 비즈니스 로직을 순서대로 호출하여 사용자의 요청에 알맞는 ResponseDto 를 반환합니다.

- Domain
  - LottoPrice, LottoConstant
    - 로또에 관련된 상수와 관련 로직을 갖고 있습니다.

  - generator
    - Generator
      - Ticket 생성기 인터페이스입니다.

    - RandomGenerator
      - 랜덤으로 로또 숫자를 생성해 Ticket 을 반환하는 구현체입니다.

    - ManualGenerator
      - 사용자로부터 받은 입력값으로 Ticket 을 반환하는 구현체입니다.

  - ticket
    - Ticket
      - 로또 한 장을 의미하는 객체입니다.

    - TicketBundle
      - Ticket 뭉치를 의미하는 개체입니다.
    - LottoMachine
      - 구매 금액, 생성기를 받아 Ticket 리스트를 생성하는 객체입니다.

  - result
    - Rank
      - 로또 등수에 대한 Enum 클래스입니다.

    - LottoResult
      - 로또 결과에 대한 클래스입니다.

- dto
  - LottoCheckRequestDto
    - 로또를 확인할 때 사용자가 보내는 요청 데이터입니다.

  - LottoCheckResponseDto
    - 로또를 확인하고 사용자에게 보내는 응답 데이터입니다.

  - LottoPurchaseRequestDto
    - 로또를 구매할 때 사용자가 보내는 요청 데이터입니다.

  - LottoPurchaseResponseDto
    - 로또를 구매하고 사용자에게 보내는 응답 데이터입니다.

- exception
  - 커스텀 익셉션 패키지입니다.

- validation
  - InputViewValidation
    - 입력값 검증을 위한 클래스입니다.

- view
  - InputView
    - 입력을 받는 메소드를 가진 클래스입니다.

  - OutputView
    - 출력을 하는 메소드를 가진 클래스입니다.


