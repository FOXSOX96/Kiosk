package challenge.level2.kiosk;

import challenge.level2.Cart;
import challenge.level2.Main;
import challenge.level2.Menu;
import challenge.level2.MenuItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;


public class KioskStep2Menu {

    /*속성*/

    /*생성자*/
    /*기능*/
    /*메뉴선택 반복문*/

    public Cart selectMenu(Map<Double, MenuItem> getMenuAll, Scanner sc, Menu menu, double categoryNo, Cart cart) {
    double menuNo = -1; /*메뉴번호*/ /*매번 새로 설정하는 변수*/
    double selectNo = -1; /*번호선택*/ /*매번 새로 설정하는 변수*/

        /*카테고리 속 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            /*카테고리 속 메뉴나열*/
            /*categoryNo의 1의자리 값을 갖는 MenuNo만 필터*/
            /*사용자편의상 번호 선택을 정수로 변환하여 나타냄(1.01, 1.02, 1.03을 1,2,3으로 출력)*/
            for (Map.Entry<Double, MenuItem> entry : getMenuAll.entrySet()) {
                Double key = entry.getKey();
                BigDecimal keyD = BigDecimal.valueOf(key);
                BigDecimal floor = keyD.setScale(0, RoundingMode.FLOOR);
                BigDecimal frac = keyD.subtract(floor);
                if (key > categoryNo && key < categoryNo + 1.0) {
                    MenuItem item = entry.getValue();
                    System.out.printf("%-4s | %-14s | W %4.1f | - %s\n",
                            frac.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).intValue() + ".", item.getMenuName(), item.getMenuPrice(), item.getMenuDetail());
                }
            }
            System.out.println("0. 선택완료");

            /*스캐너입력-selectNo할당*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = Main.getSelectNo(sc);

            /*메뉴번호선택-menuNo할당*/
            if (selectNo == 0) {
                return cart;
            } else if (selectNo <= getMenuAll.size()) {
                selectNo = selectNo * 0.01 + categoryNo;  /*사용자편의상 정수를 입력시켰으므로 menuNo의 소수점에 입력값 넣음*/
                menuNo = selectNo;
                menu.getMenu(selectNo).ifPresentOrElse(
                        item -> System.out.printf("선택한 메뉴 : %-14s | W %4.1f | - %s\n",
                                item.getMenuName(), item.getMenuPrice(), item.getMenuDetail()),
                        () -> { throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
                        }
                );
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
                selectNo = -1; /*초기화*/
            }


            /*장바구니 담기 Cart.java*/

            while (selectNo != -1) {
                System.out.println("위 메뉴를 장바구니에 담으시겠습니까?");
                System.out.println("1. 담기");
                System.out.println("2. 빼기");
                System.out.println("3. 취소");
                /*스캐너입력-selectNo할당*/
                selectNo = Main.getSelectNo(sc);

                if (selectNo == 1) {
                    MenuItem selectedItem =
                            menu.getMenu(menuNo)
                                    .orElseThrow(() -> new IllegalArgumentException("선택하신 번호와 일치하는 메뉴가 없습니다.")); /*옵셔널이라 에러문 추가*/
                    cart.addCartMap(menuNo, selectedItem);
                    cart.addCartCount(menuNo);

                    cartState(cart);/*장바구니 현재 상태안내문*/
                    break;
                } else if (selectNo == 2) {
                    MenuItem selectedItem =
                            menu.getMenu(menuNo)
                                    .orElseThrow(() -> new IllegalArgumentException("선택하신 번호와 일치하는 메뉴가 없습니다.")); /*옵셔널이라 에러문 추가*/

                    cart.subCartCount(menuNo);

                    cartState(cart);/*장바구니 현재 상태안내문*/
                    break;
                }
                else if (selectNo == 3) {
                    break;
                } else {
                    selectNo = -1; /*0 입력할 수 있으니 초기화*/
                    System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
                }
            }
        }
        return cart;
    }

    /*장바구니 현재 상태 안내매서드*/
    public static void cartState(Cart cart) {
        System.out.println("[ 장바구니 ]");
        for(Map.Entry<Double, MenuItem> entryCart : cart.getCartMap().entrySet()){
             Double key = entryCart.getKey();
             MenuItem menuItem = entryCart.getValue();
            System.out.printf("%-14s | W %4.1f | 수량: %d\n",
                    menuItem.getMenuName(), menuItem.getMenuPrice(), cart.getCartCount(key).orElse(0));
        }
        if (cart.getCartMap().isEmpty()) {
            System.out.println("비어있음");
        }
    }
}
