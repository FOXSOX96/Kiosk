package challenge.level2.kiosk;

import challenge.level2.Cart;
import challenge.level2.DiscountType;
import challenge.level2.InputSc;
import challenge.level2.Menu;
import challenge.level2.MenuItem;

import java.text.DecimalFormat;
import java.util.Map;

public class KioskOrders {


    /*속성*/
    InputSc inputSc = new InputSc();
    double total = 0;
    double selectNo = -1; /*번호선택*/ /*매번 새로 설정하는 변수*/

    /*생성자*/
    /*주문내역과 총액계산*/
    public void selectOrders(Cart cart) {
        total = 0; /*초기화*/
        DecimalFormat df = new DecimalFormat("#.#");


        for (Map.Entry<Double, MenuItem> entry : cart.getCartMap().entrySet()) {
            Double key = entry.getKey();
            MenuItem menuItem = entry.getValue();
            total += menuItem.getMenuPrice() * cart.getCartCount(key).orElse(0);
        }

        System.out.println("\n[ Total ]");
        System.out.println("w " + df.format(total));

        System.out.println("\n1. 주문");
        System.out.println("2. 메뉴판");

        /*주문시 할인정보 제공*/
        selectNo = inputSc.getSelectNo();
        if (selectNo == 1) {
            System.out.println("할인정보를 입력해주세요.");
            int i = 0;
            for (DiscountType discountType : DiscountType.values()) {
                i += 1;
                Integer discountPercent = discountType.getDiscount();
                System.out.printf("%-1d. %-8s : %-5s\n",
                        i, discountType, discountPercent + " %");
            }

            /*할인정보에 따른 할입된 Total 출력*/
            selectNo = inputSc.getSelectNo();
            switch ((int) selectNo) {
                case 1:
                    total = DiscountType.국가유공자.discountedPrice(total);
                    break;
                case 2:
                    total = DiscountType.군인.discountedPrice(total);
                    break;
                case 3:
                    total = DiscountType.학생.discountedPrice(total);
                    break;
                case 4:
                    total = DiscountType.일반.discountedPrice(total);
                    break;
                default:
                    total = DiscountType.일반.discountedPrice(total);
                    break;
            }

            System.out.println("\n주문이 완료되었습니다. 금액은 w " + total + " 입니다.\n");
            cart.cartClear();


            return;
        } else if (selectNo == 2) {
            return;
        } else {
            System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
    }

    /*기능*/


}
