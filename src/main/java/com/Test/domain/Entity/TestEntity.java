package com.Test.domain.Entity;

import com.Test.domain.Dto.TestDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Table(name = "Test")
@Entity
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sell_no;
    @Column(nullable = false)
    private String sell_list;
    @Column(nullable = false)
    private int sell_price;
    @Column(nullable = false)
    private String sell_updateday;

    public TestDto toDto() {
        return TestDto.builder()
                .sell_no(this.sell_no)
                .sell_list(this.sell_list)
                .sell_price(this.sell_price)
                .sell_updateday(this.sell_updateday)
                .build();
    }
}
