package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.entity.User;

@Mapper
public interface UserMapper {
	int insert(User user);
	
	User selectOneByCondition(User user);  
	
	User selectById(Integer id);  
    
    int updateById(User user);  
      
    int deleteById(Integer id);  
      
    List<User> queryAll(); 
}
