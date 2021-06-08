package top.jolyoulu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.jolyoulu.domain.entity.VxMenu;
import top.jolyoulu.domain.request.InitMenuFormBody;

import java.util.List;

/**
 * @Author: LZJ
 * @Date: 2020/6/18 16:38
 * @Version 1.0
 */
@Mapper
@Repository
public interface VxMenuMapper extends BaseMapper<VxMenu> {

    /**
     * 获取菜单返回树结构
     * @return
     */
    List<InitMenuFormBody> selectMenuTree();

    /**
     * 初始化sys_menu表
     */
    void initSysMenuTable();
}
