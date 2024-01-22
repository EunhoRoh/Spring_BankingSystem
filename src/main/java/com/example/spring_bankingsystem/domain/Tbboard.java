package com.example.spring_bankingsystem.domain;

import com.example.spring_bankingsystem.dto.TbboardDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "title")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
})
@Entity
public class Tbboard extends AuditingFields{
    //database에 column 생성
    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문

    protected Tbboard(){}
    private Tbboard(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public static Tbboard of(String title, String content) {
        return new Tbboard(title, content);
    }
    public static Tbboard of(String title) {
        return new Tbboard(title, "");
    }
    
    
    //controller와 view에 전달하기 위해 DTO 생성
    public TbboardDto.TbboardAfterCreateDto toAfterCreateDto() {
        return TbboardDto.TbboardAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }

    public TbboardDto.TbboardAfterUpdateDto toAfterUpdateDto() {
        return TbboardDto.TbboardAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .title(getTitle())
                .content(getContent())
                .build();
    }

}
