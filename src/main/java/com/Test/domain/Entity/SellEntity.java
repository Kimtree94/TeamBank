package com.Test.domain.Entity;


import com.Test.domain.Dto.SellDto;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name = "sell_list")
@Entity
public class SellEntity extends BaseEntity {
    //세팅

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sell_no;

    @Column(nullable = false)
    private String sell_product;

    @Column(nullable = false)
    private String sell_price;

    public SellDto toDto() {
        return SellDto.builder()
                .sell_no(this.sell_no)
                .sell_product(this.sell_product)
                .sell_price(this.sell_price)
                .build();
    }
}
