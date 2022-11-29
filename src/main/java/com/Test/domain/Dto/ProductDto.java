package com.Test.domain.Dto;

import com.Test.domain.Entity.ProductEntity;


import lombok.*;


@AllArgsConstructor@NoArgsConstructor
@ToString@Builder@Getter@Setter
public class ProductDto {


    //세팅
    private int sell_no;            // 판매목록번호
    private String sell_list;      // 판매목록리스트
    private String sell_product;      // 판매제품명
    private int sell_price;      // 판매된가격
    private String sell_nowday;      // 판매제품생성날짜/시간
    private String sell_updateday;      // 판매제품수정날짜/시간
    private int startbtn;
    private int endbtn;



    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .sell_no(this.sell_no)
                .sell_list(this.sell_list)
                .sell_price(this.sell_price)
                .sell_updateday(this.sell_updateday)
                .build();
    }
}
