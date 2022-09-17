package com.jluzh.admin.mapper;

import com.jluzh.admin.model.UmsMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 后台菜单表 Mapper 接口
 * </p>
 *
 * @author banana
 * @since 2022-09-15
 */
public interface UmsMenuMapper extends BaseMapper<UmsMenu> {
    UmsMenu selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(UmsMenu record);
    int updateByPrimaryKey(UmsMenu record);

}
