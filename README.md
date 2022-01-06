# be-w2-lotto
웹 백엔드 2주차 로또 구현

# step1
- [x] domain, enums, service, utils, view 패키지 분리
   1. domain : 가장 로우한 데이터 패키지(domain/test패키지는 테스트만을 위한 domain)
   2. enums : enum클래스 패키지
   3. service : 비즈니스 로직 패키지
   4. utils : 프로그램에 공통적으로 쓰이는 정보 패키지
   5. view : ui관련 패키지
- [x] step1 요구사항중 당첨 통계 전까지 진행
- [ ] 당첨통계 로직부분 테스트 코드 먼저 작성(진행중)

### 회고
- 처음 설계를 생각하는데 오전을 거의 다 사용했던 것 같습니다. 심지어 그 설계마저 진행하다 보니 거의 다 고쳤습니다 ㅠㅠ
- service/resultManager 클래스의 로직 테스트를 먼저 작성하고 그에 따라 코드를 작성하려 했지만 먼저 테스트를 작성한게 무의미할 정도로
매개변수, 리턴타입등 요소들이 많이 변경되어 이 부분에 대해서 좀 더 생각해보고 짜야겠다고 느꼈습니다


### todo
1. inputview의 getNumberList() stream써서 깔끔하게 고쳐보기
2. InputView의 getWinningLotto 의존성 생각해보기


# step2
- [x] step2 기능 구현 완료
- [x] enum클래스 사용하여 당첨 통계 로직 부분 완성하기
- [x] 로직구현 되는 부분 테스트 코드 작성

### 회고
- 팀원들간의 코드리뷰중 한 팀원이 Arraylist를 stream으로 다루어 코드를 깔끔하게 작성한 것을 보았습니다. 시간이 남으면 이 부분을 수정해 보아야겠습니다.

# step3 
- [x] 전체적인 변수 리네이밍 및 코드 indent 정리완료
- [x] 로또 수동 생성(ManualGenerator) 추가
- [x] step1 todo사항이던 inputview의 getNumberList()함수에 stream적용 완료
- [x] input의 유효성 검증을 위한 Validator class추가
- [x] exception 추가

### 회고
- stream을 처음 써보았는데 코드를 깔끔하게 정리해주는 느낌을 받았고, 좀 더 공부해봐야겠습니다.
- exception을 practice를 찾아 적용해 보았는데 이런식으로 활용하는게 최선인지 궁금합니다.
- option + command + L 을 누르면 코드가 깔끔히 정렬된다!

# reviewfix
- [x] 사용하지 않는 import 정리
- [x] Main클래스의 try catch보다는 명확한 exception throw로 변경
- [x] exception을 위로 전달하는 방식 -> 해당 exception 위치에서 바로 throw하는 방식으로 변경