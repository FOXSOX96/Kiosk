package challenge.level2;


import challenge.level2.kiosk.KioskCategory;

public class Main {

    public static void main(String[] args) {
        /*속성*/
        Menu menu = new Menu();
        KioskCategory kioskCategory = new KioskCategory();
        Cart cart = new Cart(); /*공유해야하는 객체*/
        InputSc inputSc = new InputSc();

        double selectNo = -1; /*매번 새로 설정하는 변수*/


        /*KioskCategory클래스 실행 반복문*/
        while (selectNo != 0) {

            // - Step0.프로그램 시작지점
            System.out.println("안녕하세요 SHAKESHACK입니다.");
            System.out.println("키오스크를 실행하시겠습니까?");
            System.out.printf("%-4s | %-14s\n",
                    "1.", "실행");
            System.out.printf("%-4s | %-14s\n",
                    "0.", "종료");

            selectNo = inputSc.getSelectNo(); /*스캐너입력-selectNo할당*/

            /*번호알고리즘*/
            if (selectNo == 0) {
                System.out.println("프로그램을 종료합니다.\n");
            } else if (selectNo == 1) {

                // - Step1.카테고리 선택지점
                kioskCategory.selectCategory(cart);

            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }
        }
    }
}



