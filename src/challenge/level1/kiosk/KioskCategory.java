package challenge.level1.kiosk;

import challenge.level1.Main;
import challenge.level1.Menu;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import static challenge.level1.kiosk.KioskMenu.cartState;

public class KioskCategory {
    KioskMenu kioskMenu = new KioskMenu();
    Orders orders = new Orders();
    Discount discount = new Discount();

    /*카테고리 선택 반복문*/
    public void selectCategory(Map<Double, String> getCategoryAll, Scanner sc, Menu menu, Cart cart) {
        /*속성*/
        double selectNo = -1; /*번호선택*/ /*매번 새로 설정하는 변수*/
        double categoryNo = -1; /*카테고리번호*/ /*재사용하는 변수*/
        /* 카테고리 선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {
            DecimalFormat df = new DecimalFormat("#");

            System.out.println("[ MAIN MENU ]");
            /*카테고리 나열*/
            /*사용자편의상 소수점제거하고 정수만 출력*/
            for (Map.Entry<Double, String> entry : getCategoryAll.entrySet()) {
                Double key = entry.getKey();
                String item = entry.getValue();
                System.out.printf("%-4s | %-14s\n",
                        df.format(key) + ".", item);
            }
            System.out.println("0. 종료");
            /*장바구니에 메뉴가 담겨있을 때만, 카테고리 마지막번호 다음번호로 출력*/
            if (!cart.getCartMap().isEmpty()) {
                System.out.printf("%-4s | %-14s | %-14s\n",
                        getCategoryAll.size() + 1 + ".", "주문", "장바구니를 확인 후 주문합니다.");
                System.out.printf("%-4s | %-14s | %-14s\n",
                        getCategoryAll.size() + 2 + ".", "비우기", "장바구니를 비웁니다.");
            }


            /*스캐너입력-selectNo할당*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = Main.getSelectNo(sc);

            /*메뉴번호선택-categoryNo할당*/
            if (selectNo == 0) {
                System.out.println("종료합니다.\n");
                return;
            } else if (selectNo <= getCategoryAll.size()) {
                categoryNo = selectNo;
                menu.getCategory(categoryNo).ifPresentOrElse(
                        item -> System.out.println(item + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
            } else if (!cart.getCartMap().isEmpty() && selectNo == getCategoryAll.size() + 1) {/*장바구니에 메뉴가 담겨있을 때만, 주문 선택가능*/
                selectNo = -1;/*초기화*/
                cartState(cart);/*장바구니 현재 상태안내문*/
                orders.selectOrders(menu.getMenuAll(), sc, menu, cart, discount);
            } else if (!cart.getCartMap().isEmpty() && selectNo == getCategoryAll.size() + 2) {/*장바구니에 메뉴가 담겨있을 때만, 장바구니비우기 선택가능*/
                selectNo = -1;/*초기화*/
                System.out.println("장바구니를 비웁니다.");
                cart.getCartMap().clear();
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }

            /*Main3.메뉴 선택지점 : 카테고리 선택해야 메뉴선택으로 넘어감*/
            if (categoryNo != -1) {
                /*KioskMenu클래스 실행 반복문*/
                cart = kioskMenu.selectMenu(menu.getMenuAll(), sc, menu, categoryNo, cart);
            }
        }

    }
}