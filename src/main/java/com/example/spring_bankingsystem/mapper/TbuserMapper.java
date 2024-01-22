package com.example.spring_bankingsystem.mapper;

import com.example.spring_bankingsystem.dto.TbuserDto;

import java.util.List;

//TbuserMapper의 형식 정해주기
//Mapper로 쿼리문을 실행시켜 값을 가져오기
public interface TbuserMapper {

    //pk로
    //* 이 DTO는 뭐였더라 list 생성할때 필요한 DTO인가?
    //모든 정보 가져오기
    TbuserDto.TbuserSelectDto detail(String id);

    //*TbuserListDto->리스트 생성후 보여줄 DTO?
    List<TbuserDto.TbuserSelectDto> list(TbuserDto.TbuserListDto params);


    //TbuserMoreListDto-> 스크롤 화면에서 보여줄 DTO
    List<TbuserDto.TbuserSelectDto> moreList(TbuserDto.TbuserMoreListDto params);


    //TbuserPagedListDto-> 페이지 화면에서 보여줄 DTO
    List<TbuserDto.TbuserSelectDto> pagedList(TbuserDto.TbuserPagedListDto params);


    //TbuserPagedListDto-> 페이지 화면에서 보여줄 DTO
    int pagedListCount(TbuserDto.TbuserPagedListDto params);
}
