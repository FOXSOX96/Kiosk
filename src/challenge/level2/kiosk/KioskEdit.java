package challenge.level2.kiosk;

import challenge.level2.InputSc;
import challenge.level2.Menu.Menu;

import java.text.DecimalFormat;

public class KioskEdit {
    InputSc inputSc = new InputSc();
    KioskMenu kioskMenu = new KioskMenu();
    KioskCategory kioskCategory = new KioskCategory();

    // - Step1-2.1.관리자 시작지점
    public void editSelect(Menu menu) {
        /*속성*/
        double selectNo = -1; /*매번 새로 설정하는 변수*/

        while (selectNo != 0) {

            System.out.println("SHAKESHACK 관리자페이지 CMS입니다.");
            System.out.println("원하는 편집항목을 선택해주세요.");
            System.out.printf("%-4s | %-14s\n",
                    "1.", "카테고리 추가");
            System.out.printf("%-4s | %-14s\n",
                    "2.", "메뉴 추가");
            System.out.printf("%-4s | %-14s\n",
                    "0.", "종료");

            selectNo = inputSc.getSelectNo(); /*스캐너입력-selectNo할당*/

            /*번호알고리즘*/
            if (selectNo == 0) {
                System.out.println("CMS를 종료합니다.\n");
            } else if (selectNo == 1) {
                System.out.println("새로 추가할 카테고리의 이름을 입력해주세요.");
                inputSc.getString(); /*개행 제거용 빈 호출*/
                String categoryName = inputSc.getString();
                menu.addCategory(categoryName);
                /*카테고리 나열*/
                kioskCategory.categoryArrange(menu);
            } else if (selectNo == 2) {
                /*카테고리 나열*/
                kioskCategory.categoryArrange(menu);

                System.out.println("새로 추가할 메뉴의 카테고리 No를 입력해주세요.");
                double categoryKey = inputSc.getSelectNo();
                /*카테고리 없는 숫자 입력시 오류해결*/
                while (categoryKey > menu.getCategoryAll().keySet().stream().max(Double::compareTo).orElse(0.0)) {
                    System.out.println("존재하지 않는 카테고리입니다. 다시 입력해주세요.");
                    categoryKey = inputSc.getSelectNo();
                }
                System.out.println("새로 추가할 메뉴의 이름를 입력해주세요.");
                inputSc.getString(); /*개행 제거용 빈 호출*/
                String menuName = inputSc.getString();
                System.out.println("새로 추가할 메뉴의 가격을 입력해주세요.(₩ 1.0 = 천원)");
                double menuPrice = inputSc.getSelectNo();
                System.out.println("새로 추가할 메뉴의 설명을 입력해주세요.");
                inputSc.getString(); /*개행 제거용 빈 호출*/
                String menuDetail = inputSc.getString();

                menu.addMenu(categoryKey, menuName, menuPrice, menuDetail);
                /*메뉴 나열*/
                kioskMenu.menuArrange(menu, categoryKey);

            } else {
                System.out.println("메뉴와 일치하는 숫자를 입력해야 합니다.");
            }
        }

    }
}
