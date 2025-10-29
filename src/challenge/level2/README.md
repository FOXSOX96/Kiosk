# Kiosk System — Level 2 (Java)

## 키오스크 주문 시스템.

이 프로젝트는 자바 콘솔 기반 키오스크 프로그램으로,

카테고리 관리 / 메뉴 관리 / 장바구니 / 주문 및 할인 기능을 포함합니다.

## 주요 특징:

카테고리 단위 메뉴 그룹핑

장바구니 담기/빼기

주문 시 할인(국가유공자, 군인, 학생, 일반) 계산

관립탭에서 카테고리, 메뉴 추가

## 구조 개요
```
challenge.level2/
│
├── Main.java                 # 프로그램 시작점
├── Cart.java                 # 장바구니 기능
├── DiscountType.java         # 할인 정책 Enum
├── InputSc.java              # Scanner 입력 처리모음
│
├── Menu/
│   ├── Menu.java             # 전체 메뉴 및 카테고리 컬렉션 관리
│   ├── MenuItem.java         # 개별 메뉴 속성 클래스
│   └── MenuRule.java         # 메뉴/카테고리 추가 규칙 인터페이스
│
└── kiosk/
├── KioskCategory.java        # 메인 메뉴(카테고리) 선택 로직
├── KioskMenu.java            # 카테고리 내 메뉴 선택 로직
├── KioskOrders.java          # 주문 및 할인 계산 로직
└── KioskEdit.java            # 관리자용 카테고리, 메뉴 편집 로직
```
### ================================================================
## 클래스별 설명
### Main.java

프로그램의 진입점.
사용자에게 두 가지 선택지를 제공합니다:

1. 실행 → 사용자 키오스크 모드

2. 관리 → 관리자 카테고리,메뉴 편집 모드

0. 종료

→ 선택에 따라 KioskCategory 또는 KioskEdit 실행.

### KioskCategory.java

메인 화면을 담당.

카테고리 목록 출력

장바구니 상태에 따라 “주문” 및 “비우기” 메뉴 동적 생성

카테고리 선택 시 → KioskMenu로 이동

주문 선택 시 → KioskOrders 실행

### KioskMenu.java

카테고리 내 실제 메뉴 선택 단계.

메뉴명, 가격, 상세 설명 출력

장바구니 담기 / 빼기 / 취소 로직 포함

Cart 객체를 공유하며 수량 변경 및 상태 출력

### KioskOrders.java

주문 확인 및 결제 단계.

장바구니 총 금액 계산

할인타입(DiscountType) 출력 및 선택

할인 적용 후 결제 완료 메시지 표시

주문 완료 시 cart.cartClear()로 초기화

### KioskEdit.java

관리자(CMS) 화면.

카테고리 추가

메뉴 추가 (카테고리 지정 후 이름, 가격, 설명 입력)

Menu 객체 직접 수정 가능

등록 후 KioskCategory.categoryArrange() 및 KioskMenu.menuArrange()로 확인

### Cart.java

장바구니 관리 클래스.

cartMap : 메뉴key → 메뉴객체

cartCount : 메뉴key → 수량

메뉴 담기, 빼기, 초기화, 상태 출력 기능 포함

cart.addCartMap(menuNo, menuItem);
cart.addCartCount(menuNo);
cart.cartState(); // 현재 장바구니 상태 출력

### Menu.java

카테고리(categoryMap)와 메뉴(menuMap)를 LinkedHashMap으로 관리

메뉴ID는 1.01, 1.02, 2.01처럼 카테고리번호.소수점 메뉴번호 구조

addCategory, addMenu 메서드를 통해 CMS 동적 확장 가능

### MenuItem.java

메뉴명, 가격, 설명을 필드로 가짐

단순 데이터 객체 (Getter/Setter 중심)

### DiscountType.java

Enum 기반 할인 정책 정의.
```
유형	할인율

국가유공자	10%
군인	5%
학생	3%
일반	0%
```
discountedPrice() 메서드를 통해 할인 적용 금액 계산.

### InputSc.java

모든 Scanner 입력 통합 관리

숫자 입력 예외처리 (InputMismatchException)

getSelectNo() / getString() 두 가지 모드 지원
### ================================================================
## 실행 예시
```
안녕하세요 SHAKESHACK입니다.
키오스크를 실행하시겠습니까?
1.   | 실행
2.   | 관리
0.   | 종료

> 1
```

```
[ MAIN MENU ]
1.   | Burgers       
2.   | Drinks        
3.   | Desserts      
0. 종료
메뉴의 번호를 선택해주세요

> 1
```

```
Burgers을 선택하였습니다.
[SHAKESHACK MENU ]
1.   | ShackBurger    | ₩  6.9 | - 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2.   | SmokeShack     | ₩  8.9 | - 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3.   | Cheeseburger   | ₩  6.9 | - 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4.   | Hamburger      | ₩  5.4 | - 비프패티를 기반으로 야채가 들어간 기본버거
0. 선택완료
메뉴의 번호를 선택해주세요

> 1
```

```
선택한 메뉴 : ShackBurger    | ₩  6.9 | - 토마토, 양상추, 쉑소스가 토핑된 치즈버거
위 메뉴를 장바구니에 담으시겠습니까?
1. 담기
2. 빼기
3. 취소

> 1
```

```
[ 장바구니 ]
ShackBurger    | ₩  6.9 | 수량: 1
[SHAKESHACK MENU ]
1.   | ShackBurger    | ₩  6.9 | - 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2.   | SmokeShack     | ₩  8.9 | - 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3.   | Cheeseburger   | ₩  6.9 | - 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4.   | Hamburger      | ₩  5.4 | - 비프패티를 기반으로 야채가 들어간 기본버거
0. 선택완료
메뉴의 번호를 선택해주세요

> 0
```

```
[ MAIN MENU ]
1.   | Burgers       
2.   | Drinks        
3.   | Desserts      
0. 종료
4.   | 주문             | 장바구니를 확인 후 주문합니다.
5.   | 비우기            | 장바구니를 비웁니다.   
메뉴의 번호를 선택해주세요

> 4
```

```
[ 장바구니 ]
ShackBurger    | ₩  6.9 | 수량: 1

[ Total ]
₩ 6.9

1. 주문
2. 메뉴판


> 1
```
```
할인정보를 입력해주세요.
1. 국가유공자    : 10 % 
2. 군인       : 5 %  
3. 학생       : 3 %  
4. 일반       : 0 %  

> 1
```

```
주문이 완료되었습니다. 금액은 ₩ 6.21 입니다.
```
