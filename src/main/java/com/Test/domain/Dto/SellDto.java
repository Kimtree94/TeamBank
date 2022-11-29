package com.Test.domain.Dto;

import com.Test.domain.Entity.SellEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class SellDto {
    //세팅
    private int sell_no;
    private String sell_product;
    private String sell_price;

    public SellEntity toEntity() {
        return SellEntity.builder()
                .sell_no(this.sell_no)
                .sell_product(this.sell_product)
                .sell_price(this.sell_price)
                .build();


    }

}
