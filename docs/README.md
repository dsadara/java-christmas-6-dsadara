## 🚀 구현할 기능

### 입출력 (view)

- [X] 이벤트 플래너 안내문 출력
- [X] 식당 예상 방문 날짜 입력 및 안내문 출력
    - [X] 1 이상 31 이하의 숫자인지 검증
- [X] 주문 메뉴와 개수 입력 및 안내문 출력
    - [X] 메뉴판에 있는 메뉴인지 검증
    - [X] 메뉴의 개수가 1 이상인지 검증
    - [X] 메뉴 입력 형식이 다른 경우 검증
      - [X] 메뉴 입력 hyphen(-)을 누락한 경우
      - [X] 여러 메뉴 입력시 comma(,)을 누락한 경우
    - [X] 중복 메뉴를 입력했는지 검증
- [X] 이벤트 혜택 출력
    - [X] 안내문
    - [X] 주문 메뉴
    - [X] 할인 전 총주문 금액
    - [X] 증정 메뉴
    - [X] 혜택 내역
    - [X] 총혜택 금액
    - [X] 할인 후 예상 결제 금액
    - [X] 12월 이벤트 배지

### 모델 (model)

- [X] 주문
    - [X] 음료만 주문하는지 검증
    - [X] 메뉴 개수가 20개가 넘는지 검증
    - [X] 총 주문 금액 계산
- [X] 이벤트 적용
    - [X] 주문 금액이 10000원 이상인지 검증
    - [X] 크리스마스 디데이 할인
    - [X] 평일 할인
    - [X] 주말 할인
    - [X] 특별 할인
    - [X] 증정 이벤트
        - [X] 샴페인 증정
    - [X] 이벤트 배지 부여
    - [X] 이벤트 결과 전달

## 🛠️ 리펙토링

- [X] InputView에서 파싱하는 로직 외부로 분리