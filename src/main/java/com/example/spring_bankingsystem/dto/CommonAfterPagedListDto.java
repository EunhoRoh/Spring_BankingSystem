package com.example.spring_bankingsystem.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Schema
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//generic으로 Dto를 받는 것인가?
public class CommonAfterPagedListDto<T> {
    
    @Schema(description = "요청 페이지", example="1")
    private int callpage;

    //페이지 사이즈
    @Schema(description = "마지막 페이지", example="100")
    private int lastpage;
    
    @Schema(description = "한번에 조회할 갯수", example="100")
    private int perpage;
    
    
    @Schema(description = "전체 갯수", example="1")
    private int listsize;

    //이 리스트에 TbboardSelectDto, TbuserSelectDto를 담는건가?
    @Schema(description = "리스트", example="해당 리스트")
    private List<T> list;
    
    //*afterBuild를 통해 전달 받은 결과를 calc에 넣은건가?
    //List<T>에는 Dto를 담은거지
    public CommonAfterPagedListDto(int[] calc, List<T> list){
        this.callpage = calc[0];
        this.lastpage = calc[1];
        this.perpage = calc[2];
        this.listsize = calc[3];
        this.list = list;
    }
}
