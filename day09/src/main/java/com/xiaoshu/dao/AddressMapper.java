package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Address;
import com.xiaoshu.entity.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends BaseMapper<Address> {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    List<Address> selectByExample(AddressExample example);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

	List<Address> findByParentId(@Param("parentId")int i);
}