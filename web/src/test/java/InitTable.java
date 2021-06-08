import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.jolyoulu.Application;
import top.jolyoulu.domain.entity.VxMenu;
import top.jolyoulu.enums.MenuType;
import top.jolyoulu.enums.TreeLevel;
import top.jolyoulu.mapper.VxMenuMapper;

/**
 * @Author: JolyouLu
 * @Date: 2021/6/8 14:59
 * @Version 1.0
 * 初始化数据库表
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class InitTable {

    @Autowired
    private VxMenuMapper vxMenuMapper;

    /**
     * 初始化所有表
     */
    @Test
    public void initAllTable(){
        initSysMenuTable();
    }

    /**
     * 初始化菜单表
     */
    @Test
    public void initSysMenuTable(){
        vxMenuMapper.initSysMenuTable();
        VxMenu p = new VxMenu();
        p.setTreeLevel(TreeLevel.FIRST_MENU);
        p.setMenuName("一级菜单");
        int insert = vxMenuMapper.insert(p);
        if (insert > 0 ){
            for (int i = 0; i < 2; i++) {
                VxMenu sub = new VxMenu();
                sub.setParentId(p.getId());
                sub.setTreeLevel(TreeLevel.SECOND_MENU);
                sub.setTreeSort(Long.valueOf(i));
                sub.setMenuName("二级菜单");
                sub.setMenuType(MenuType.click);
                sub.setMenuKey("A00"+(i+1));
                vxMenuMapper.insert(sub);
            }
        }
    }

}
