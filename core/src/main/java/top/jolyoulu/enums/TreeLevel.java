package top.jolyoulu.enums;

/**
 * @Author: LZJ
 * @Date: 2020/6/18 16:51
 * @Version 1.0
 */
public enum TreeLevel {
    FIRST_MENU("一级菜单"),
    SECOND_MENU("二级菜单");
    private String description;

    TreeLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
