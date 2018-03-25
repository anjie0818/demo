package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.demo.domain.User;
@Mapper
public interface  UserMapper {
	@Select("SELECT * FROM user")
	@Results({
		@Result(property = "username",  column = "user_name"),
		@Result(property = "password", column = "pass_word")
	})
	List<User> getAll();
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "email", column = "email")
	})
	User getOne(Long id);

	@Insert("INSERT INTO user(userName,passWord,email) VALUES(#{userName}, #{passWord}, #{email})")
	void insert(User user);

	@Update("UPDATE user SET userName=#{userName},password=#{password} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM user WHERE id =#{id}")
	void delete(Long id);
}
