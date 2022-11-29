package com.Test.Controller;

import com.Test.domain.Dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SellController {
    //세팅


    // 2. 게시물 목록 조회 [ 페이징,검색 ]
    @GetMapping("/sellList")
    public List<ProductDto> boardlist(
            @RequestParam("sell_no") int sell_no ,        // 카테고리 번호
            @RequestParam("page") int page ,        // 현재 페이지 번호
            @RequestParam("key") String key ,       // 검색할 필드명
            @RequestParam("keyword") String keyword // 검색할 필드내 검색할 데이터
    ){
        return boardService.boardlist( page , sell_no , key , keyword  );

    }
}
