package com.Test.service;

import com.Test.domain.Dto.SellDto;
import com.Test.domain.Dto.StoreDto;
import com.Test.domain.Entity.SellEntity;
import com.Test.domain.Entity.SellRepository;
import com.Test.domain.Entity.StoreEntity;
import com.Test.domain.Entity.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;




@Service
public class SellService {
    //세팅
    // ------------1.전역변수---------------//
    @Autowired
    private HttpServletRequest request; // 요청 객체 선언
    @Autowired
    private HttpServletResponse response; // 응답 객체 선언
    @Autowired
    private SellRepository sellRepository; // 회원 리포지토리 객체 선언
    @Autowired
    private StoreRepository storeRepository;
    // @Autowired
    // private  BoardService boardService; // 불가능



    // 2. 게시물 목록 조회
    @Transactional      // sellno : 제품번호 , page : 현재 페이지번호 , key : 검색필드명 , keyword : 검색 데이터
    public List<SellDto> boardlist(int page , int sellno ){
        Page<SellEntity> elist = null; // 1. 페이징처리된 엔티티 리스트 객체 선언
        Pageable pageable = PageRequest.of(  // 2.페이징 설정 [ 페이지시작 : 0 부터 ] , 게시물수 , 정렬
                page-1 , 3 , Sort.by( Sort.Direction.DESC , "sellno")  );

        elist = sellRepository.findByStoreno( sellno , pageable );

        // 프론트엔드에 표시할 페이징번호버튼 수
        int btncount = 5;                               // 1.페이지에 표시할 총 페이지 버튼 개수
        int startbtn = (page/btncount) * btncount +1;   // 2. 시작번호 버튼
        int endbtn = startbtn + btncount-1;             // 3. 마지막번호 버튼
        if( endbtn > elist.getTotalPages() ) endbtn =elist.getTotalPages();

        List<SellDto> dlist = new ArrayList<>(); // 2. 컨트롤에게 전달할때 형변환[ entity->dto ] : 역할이 달라서
        for( SellEntity entity : elist ){ // 3. 변환
            dlist.add( entity.toDto() );
        }

        dlist.get(0).setStartbtn( startbtn );
        dlist.get(0).setEndbtn( endbtn );

        return dlist;  // 4. 변환된 리스트 dist 반환
    }

    @Transactional // 매장등록
    public boolean setstore(StoreDto stdto){
        if (stdto != null) {
            StoreEntity storeEntity = storeRepository.save(stdto.toEntity());
            return true;
        }else{
            return false;
        }
    }

    @Transactional // 매장출력
    public List<StoreDto> storelist(){
        List<StoreEntity> dlist = storeRepository.findAll();

        List<StoreDto> dtolist = new ArrayList<>();

        for( StoreEntity entity : dlist ){
            dtolist.add( entity.toDto() );
        }
        System.out.println(dtolist);

        return dtolist;
    }
}
