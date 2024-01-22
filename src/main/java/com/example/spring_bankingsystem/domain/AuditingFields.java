package com.example.spring_bankingsystem.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
//entitylister는 뭐지? 바꼈을때 듣는건가?
@EntityListeners(AuditingEntityListener.class)
//superclass 매핑하기?
@MappedSuperclass
public abstract class AuditingFields {
    //pk
    @Id
    private String id;

    @Column(nullable = false)
    @Setter
    protected String deleted;

    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    //*자동으로 생성되는건가?
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt; // 생성일시
    
    //자동으로 생성?
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt; // 수정일시
    
    //미리 값 지정해주기
    @PrePersist
    public void onPrePersist() {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.deleted = "N";
    }

}
