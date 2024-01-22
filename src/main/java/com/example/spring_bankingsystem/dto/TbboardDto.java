package com.example.spring_bankingsystem.dto;

import com.example.spring_bankingsystem.domain.Tbboard;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TbboardDto {

    @Schema
    //Builder는 이 DTO를 만들려고 쓰는것이다.
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbboardCreateDto {

        @Schema(description = "title", example="title")
        @NotNull
        @NotEmpty
        @Size(max=100)
        private String title;

        @Schema(description = "content", example="content")
        @NotNull
        @NotEmpty
        @Size(max=200)
        private String content;

        //TbboardCreateDto를 Tbboard entity로 만들기
        public Tbboard toEntity() {
            return Tbboard.of(title, content);
        }
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    // 만든후 보여주는 DTO, *그런데 id를 보여주네..?
    public static class TbboardAfterCreateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //update할때 필요한 DTO?*
    public static class TbboardUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        @NotNull
        @NotEmpty
        @Size(max=32)
        private String id;

        @Schema(description = "title", example="title")
        @Size(max=100)
        private String title;

        @Schema(description = "deleted", example="Y")
        @Size(max=1)
        private String deleted;

        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //update한후 보여주는 Dto
    public static class TbboardAfterUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
        @Schema(description = "deleted", example="Y")
        private String deleted;
        @Schema(description = "title", example="title")
        @Size(max=100)
        private String title;
        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //리스트 보여줄때 필요한 Dto?* 그래서 모든 정보가 있나?
    public static class TbboardSelectDto {

        @Schema(description = "id", example="id")
        private String id;
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "deleted", example="N")
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
    // 리스트 만든후 보여주는 DTO
    public static class TbboardListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }

    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //페이지 화면에 뿌릴 DTO
    public static class TbboardPagedListDto extends CommonPagedListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    //스크롤 화면에 뿌릴 DTO
    public static class TbboardMoreListDto extends CommonMoreListDto {
        @Schema(description = "title", example="title")
        private String title;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
}
