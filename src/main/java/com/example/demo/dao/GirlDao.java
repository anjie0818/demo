package com.example.demo.dao;

import com.example.demo.domain.Girl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository
public interface GirlDao extends JpaRepository<Girl, Long> {
    List<Girl> findByUsernameAndAge (String username,Integer age);
    // 分页查询
    Page<Girl> findByUsername(String username,Pageable pageable);
    Page<Girl> queryFirst4ByUsername(String username, Pageable pageable);
    /*
    在SQL的查询方法上面使用@Query注解，
    如涉及到删除和修改在需要加上@Modifying.
    也可以根据需要添加 @Transactional 对事物的支持，查询超时的设置等
     */
    @Transactional
    @Modifying
    @Query(value="UPDATE girl u SET u.username =?1 WHERE u.id = ?2",nativeQuery = true)
    int modifyByIdAndUsername(String  username, Integer id);

    @Transactional
    @Modifying
    @Query(value="delete from Girl where id =?1",nativeQuery = true)
    void deleteById(Integer id);

    @Transactional(timeout = 10)
    @Query(value="select * from Girl u where u.email = ?1",nativeQuery = true)
    List<Girl> findByEmail(String email);
}


