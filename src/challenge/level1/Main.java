package challenge.level1;


import challenge.level1.kiosk.Cart;
import challenge.level1.kiosk.KioskCategory;
import challenge.level1.kiosk.KioskMenu;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*속성*/
        Menu menu = new Menu();
        KioskCategory kioskCategory = new KioskCategory();
        KioskMenu kioskMenu = new KioskMenu();
        Cart cart = new Cart(new LinkedHashMap<>());

        double selectNo = -1; /*매번 새로 설정하는 변수*/

        try (Scanner sc = new Scanner(System.in)) {

            /*KioskCategory클래스 실행 반복문*/
            while (selectNo != 0) {

                /*1.프로그램 시작지점*/
                System.out.println("안녕하세요 SHAKESHACK입니다.");
                System.out.println("키오스크를 실행하시겠습니까?");
                System.out.printf("%-4s | %-14s\n",
                        "1.", "실행");
                System.out.printf("%-4s | %-14s\n",
                        "0.", "종료");

                selectNo = getSelectNo(sc); /*스캐너입력-selectNo할당*/

                /*번호알고리즘*/
                if (selectNo == 0) {
                    System.out.println("프로그램을 종료합니다.\n");
                } else if (selectNo == 1) {

                    /*2.카테고리 선택지점 : categoryNo를 받아옴*/
                    double categoryNo = kioskCategory.selectCategory(menu.getCategoryAll(), sc, menu);

                    /*3.메뉴 선택지점 : 카테고리 선택해야 메뉴선택으로 넘어감*/
                    if (categoryNo != -1) {
                        /*KioskMenu클래스 실행 반복문*/
                        cart = kioskMenu.selectMenu(menu.getMenuAll(), sc, menu, categoryNo, cart);
                    }

                } else {
                    System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
                }
            }
        }
    }

    /*스캐너입력-selectNo할당 메서드*/
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
