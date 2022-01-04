# be-w2-lotto
웹 백엔드 2주차 로또 구현

# 초기설정
- [x] 프로젝트 생성
  - [x] java 11 gradle 로 생성하기
  - [x] .gitignore 설정하기
  - [x] 테스트코드 의존성 추가하기


## 1단계
- [x] 로또
  - [x] 1 ~ 45의 숫자를 가진다.
  - [x] 6개의 숫자를 가지고 있어야 한다.
  - [x] 중복된 숫자를 가지고 있으면 안된다.
  - [x] 매번 랜덤하게 숫자가 생성되어야 한다.
- [x] 로또를 관리하는 일급컬렉션 (Lottos)
  - [x] 목표 개수 만큼 로또를 생성한다.
- [x] 당첨금액
  - [x] enum 으로 관리하기
  - [x] 맞춘 개수에 따른 객체 반환
  - [x] 맞춘 개수가 0~6개여야 한다.
- [x] 당첨번호
  - [x] 로또랑 같은 요구사항
  - [x] 로또번호를 입력해 당첨금액을 반환한다.
- [ ] 당첨결과 관리
  - [ ] 당첨금액과 수익률을 관리한다.
- [x] 로또 구매
  - [x] 천원단위로 절삭
  - [x] valid : 음수입력시 에러
- [x] 유틸
  - [x] 랜덤한 숫자 6개를 반환한다.
  - [x] 중복되지 않은 숫자여야 한다.
