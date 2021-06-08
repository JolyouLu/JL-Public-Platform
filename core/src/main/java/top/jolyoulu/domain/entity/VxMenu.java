package top.jolyoulu.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import top.jolyoulu.enums.MenuType;
import top.jolyoulu.enums.TreeLevel;

/**
 * @Author: JolyouLu
 * @Date: 2021/4/30 17:04
 * @Version 1.0
 */
@Data
@TableName(value = "vx_menu")
public class VxMenu {

    @TableId(type = IdType.AUTO)
    private Long id;
    private Long parentId;
    private TreeLevel treeLevel;
    private Long treeSort;
    private MenuType menuType;
    private String menuName;
    private String menuKey;
    private String menuUrl;
    private String menuMediaId;
    private String menuAppId;
    private String menuPagePath;

}
