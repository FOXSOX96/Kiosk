package essential.level4.kiosk;

import essential.level4.Main;
import essential.level4.Menu;
import essential.level4.MenuItem;

import java.util.Map;
import java.util.Scanner;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class KioskMenu {

    /*속성*/
    double selectNo = 99999; /*번호선택*/
    double menuNo = 99999; /*메뉴번호*/

    /*메뉴선택 반복문*/
    public double selectMenu(Map<Double, MenuItem> getMenuAll, Scanner sc, Menu menu, double categoryNo) {


        /* 카테고리 속 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            /*카테고리 속 메뉴나열*/
            /*categoryNo의 1의자리 값을 갖는 MwnuNo만 필터*/
            /*사용자편의상 번호 선택을 정수로 변환하여 나타냄(1.1, 1.2, 1.3을 1,2,3으로 출력)*/
            for (Map.Entry<Double, MenuItem> entry : getMenuAll.entrySet()) {
                Double key = entry.getKey();
                BigDecimal keyD = BigDecimal.valueOf(key);
                BigDecimal floor = keyD.setScale(0, RoundingMode.FLOOR);
                BigDecimal frac = keyD.subtract(floor);
                if (key > categoryNo && key < categoryNo + 1.0) {
                    MenuItem item = entry.getValue();
                    System.out.printf("%-4s | %-14s (%4.1f) - %s\n",
                            frac.multiply(BigDecimal.TEN).multiply(BigDecimal.TEN).intValue()+".", item.getMenuName(), item.getMenuPrice(), item.getMenuDetail());
                }
            }
            System.out.println("0. 뒤로가기");

            /*스캐너입력-selectNo할당*/
            /*사용자편의상 정수를 입력시켰으므로 menuNo의 소수점에 입력값 넣음*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = Main.getSelectNo(sc);
            selectNo = selectNo *0.01 + categoryNo;

            /*메뉴번호선택-menuNo할당*/
            if (selectNo == 0) {
                System.out.println("키오스크를 종료합니다.\n");
            } else if (selectNo <= getMenuAll.size()) {
                menuNo = selectNo;
                menu.getMenu(selectNo).ifPresentOrElse(
                        item -> System.out.println(item.getMenuName() + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
                return menuNo;
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }
        }
        return menuNo;
    }
}
