package com.Test.domain.Dto;

import com.Test.domain.Entity.TestEntity;
import lombok.*;

import javax.persistence.Table;


@AllArgsConstructor@NoArgsConstructor
@ToString@Builder@Getter@Setter
public class TestDto {
private String sell_list;
    private int sell_no;
    private int sell_price;
    private String sell_updateday;


    public TestEntity toEntity() {
        return TestEntity.builder()
                .sell_no(this.sell_no)
                .sell_list(this.sell_list)
                .sell_price(this.sell_price)
                .sell_updateday(this.sell_updateday)
                .build();
    }
}

/*    판매목록 리스트
    sell_list
            sell_no
    sell_product
            sell_price
    sell_nowday
            sell_updateday


    매장
            store_no
    store_name
            store_nowday
    store_updateda*/