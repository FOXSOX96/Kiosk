package challenge.level2.kiosk;

import challenge.level2.*;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class KioskStep3Orders {


    /*속성*/
    double total = 0;
    double selectNo = -1; /*번호선택*/ /*매번 새로 설정하는 변수*/

    /*생성자*/
    /*주문내역과 총액계산*/
    public void selectOrders(Map<Double, MenuItem> getMenuAll, Scanner sc, Menu menu, Cart cart, Discount discount) {
        total = 0; /*초기화*/
        DecimalFormat df = new DecimalFormat("#.#");
        DecimalFormat df2 = new DecimalFormat("#");


        for (Map.Entry<Double, MenuItem> entry : cart.getCartMap().entrySet()) {
            Double key = entry.getKey();
            MenuItem menuItem = entry.getValue();
            total += menuItem.getMenuPrice() * cart.getCartCount(key).orElse(null);
        }

        System.out.println("");
        System.out.println("[ Total ]");
        System.out.println("w " + df.format(total));

        /*주문시 할인정보 제공*/
        System.out.println("");
        System.out.println("1. 주문");
        System.out.println("2. 메뉴판");

        selectNo = Main.getSelectNo(sc);
        if (selectNo == 1) {
            System.out.println("할인정보를 입력해주세요.");
            int i = 0;
            for (Map.Entry<String, Integer> entry : discount.getDiscountMap().entrySet()) {
                i += 1;
                String key = entry.getKey();
                Integer discountPercent = entry.getValue();
                System.out.printf("%-1d. %-6s : %-14s\n",
                        i, key, discountPercent + "%");
            }

    /*        selectNo = Main.getSelectNo(sc);
            switch((int)selectNo) {
                case 1: discount.
                case 1:
            }*/
            return;
        } else if (selectNo == 2) {
            return;
        } else {
            System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
    }

    /*기능*/


}
