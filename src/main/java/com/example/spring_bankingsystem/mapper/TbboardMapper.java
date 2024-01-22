package com.example.spring_bankingsystem.mapper;

import com.example.spring_bankingsystem.dto.TbboardDto;

import java.util.List;
import java.util.Map;

//TbboardMapper의 형식 정해주기
//Mapper로 쿼리문을 실행시켜 값을 가져오기
public interface TbboardMapper {

    //pk로
    //* 이 DTO는 뭐였더라 list 생성할때 필요한 DTO인가?
    //모든 정보 가져오기
    TbboardDto.TbboardSelectDto detail(String id);

    //*TbboardListDto->리스트 생성후 보여줄 DTO?
    List<TbboardDto.TbboardSelectDto> list(TbboardDto.TbboardListDto params);

    //TbboardMoreListDto-> 스크롤 화면에서 보여줄 DTO
    List<TbboardDto.TbboardSelectDto> moreList(TbboardDto.TbboardMoreListDto params);

    //TbboardPagedListDto-> 페이지 화면에서 보여줄 DTO
    List<TbboardDto.TbboardSelectDto> pagedList(TbboardDto.TbboardPagedListDto params);

    //TbboardPagedListDto-> 페이지 화면에서 보여줄 DTO
    int pagedListCount(TbboardDto.TbboardPagedListDto params);
}
