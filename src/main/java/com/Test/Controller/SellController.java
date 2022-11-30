package com.Test.Controller;

import com.Test.domain.Dto.SellDto;
import com.Test.domain.Dto.StoreDto;
import com.Test.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SellController {
    //세팅
    @Autowired
    SellService sellService;
    @GetMapping("/")
    public Resource getlist(){ return new ClassPathResource("html/Test.html"); }

    // 2. 게시물 목록 조회 [ 페이징,검색 ]
    @GetMapping("/product")
    public List<SellDto> boardlist(
            @RequestParam("sell_no") int sell_no ,  // 매장 번호
            @RequestParam("page") int page        // 현재 페이지 번호
    ){
        return sellService.boardlist( page , sell_no);
    }
    @GetMapping("/storelist")
    public List<StoreDto> storelist(){
        return sellService.storelist();

    }

    @PostMapping("/setstore")
    public boolean setstore(@RequestBody StoreDto stdto){
        System.out.println("stdto");
        System.out.println(stdto);
        return sellService.setstore(stdto);
    }

}
