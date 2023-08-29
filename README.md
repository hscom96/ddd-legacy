# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항
- **상품**
  - [ ] 이름, 가격을 가지고 있다.
  - [ ] 상품을 생성할 수 있다.
    - [ ] 이름은 비속어를 포함하면 안된다. 비속어의 리스트는 다음과 같다. ([Link](https://www.purgomalum.com/profanitylist.html))  
    - [ ] 가격은 0 이상이어야한다.
  - [ ] 상품 가격을 변경할 수 있다. 
    - [ ] 가격은 0 이상이어야한다.
    - [ ] 변경시에 같은 메뉴에 속해있는 상품들의 가격 총합이 메뉴 가격 보다 크면 메뉴를 비노출 처리 해야한다.
  - [ ] 상품 정보를 모두 조회할 수 있다.
- **메뉴**
  - [ ] 메뉴는 이름, 가격을 가지고 있다.
  - [ ] 메뉴를 생성할 수 있다.
    - [ ] 생성시 이름, 가격, 노출 여부, 메뉴 그룹, 상품등을 설정할 수 있다.
    - [ ] 가격은 0보다 커야한다.
    - [ ] 존재하는 상품을 등록할 수 있다.
    - [ ] 메뉴에는 하나 이상의 상품이 속해있다.
    - [ ] 메뉴의 상품 수량은 0 이상을 설정해야된다.
    - [ ] 속해 있는 모든 상품의 가격 총합보다 메뉴 가격이 높으면 안된다.
    - [ ] 이름은 비속어를 포함하면 안된다. 비속어의 리스트는 다음과 같다. ([Link](https://www.purgomalum.com/profanitylist.html))
  - [ ] 메뉴 가격을 변경할 수 있다.
      - [ ] 가격은 0보다 커야한다.
      - [ ] 각 품목의 가격 총합(수량*개당 가격)보다 메뉴 가격이 높으면 안된다.
  - [ ] 메뉴 노출하기를 설정 할 수 있다.
      - [ ] 각 품목의 가격 총합(수량*개당 가격)보다 메뉴 가격이 높으면 안된다.
  - [ ] 메뉴를 노출 숨기기 설정할 수 있다.
  - 메뉴 정보를 모두 조회할 수 있다.
- **메뉴 그룹**
  - [ ] 메뉴 그룹은 이름을 가지고 있다.
  - [ ] 메뉴를 그룹에 등록할 수 있다.
    - [ ] 메뉴가 없어도 메뉴 그룹을 생성할 수 있다.
  - [ ] 메뉴그룹을 모두 조회할 수 있다.
- **주문**
  - [ ] 주문은 3가지 타입(배달, 테이크아웃, 먹고가기)이 존재한다. 
  - [ ] 주문은 5가지 상태(주문 대기, 주문 승인, 서빙, 배달중, 배달완료, 주문완료)가 존재한다.
  - [ ] 주문을 신규 생성할 수 있다.
    - [ ] 타입 설정을 해야한다.
    - [ ] 최소 1개 이상의 상품이 존재해야 한다.
    - [ ] 존재하는 메뉴를 주문할 수 있다.
    - [ ] 먹고가기 타입이 아닌경우 상품의 수량이 0이하면 안된다.
    - [ ] 메뉴가 노출설정이 되야한다.
    - [ ] 메뉴 가격이 상품의 가격과 다르면 안된다.
    - [ ] 주문을 생성하면 주문 대기 상태가 된다.
    - [ ] 주문시간을 기록해야한다.
    - [ ] 배달의 경우 주소를 등록해야한다.
    - [ ] 먹고가기의 경우 존재하고 사람이 있는 테이블 정보를 등록해야한다.
  - [ ] 주문을 승인할 수 있다.
    - [ ] 주문은 주문대기 상태여야한다.
    - [ ] 라이더에게 배달을 요청해야한다. 이때 주문번호, 가격, 배달주소를 전송한다.
    - [ ] 주문승인 상태로 변경되야한다.
  - [ ] 주문을 서빙으로 변경할 수 있다.
    - [ ] 주문승인 상태여야한다.
    - [ ] 서빙 상태로 변경해야한다.
  - [ ] 배달시작을 할 수 있다.
    - [ ] 주문타입이 배달이어야한다.
    - [ ] 서빙 상태여야한다.
    - [ ] 배달중 상태로 변경해야한다.
  - [ ] 배달완료를 할 수 있다.
    - [ ] 배달중 상태여야한다.
    - [ ] 배달완료 상태로 변경해야한다.
  - [ ] 주문완료를 할 수 있다.
    - [ ] 타입이 배달인데, 배달완료 상태가 아니면 안된다.
    - [ ] 타입이 테이크아웃이나, 먹고가기인데 서빙 상태가 아니면 안된다.
    - [ ] 타입은 주문 완료 상태로 변경해야한다.
    - [ ] 타입이 먹고가기인데 주문완료 상태가 아닌 같은 테이블의 주문이 존재하지 않는다면 테이블의 손님을 0명과 손님이 없는상태로 변경해야한다.
  - [ ] 주문정보를 모두 조회할 수 있다.
- **테이블**
  - [ ] 테이블을 생성할 수 있다.
    - [ ] 이름을 설정해야한다.
    - [ ] 손님은 0명, 손님 없는 상태로 초기화된다.
  - [ ] 테이블을 손님 있는 상태로 변경할 수 있다.
    - [ ] 존재하는 테이블이어야한다.
  - [ ] 테이블을 손님 없는 상태로 변경할 수 있다.
    - [ ] 존재하는 테이블이어야한다.
    - [ ] 주문완료 상태인 테이블이어야한다.
    - [ ] 손님은 0명, 손님 없는상태로 변경된다.
  - [ ] 손님 명수를 변경할 수 있다.
    - [ ] 손님은 1명 이상이어야한다.
    - [ ] 손님이 없는 테이블은 변경할 수 없다.
  - [ ] 테이블 정보를 모두 조회할 수 있다.

## 용어 사전

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
|  |  |  |

## 모델링
