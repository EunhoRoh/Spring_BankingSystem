package com.example.spring_bankingsystem.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Schema
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//공통된 요소로 리스트를 뿌린다.
// 페이지 화면에서 보여질 정보를 담고있음
public class CommonPagedListDto {
    //시작
    @Schema(description = "검색 기준일(시작)", example="1970-01-01")
    private String sdate;
    //종료
    @Schema(description = "검색 기준일(종료)", example="1970-01-01")
    private String fdate;
    
    
    @NotNull
    @NotEmpty
    @Schema(description = "요청 페이지", example="1")
    private int callpage;
    
    //한번에 볼 갯수
    @NotNull
    @NotEmpty
    @Schema(description = "한번에 볼 갯수", example="10")
    private int perpage;
    
    
    @NotNull
    @NotEmpty
    @Schema(description = "정렬 기준", example="1")
    private String orderby;
    
    
    @NotNull
    @NotEmpty
    @Schema(description = "정렬 방향", example="1")
    private String orderway;

    //build 후에 페이지 정보를 리스트로 뿌려주기
    // parameter는 전체 list의 싸이즈다.
    public int[] afterBuild(int listsize){
        //페이지 당 보여줄 갯수
        if(perpage <= 0){
            perpage = 10;
        }

        // 남은 페이지 갯수
        int pagesize_remain = listsize % perpage;

        int pagesize = listsize / perpage;
        if(pagesize_remain > 0){
            pagesize++;
        }

        //페이지 사이즈가 0이면 1페이지로 설정
        if(pagesize == 0){
            pagesize++;
        }

        //부를 페이지가 0보다 작으면 1로 설정
        if(callpage < 1){
            callpage = 1;
            // 부르는 페이지가 더 크면 가장 끝 페이지로
        } else if(callpage > pagesize){
            callpage = pagesize;
        }

        //시작 페이지
        int offset = (callpage - 1) * perpage;
        //배열에 부를 페이지, 마지막 페이지, 몇개 부를건지, 전체 데이터갯수 전달
        int[] result = {callpage, pagesize, perpage, listsize};

        // 부를 페이지를 다음 시작 페이지로 설정* 이해가 잘 안가네..?
        callpage = offset;
        return result;
    }
}
