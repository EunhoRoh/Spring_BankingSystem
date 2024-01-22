package com.example.spring_bankingsystem.repository;

import com.example.spring_bankingsystem.domain.Tbuser;
import org.springframework.data.jpa.repository.JpaRepository;


//Tbuser 테이블 CRUD 기능을 사용할 수 있다.
// String 이 id 값이다.
public interface TbuserRepository extends JpaRepository<Tbuser, String> {
}
