package com.example.spring_bankingsystem.service.impl;

import com.example.spring_bankingsystem.domain.Tbboard;
import com.example.spring_bankingsystem.dto.CommonAfterPagedListDto;
import com.example.spring_bankingsystem.dto.TbboardDto;
import com.example.spring_bankingsystem.exception.NoMatchingDataException;
import com.example.spring_bankingsystem.mapper.TbboardMapper;
import com.example.spring_bankingsystem.repository.TbboardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

public class TbboardServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TbboardRepository tbboardRepository;
    private final TbboardMapper tbboardMapper;
    public TbboardServiceImpl(
            TbboardRepository tbboardRepository
            ,TbboardMapper tbboardMapper
    ) {
        this.tbboardRepository = tbboardRepository;
        this.tbboardMapper = tbboardMapper;
    }

    public TbboardDto.TbboardAfterCreateDto create(TbboardDto.TbboardCreateDto params){
        return tbboardRepository.save(params.toEntity()).toAfterCreateDto();
    }


    public TbboardDto.TbboardAfterUpdateDto update(TbboardDto.TbboardUpdateDto params){
        Tbboard tbboard = tbboardRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getTitle() != null){
            tbboard.setTitle(params.getTitle());
        }
        if(params.getContent() != null){
            tbboard.setContent(params.getContent());
        }
        if(params.getDeleted() != null){
            tbboard.setDeleted(params.getDeleted());
        }
        tbboardRepository.save(tbboard);
        return tbboard.toAfterUpdateDto();
    }

    public TbboardDto.TbboardSelectDto detail(String id){
        return tbboardMapper.detail(id);
    }

    public List<TbboardDto.TbboardSelectDto> list(TbboardDto.TbboardListDto params){
        return tbboardMapper.list(params);
    }

    public List<TbboardDto.TbboardSelectDto> moreList(TbboardDto.TbboardMoreListDto params){
        params.afterBuild();
        return tbboardMapper.moreList(params);
    }

    public CommonAfterPagedListDto<TbboardDto.TbboardSelectDto> pagedList(TbboardDto.TbboardPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(tbboardMapper.pagedListCount(params)), tbboardMapper.pagedList(params));
    }

}
