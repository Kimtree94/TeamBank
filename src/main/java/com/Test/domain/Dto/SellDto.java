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
    private int sellno;
    private String sellproduct;
    private String sellprice;
    private int startbtn;
    private int endbtn;

    public SellEntity toEntity() {
        return SellEntity.builder()
                .sellno(this.sellno)
                .sellproduct(this.sellproduct)
                .sellprice(this.sellprice)
                .build();


    }

}