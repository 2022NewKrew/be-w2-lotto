# be-w2-lotto
웹 백엔드 2주차 로또 구현

## 로또 1단계 구현

### 구현 내용

- 애플리케이션 내 상수 `Constants`로 분리
- `LottoPrinter`, `LottoScanner`로 입출력 분리

### 피어세션 및 자체 피드백

- `String.format()` 대신 `StringBuilder` 사용 권장

## 로또 2단계 구현

### 구현 내용

- enum 적용

### 피어세션 및 자체 피드백

- 오버플로우 방지

## 로또 3단계 구현

### 구현 내용

- 입력 예외 처리 추가
- 테스트 코드 추가
- `Rank.valueOf()` indent depth 감소
- 일부 변수 자료형 `Integer`에서 `int`로 변경, 불필요한 Boxing 제거
- `winningMoney` 자료형 변경으로 불필요한 캐스팅 제거
- String parsing 에 사용되는 delimiter 변경

### 피어세션 및 자체 피드백

- 예외 처리의 범위 고려
- for-if 패턴 처리 방법 고려

## 로또 4단계 구현

### 구현 내용

- 