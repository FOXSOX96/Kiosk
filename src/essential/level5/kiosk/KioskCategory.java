package essential.level5.kiosk;

import essential.level5.Main;
import essential.level5.Menu;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class KioskCategory {

    /*속성*/
    private double selectNo = -1; /*번호선택*/
    private double categoryNo = -1; /*카테고리번호*/

    /*카테고리 선택 반복문*/
    public double selectCategory(Map<Double, String> getCategoryAll, Scanner sc, Menu menu) {
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
                        df.format(key)+".", item);
            }
            System.out.println("0. 완료");

            /*스캐너입력-selectNo할당*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = Main.getSelectNo(sc);

            /*메뉴번호선택-menuNo할당*/
            if (selectNo == 0) {
                System.out.println("카테고리선택을 완료합니다.\n");
                return categoryNo;
            } else if (selectNo <= getCategoryAll.size()) {
                categoryNo = selectNo;
                menu.getCategory(categoryNo).ifPresentOrElse(
                        item -> System.out.println(item + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }

        }
        return categoryNo;
    }
}
