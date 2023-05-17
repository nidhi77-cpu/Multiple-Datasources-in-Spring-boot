/**
 * 
 */
package com.example.Springdatasources.User.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Springdatasources.User.UserEntity;

/**
 * @author srinidhi.k
 *
 */
@Repository
public interface UserRepositry extends JpaRepository<UserEntity, Long> {

}
