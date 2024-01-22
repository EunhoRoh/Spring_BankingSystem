package com.example.spring_bankingsystem.controller;

import com.example.spring_bankingsystem.dto.CommonAfterPagedListDto;
import com.example.spring_bankingsystem.dto.TbuserDto;
import com.example.spring_bankingsystem.service.TbuserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. 회원 API 안내",
        description = "회원 관련 기능 정의한 RestController.")
//api/tbuser가 주소
@RequestMapping("/api/tbuser")
@RestController
public class TbuserRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //TbuserService 주입
    private final TbuserService tbuserService;
    public TbuserRestController(TbuserService tbuserService) {
        this.tbuserService = tbuserService;
    }

    @Operation(summary = "회원 정보 등록",
            description = "회원 신규 정보 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param TbuserCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<TbuserAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
//    postMapping으로 데이터 전달
    // TbuserCreateDto를 받아서 tbuserSevice로 tbuser에 새로 저장하고
    // TbuserAfterCreateDto를 반환
    @PostMapping("")
    public ResponseEntity<TbuserDto.TbuserAfterCreateDto> save(@Valid @RequestBody TbuserDto.TbuserCreateDto params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tbuserService.create(params));
    }

    //putmapping으로 TbuserUpdateDto를 받아서 tbuserService로 수정하고 
    // TbuserAfterUpdateDto를 반환
    @Operation(summary = "회원 정보 수정",
            description = "회원 기존 정보 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param TbuserUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<TbuserAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<TbuserDto.TbuserAfterUpdateDto> update(@Valid @RequestBody TbuserDto.TbuserUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.update(params));
    }

    //GetMapping을 통해 id로 주소를 받는다.
    // tbuserService 의 detail로 user id를 받아와서 
    // TbuserSelectDto로 반환
    @Operation(summary = "회원 정보 조회",
            description = "회원 정보 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<TbuserSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<TbuserDto.TbuserSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.detail(id));
    }

    //list 주소로
    // TbuserListDto로 받아와서 tbuserService의 list로
    //TbuserSelectDto의 list 값을 반환한다.
    @Operation(summary = "회원 정보 목록 조회(검색 기능 포함)",
            description = "회원 정보 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<TbuserSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<TbuserDto.TbuserSelectDto>> list(@Valid @RequestBody TbuserDto.TbuserListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.list(params));
    }

    //morelist라는 주소로
    //TbuserMoreListDto를 받아와서
    //tbuserService의 moreList로 TbuserSelectDto의 리스트를 반환한다.
    // 스크롤
    @Operation(summary = "회원 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "회원 추가 조회한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param TbuserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<TbuserDto.TbuserSelectDto>> moreList(@Valid @RequestBody TbuserDto.TbuserMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.moreList(params));
    }

    //   pagedList 주소로
    // TbuserPagedListDto를 받아와서
    // tbuserService의 pagedList로
    // TbuserSelectDto의 type인 CommonAfterPagedListDto를 반환한다.
    @Operation(summary = "회원 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "회원 페이징 처리 한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param TbuserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<TbuserDto.TbuserSelectDto>> pagedList(@Valid @RequestBody TbuserDto.TbuserPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(tbuserService.pagedList(params));
    }

}
