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
    private int sellno;

    @Column(nullable = false)
    private String sellproduct;

    @Column(nullable = false)
    private String sellprice;

    @ManyToOne
    @JoinColumn(name = "storeno")
    @ToString.Exclude
    private StoreEntity storeEntity;

    public SellDto toDto() {
        return SellDto.builder()
                .sellno(this.sellno)
                .sellproduct(this.sellproduct)
                .sellprice(this.sellprice)
                .build();
    }
}
