package com.example.spring_bankingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//이 리스트 DTO는 스크롤 정보를 보여주는 걸꺼야..*
public class CommonMoreListDto {

    //검색 기준일
    @Schema(description = "검색 기준일(시작)", example="1970-01-01")
    private String sdate;

    //
    @Schema(description = "검색 기준일(종료)", example="1970-01-01")
    private String fdate;

    //한번에 볼 갯수
    @NotNull
    @NotEmpty
    @Schema(description = "한번에 볼 갯수", example="10")
    private int permore;

    //검색 기준일시??*
    // 계속 바뀌는 기준인가?
    @Schema(description = "검색 기준일시", example="1970-01-01 00:00:00.000000")
    private String cdatetime;

    //최근꺼, 예전꺼부터?
    @Schema(description = "조회 방향", example="recent,before")
    private String cway;

    //permore
    public void afterBuild(){
        //몇 페이지씩 볼래?
        if(permore <= 0){
            permore = 10;
        }

        //검색 기준일시가 없거나 빈공백이라면
        //검색 기준일시를 맨 끝으로 둔다.
        // 조회 방ㅇ향은 예전꺼부터?*
        if(cdatetime == null || "".equals(cdatetime)){
            cdatetime = "9999-12-31 23:59:59.999999";
            cway = "before";
        }
    }
}
