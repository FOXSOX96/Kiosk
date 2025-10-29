package challenge.level2.Menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Menu implements MenuRule {

    /*메뉴 아이디 할당 : MenuID =double*/
    private Map<Double, MenuItem> menuMap = new LinkedHashMap<>();
    private Map<Double, String> categoryMap = new LinkedHashMap<>();

    /*생성자*/

    public Menu() {
        /*카테고리1 버거*/
        categoryMap.put(1.0, "Burgers");
        menuMap.put(1.01, new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuMap.put(1.02, new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuMap.put(1.03, new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuMap.put(1.04, new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        /*카테고리2 음료*/
        categoryMap.put(2.0, "Drinks");
        menuMap.put(2.01, new MenuItem("Coke", 3.0, "펩시와 코카콜라 선택 제공"));
        menuMap.put(2.02, new MenuItem("Cidar", 3.0, "칠성사이다 밖에 없습니다"));
        menuMap.put(2.03, new MenuItem("Orange Soda", 4.0, "환타 오렌지맛"));
        menuMap.put(2.04, new MenuItem("Ice Americano", 3.5, "기름질 때는 쌉쌀한 아이스 아메리카노"));

        /*카테고리3 디저트*/
        categoryMap.put(3.0, "Desserts");
        menuMap.put(3.01, new MenuItem("Ice Cream", 1.5, "소프트 아이스크림, 쵸코는 매장 사정상 판매하지 않습니다"));
        menuMap.put(3.02, new MenuItem("Fried potato ", 2.0, "감자튀김, 햄버거 먹는데 당연히 같이 시키시죠"));
        menuMap.put(3.03, new MenuItem("Oreo Cake", 10.0, "오레오 케이크, 맥플러리 아닙니다."));
        menuMap.put(3.04, new MenuItem("Apple Pie", 10.0, "애플파이, 달콤상콤"));

    }


    /*게터*/

    public Optional<String> getCategory(Double CategoryID) {
        return Optional.ofNullable(categoryMap.get(CategoryID));
    }

    public Optional<MenuItem> getMenu(Double MenuID) {
        return Optional.ofNullable(menuMap.get(MenuID));
    }

    /*게터 전체*/

    public Map<Double, String> getCategoryAll() {
        return categoryMap;
    }

    public Map<Double, MenuItem> getMenuAll() {
        return menuMap;
    }

    /*세터*/
    public void setCategoryMap(Map<Double, String> categoryMap) {
        this.categoryMap = categoryMap;
    }

    public void setMenuMap(Map<Double, MenuItem> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    /* 카테고리 추가는 1.0 단위로만 생성되어야 함 */
    public void addCategory(String categoryName) {
        double categoryKey = categoryMap.isEmpty() ? 1.0 : categoryMap.keySet().stream()
                .max(Double::compareTo).get() + 1.0;

        categoryMap.put(categoryKey, categoryName);
    }

    @Override
    /* 메뉴 추가는 카테고리의 정수 x를 기준으로 x.01, x.02 ... 형태여야 함 */
    public void addMenu(double categoryKey, String menuName, double menuPrice, String menuDetail) {

        double menuKey = menuMap.isEmpty() ? categoryKey + 0.01 : menuMap.keySet().stream()
                .filter(key -> key >= categoryKey && key < categoryKey + 1.0)
                .max(Double::compareTo).map(key -> key + 0.01)
                .orElse(categoryKey + 0.01);
        menuMap.put(menuKey, new MenuItem(menuName, menuPrice, menuDetail));
    }

}

