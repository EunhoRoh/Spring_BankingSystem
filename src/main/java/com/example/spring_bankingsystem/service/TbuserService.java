package com.example.spring_bankingsystem.service;

import com.example.spring_bankingsystem.dto.CommonAfterPagedListDto;
import com.example.spring_bankingsystem.dto.TbuserDto;

import java.util.List;

public interface TbuserService {
    //uid, pw, nick, sfrom 속성값이 있는 TbuserCreateDto를 받아서 id값 하나 있는 TbuserAfterCreateDto로 반환
    public TbuserDto.TbuserAfterCreateDto create(TbuserDto.TbuserCreateDto params);

    //id, pw, nick, sfrom, process, name, phone, mpic, deleted 속성값이 있는 TbuserUpdateDto를 받아서 id, deleted 값이 있는 TbuserAfterUpdateDto로 반환
    public TbuserDto.TbuserAfterUpdateDto update(TbuserDto.TbuserUpdateDto params);

    //user의 id를 받아서 id, uid, pw, sfrom, nick, name, process, phone, mpic, deleted,created_at, modified_at를 가진 TbuserSelectDto로 반환
    public TbuserDto.TbuserSelectDto detail(String id);


    //uid, nick, process, name, phone, deleted 값이 있는 TbuserListDto를 받아서
    //id, uid, pw, sfrom, nick, name, process, phone, mpic, deleted,created_at, modified_at를 가진 TbuserSelectDto의 list로 반환
    public List<TbuserDto.TbuserSelectDto> list(TbuserDto.TbuserListDto params);

    // uid, nick, process, name, phone, deleted 값이 있는 TbuserMoreListDto(CommonMoreListDto 상속) 를 받아서
    //id, uid, pw, sfrom, nick, name, process, phone, mpic, deleted,created_at, modified_at를 가진 TbuserSelectDto의 list로 반환
    public List<TbuserDto.TbuserSelectDto> moreList(TbuserDto.TbuserMoreListDto params);


    //uid, nick, process, name, phone, deleted 값이 있는 TbuserPagedListDto(CommonPagedListDto 상속) 를 받아서
    //id, uid, pw, sfrom, nick, name, process, phone, mpic, deleted,created_at, modified_at를 가진 TbuserSelectDto의 list로 반환
    public CommonAfterPagedListDto<TbuserDto.TbuserSelectDto> pagedList(TbuserDto.TbuserPagedListDto params);

}
