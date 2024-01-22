package com.example.spring_bankingsystem.service.impl;

import com.example.spring_bankingsystem.domain.Tbuser;
import com.example.spring_bankingsystem.dto.CommonAfterPagedListDto;
import com.example.spring_bankingsystem.dto.TbuserDto;
import com.example.spring_bankingsystem.exception.NoMatchingDataException;
import com.example.spring_bankingsystem.mapper.TbuserMapper;
import com.example.spring_bankingsystem.repository.TbuserRepository;
import com.example.spring_bankingsystem.service.TbuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

//service로 선언
@Service
public class TbuserServiceImpl implements TbuserService {


    //log 기록?
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //오버와이어
    private final TbuserRepository tbuserRepository;
    private final TbuserMapper tbuserMapper;
    public TbuserServiceImpl(
            TbuserRepository tbuserRepository
            ,TbuserMapper tbuserMapper
    ) {
        this.tbuserRepository = tbuserRepository;
        this.tbuserMapper = tbuserMapper;
    }

    //uid, pw, nick, sfrom 속성값이 있는 TbuserCreateDto를 받아서 id값 하나 있는 TbuserAfterCreateDto로 반환
    public TbuserDto.TbuserAfterCreateDto create(TbuserDto.TbuserCreateDto params){
        //tbuser table에 저장
        // 근데 toAfterCreateDto 메소드를 만든적이 있나?* 있다 -> tbuser 도메인에
        // 빌드하는 것이다.
        return tbuserRepository.save(params.toEntity()).toAfterCreateDto();
    }

    //id, pw, nick, sfrom, process, name, phone, mpic, deleted 속성값이 있는 TbuserUpdateDto를 받아서
    // id, deleted 값이 있는 TbuserAfterUpdateDto로 반환
    public TbuserDto.TbuserAfterUpdateDto update(TbuserDto.TbuserUpdateDto params){
        //parameter로 id값으로 찾아서 tbuser 객체에 넣기
        Tbuser tbuser = tbuserRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        //다시 tbuser를 parameter 값으로 설정해준다.
        if(params.getPw() != null){
            tbuser.setPw(params.getPw());
        }
        if(params.getNick() != null){
            tbuser.setNick(params.getNick());
        }
        if(params.getSfrom() != null){
            tbuser.setSfrom(params.getSfrom());
        }
        if(params.getDeleted() != null){
            tbuser.setDeleted(params.getDeleted());
        }
        if(params.getProcess() != null){
            tbuser.setProcess(params.getProcess());
        }
        if(params.getName() != null){
            tbuser.setName(params.getName());
        }
        if(params.getPhone() != null){
            tbuser.setPhone(params.getPhone());
        }
        if(params.getMpic() != null){
            tbuser.setMpic(params.getMpic());
        }

        //새롭게 설정된 tbuser를 저장한다.
        tbuserRepository.save(tbuser);
        // tbuser를 TbuserAfterUpdateDto로 빌드해서 return 한다.
        return tbuser.toAfterUpdateDto();
    }


    //user id 주고 TbuserSelectDto 불러오기
    public TbuserDto.TbuserSelectDto detail(String id){
        return tbuserMapper.detail(id);
    }

    //TbuserListDto 주고 TbuserSelectDto list 불러오기
    public List<TbuserDto.TbuserSelectDto> list(TbuserDto.TbuserListDto params){
        return tbuserMapper.list(params);
    }

    //TbuserMoreListDto주고 TbuserMoreListDto
    public List<TbuserDto.TbuserSelectDto> moreList(TbuserDto.TbuserMoreListDto params){
        //afterBuild로 permore과 cdatetime, cway 사전 설정
        params.afterBuild();
        return tbuserMapper.moreList(params);
    }

    //TbuserSelectDto를 리스트로 받는것인가?
    //이 부분 이해가 잘 안간다..*
    public CommonAfterPagedListDto<TbuserDto.TbuserSelectDto> pagedList(TbuserDto.TbuserPagedListDto params){
        //afterBuild함수로 callpage, lastpage, perpage, listsize의 값을 입력하고, list도 생성자에 입력
        return new CommonAfterPagedListDto<>(params.afterBuild(tbuserMapper.pagedListCount(params)), tbuserMapper.pagedList(params));
    }

}
