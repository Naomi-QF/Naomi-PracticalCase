package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	LoginEntity findByLoginIdAndPassword(int loginId, String password);


}
