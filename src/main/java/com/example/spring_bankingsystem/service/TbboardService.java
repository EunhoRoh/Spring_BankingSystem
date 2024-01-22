package com.example.spring_bankingsystem.service;

import com.example.spring_bankingsystem.dto.CommonAfterPagedListDto;
import com.example.spring_bankingsystem.dto.TbboardDto;

import java.util.List;

public interface TbboardService {

    public TbboardDto.TbboardAfterCreateDto create(TbboardDto.TbboardCreateDto params);
    public TbboardDto.TbboardAfterUpdateDto update(TbboardDto.TbboardUpdateDto params);
    public TbboardDto.TbboardSelectDto detail(String id);
    public List<TbboardDto.TbboardSelectDto> list(TbboardDto.TbboardListDto params);
    public List<TbboardDto.TbboardSelectDto> moreList(TbboardDto.TbboardMoreListDto params);
    public CommonAfterPagedListDto<TbboardDto.TbboardSelectDto> pagedList(TbboardDto.TbboardPagedListDto params);
}
