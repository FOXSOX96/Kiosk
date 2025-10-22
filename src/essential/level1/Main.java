package essential.level1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*Lv 1. 기본적인 키오스크를 프로그래밍해보자*/

        /*속성*/
        int selectNo = 99999; /*번호선택*/
        int menuNo = 99999; /*메뉴번호*/

        /* 메뉴선택: 0이 입력되면 종료되는 반복문시작*/
        while (selectNo != 0) {

            System.out.println("[SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger  | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2. SmokeShack   | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3. Cheeseburger | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4. Hamburger    | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0. 종료          | 종료");

            /*입력-selectNo할당*/
            System.out.println("메뉴를 선택해주세요");
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
            sc.nextLine();
            throw new IllegalArgumentException("메뉴와 일치하는 숫자를 입력해야 합니다.");
        }
        return selectNo;
    }

}
