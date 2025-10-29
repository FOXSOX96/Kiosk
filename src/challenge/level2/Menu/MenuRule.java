package challenge.level2.Menu;

public interface MenuRule {
    /* 카테고리 추가는 1.0 단위로만 생성되어야 함 */
    void addCategory(String name);

    /* 메뉴 추가는 카테고리의 정수 x를 기준으로 x.01, x.02 ... 형태여야 함 */
    void addMenu(double categoryKey, String menuName, double menuPrice, String menuDetail);

}
