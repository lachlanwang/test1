package com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: test
 * @description
 * @author: wz
 * @create: 2021-04-07 13:55
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
