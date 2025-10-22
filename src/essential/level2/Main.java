package essential.level2;


import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*MenuID클래스 객체*/
        MenuID menuID = new MenuID();
        Map<Double, MenuItem> getMenuAll = menuID.getMenuAll();


        /*속성*/
        int selectNo = 99999; /*번호선택*/
        int menuNo = 99999; /*메뉴번호*/

        /* 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            for (Map.Entry<Double, MenuItem> entry : getMenuAll.entrySet()) {
                Double key = entry.getKey();
                MenuItem item = entry.getValue();
                System.out.printf("%-4s | %-14s (%4.1f) - %s\n",
                        key, item.getMenuName(), item.getMenuPrice(), item.getMenuDetail());
            }
            System.out.println("0.   | 종료");

            /*입력-selectNo할당*/
            System.out.println("\n메뉴를 선택해주세요");
            selectNo = getSelectNo(sc);

            /*메뉴번호선택-menuNo할당*/
            switch (selectNo) {
                case 1:
                    menuNo = 1; //"ShackBurger"
                    System.out.println("ShackBurger 를 선택하였습니다.\n");
                    break;
                case 2:
                    menuNo = 2; //"SmokeShack"
                    System.out.println("SmokeShack 를 선택하였습니다.\n");
                    break;
                case 3:
                    menuNo = 3; // "Cheeseburger"
                    System.out.println("Cheeseburger 를 선택하였습니다.\n");
                    break;
                case 4:
                    menuNo = 4; // "Hamburger"
                    System.out.println("Hamburger 를 선택하였습니다.\n");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.\n");
                    break;
                default:
                    System.out.println("선택된 메뉴가 없습니다.\n");
                    break;
            }

        }

    }

    /*selectNo-스캐너입력 할당*/
    public static int getSelectNo(Scanner sc) {
        int selectNo;
        try {
            selectNo = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
        return selectNo;
    }

}
