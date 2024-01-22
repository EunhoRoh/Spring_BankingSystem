package com.example.spring_bankingsystem.domain;


import com.example.spring_bankingsystem.dto.TbuserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Tbuser getter
@Getter
//entity 다 보여주기?
@ToString(callSuper = true)
// index 설정(검색하려고)
@Table(
        indexes = {
                @Index(name = "IDX_tbuser_createdAt", columnList = "createdAt")
                ,@Index(name = "IDX_tbuser_modifiedAt", columnList = "modifiedAt")
                ,@Index(name = "IDX_tbuser_process", columnList = "process")
        }
        , uniqueConstraints= {
        @UniqueConstraint(name = "UQ_tbuser_nick", columnNames = {"nick"})
}
)
//Tbuser를 entity로 만들자
@Entity
public class Tbuser extends AuditingFields {

    //nullable false로 무조건 값 있게 설정
    @Setter @Column(nullable = false) private String uid;
    @Setter @Column(nullable = false) private String pw;
    @Setter @Column(nullable = false) private String nick;
    @Setter @Column(nullable = false) private String sfrom;
    @Setter @Column(nullable = false) private String process;
    @Setter @Column(nullable = true) private String name;
    @Setter @Column(nullable = true) private String phone;
    @Setter @Column(nullable = true) private String mpic;
    @Setter @Column(nullable = true, length = 10000) private String content; // 본문

    //생성자 접근 못하게
    protected Tbuser(){}
    //생성자
    private Tbuser(String uid, String pw, String nick, String sfrom, String process) {
        this.uid = uid;
        this.pw = pw;
        this.nick = nick;
        this.sfrom = sfrom;
        this.process = process;
    }

    //Tbuser 생성
    public static Tbuser of(String uid, String pw, String nick, String sfrom, String process) {
        return new Tbuser(uid, pw, nick, sfrom, process);
    }

    public static Tbuser of(String uid, String pw) {
        return new Tbuser(uid, pw, "", "", "0");
    }

    //domain에서 TbuserDTO create 버전을 return하는 함수
    public TbuserDto.TbuserAfterCreateDto toAfterCreateDto() {
        //builder 함수로 id 가져와서 dto 만들기
        return TbuserDto.TbuserAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }

    //마찬가지 update 버전 dto 만들기
    public TbuserDto.TbuserAfterUpdateDto toAfterUpdateDto() {
        return TbuserDto.TbuserAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .build();
    }

}
