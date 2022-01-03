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
3. getWinningLotto generate부분도


# step2
- [ ] 당첨 통계 로직 부분 완성하기
- [ ] 의존성 지키게 수정
- [ ] 테스트 코드 작성