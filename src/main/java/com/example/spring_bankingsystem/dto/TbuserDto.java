package com.example.spring_bankingsystem.dto;

import com.example.spring_bankingsystem.domain.Tbuser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
public class TbuserDto {
    
    
    @Schema
    //builder 패턴으로 DTO 생성
    @Builder
    @Getter
    @Setter
    //parameter 없어도 생성
    @NoArgsConstructor
    //모든 parameter 생성자
    @AllArgsConstructor
    //* 왜 user id가 없을까?
    //Tbuser를 생성할때 필요한 DTO
    public static class TbuserCreateDto {
        @Schema(description = "uid", example="이메일 주소")
        @NotNull
        @Email
        @NotEmpty
        @Size(max=100)
        private String uid;

        @Schema(description = "pw", example="비밀번호")
        @NotNull
        @NotEmpty
        @Size(max=50)
        private String pw;

        @Schema(description = "nick", example="닉네임")
        @NotNull
        @NotEmpty
        @Size(max=50)
        private String nick;

        @Schema(description = "sfrom", example="가입 경로")
        @NotNull
        @NotEmpty
        @Size(max=50)
        private String sfrom;

        //TbuserCreateDto 를 entity로 변경
        public Tbuser toEntity() {
            return Tbuser.of(uid, pw, nick, sfrom, "0");
        }
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //DTO를 만들고 나서 보여줄 DTO
    public static class TbuserAfterCreateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //Tbuser를 update할때 필요한 DTO
    public static class TbuserUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        @NotNull
        @NotEmpty
        @Size(max=32)
        private String id;

        @Schema(description = "비밀번호", example="abcd1234!")
        @Size(max=20)
        private String pw;
        @Schema(description = "닉네임", example="1234")
        @Size(max=20)
        private String nick;
        @Schema(description = "가입경로", example="1234")
        @Size(max=20)
        private String sfrom;
        @Schema(description = "단계", example="")
        @Size(max=20)
        private String process;

        @Schema(description = "이름", example="1234")
        @Size(max=20)
        private String name;
        @Schema(description = "전화번호", example="1234")
        @Size(max=20)
        private String phone;
        @Schema(description = "대표사진", example="~~~~.png")
        @Size(max=200)
        private String mpic;
        @Schema(description = "삭제 여부", example="Y")
        @Size(max=1)
        private String deleted;
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //Tbuser update하고 나서 보여줄 DTO
    // *생성과 생성후 DTO는 다르구나
    public static class TbuserAfterUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
        @Schema(description = "deleted", example="Y")
        private String deleted;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //* 이 DTO는 뭐였더라 list 생성할때 필요한 DTO인가?
    public static class TbuserSelectDto {

        @Schema(description = "id", example="id")
        private String id;
        @Schema(description = "E-mail(id)", example="id")
        private String uid;
        @Schema(description = "비밀번호", example="abcd1234!")
        private String pw;
        @Schema(description = "가입경로", example="")
        private String sfrom;
        @Schema(description = "닉네임", example="1234")
        private String nick;
        @Schema(description = "이름", example="1234")
        private String name;
        @Schema(description = "단계", example="")
        private String process;
        @Schema(description = "전화번호", example="1234")
        private String phone;
        @Schema(description = "대표사진", example="~~~~.png")
        private String mpic;
        @Schema(description = "삭제 여부", example="Y")
        private String deleted;
        @Schema(description = "created_at", example="2024-01-01 00:00:00.000000")
        private String created_at;
        @Schema(description = "modified_at", example="2024-01-01 00:00:00.000000")
        private String modified_at;

    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //*리스트 생성후 보여줄 DTO?
    public static class TbuserListDto {
        @Schema(description = "E-mail(id)", example="id")
        private String uid;
        @Schema(description = "닉네임", example="1234")
        private String nick;
        @Schema(description = "단계", example="")
        private String process;
        @Schema(description = "이름", example="1234")
        private String name;
        @Schema(description = "전화번호", example="1234")
        private String phone;
        @Schema(description = "삭제 여부", example="Y")
        private String deleted;
    }

    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //여기엔 bulder 가 없지?
    // 페이지 화면에서 보여줄 DTO
    public static class TbuserPagedListDto extends CommonPagedListDto {
        @Schema(description = "E-mail(id)", example="id")
        private String uid;
        @Schema(description = "닉네임", example="1234")
        private String nick;
        @Schema(description = "단계", example="")
        private String process;
        @Schema(description = "이름", example="1234")
        private String name;
        @Schema(description = "전화번호", example="1234")
        private String phone;
        @Schema(description = "삭제 여부", example="Y")
        private String deleted;
    }
    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //스크롤 화면에서 보여줄 DTO
    public static class TbuserMoreListDto extends CommonMoreListDto {
        @Schema(description = "E-mail(id)", example="id")
        private String uid;
        @Schema(description = "닉네임", example="1234")
        private String nick;
        @Schema(description = "단계", example="")
        private String process;
        @Schema(description = "이름", example="1234")
        private String name;
        @Schema(description = "전화번호", example="1234")
        private String phone;
        @Schema(description = "삭제 여부", example="Y")
        private String deleted;
    }

}
