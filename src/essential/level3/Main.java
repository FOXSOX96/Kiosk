package essential.level3;


import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*MenuID클래스 객체*/
        Kiosk kiosk = new Kiosk();
        Map<Double, MenuItem> getMenuAll = kiosk.getMenuAll();



        /*속성*/
        double selectNo = 99999; /*번호선택*/
        double menuNo = 99999; /*메뉴번호*/

        /* 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            for (Map.Entry<Double, MenuItem> entry : getMenuAll.entrySet()) {
                Double key = entry.getKey();
                MenuItem item = entry.getValue();
                System.out.printf("%-4s | %-14s (%4.1f) - %s\n",
                        key, item.getMenuName(), item.getMenuPrice(), item.getMenuDetail());
            }
            System.out.println("0. 종료");

            /*입력-selectNo할당*/
            System.out.println("메뉴의 번호를 선택해주세요");
            selectNo = getSelectNo(sc);

            /*메뉴번호선택-menuNo할당*/
            if (selectNo == 0) {
                System.out.println("프로그램을 종료합니다.\n");
            } else if (selectNo <= 1 + 0.1 * getMenuAll.size()) {
                menuNo = selectNo;
                kiosk.getMenu(selectNo).ifPresentOrElse(
                        item -> System.out.println(item.getMenuName() + "을 선택하였습니다."),
                        () -> System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.")
                );
            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }


        }

    }

    /*selectNo-스캐너입력 할당*/
    public static double getSelectNo(Scanner sc) {
        double selectNo;
        try {
            selectNo = sc.nextDouble();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
        return selectNo;
    }

}
