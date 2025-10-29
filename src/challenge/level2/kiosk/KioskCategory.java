package challenge.level2.kiosk;

import challenge.level2.Cart;
import challenge.level2.InputSc;
import challenge.level2.Menu.Menu;

import java.text.DecimalFormat;

public class KioskCategory {
    KioskMenu kioskMenu = new KioskMenu();
    KioskOrders kioskOrders = new KioskOrders();
    InputSc inputSc = new InputSc();


    /*카테고리 선택 반복문*/
    public void selectCategory(Menu menu , Cart cart) {
        /*속성*/
        double selectNo = -1; /*번호선택*/ /*매번 새로 설정하는 변수*/
        double categoryNo = -1; /*카테고리번호*/ /*재사용하는 변수*/
        /* 카테고리 선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {
            System.out.println("[ MAIN MENU ]");
            /*카테고리 나열*/
            /*사용자편의상 소수점제거하고 정수만 출력*/
            categoryArrange(menu);
            System.out.println("0. 종료");
            /*장바구니에 메뉴가 담겨있을 때만, 카테고리 마지막번호 다음번호로 출력*/
            if (!cart.getCartMap().isEmpty()) {
                System.out.printf("%-4s | %-14s | %-14s\n",
                        menu.getCategoryAll().size() + 1 + ".", "주문", "장바구니를 확인 후 주문합니다.");
                System.out.printf("%-4s | %-14s | %-14s\n",
                        menu.getCategoryAll().size() + 2 + ".", "비우기", "장바구니를 비웁니다.");
            }

            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = inputSc.getSelectNo();

            /*메뉴번호선택-categoryNo할당*/
            if (selectNo == 0) {
                System.out.println("종료합니다.\n");
                return;
            } else if (selectNo <= menu.getCategoryAll().size()) {
                categoryNo = selectNo;
                menu.getCategory(categoryNo).ifPresentOrElse(
                        item -> System.out.println(item + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
            } else if (!cart.getCartMap().isEmpty() && selectNo == menu.getCategoryAll().size() + 1) { /*장바구니에 메뉴가 담겨있을 때만, 주문 선택가능*/
                selectNo = -1; /*초기화*/
                categoryNo = -1; /*주문 후 카테고리 선택으로 내보내기위해 초기화*/
                cart.cartState(); /*장바구니 현재 상태안내문*/

                // - Step3.주문지점
                kioskOrders.selectOrders(cart);
            } else if (!cart.getCartMap().isEmpty() && selectNo == menu.getCategoryAll().size() + 2) {/*장바구니에 메뉴가 담겨있을 때만, 장바구니비우기 선택가능*/
                selectNo = -1;/*초기화*/
                System.out.println("장바구니를 비웁니다.");
                cart.getCartMap().clear();
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }

            // - Step2.메뉴 선택지점 : 카테고리 선택해야 메뉴선택으로 넘어감
            if (categoryNo != -1) {
                /*KioskMenu클래스 실행 반복문*/
                cart = kioskMenu.selectMenu(menu, categoryNo, cart);
            }
        }

    }

    public void categoryArrange(Menu menu) {
        DecimalFormat df = new DecimalFormat("#");
        menu.getCategoryAll().entrySet().stream().forEach(entry -> System.out.printf("%-4s | %-14s\n",
                df.format(entry.getKey()) + ".", entry.getValue()));
    }
}
