package com.Test.domain.Entity;

import com.Test.domain.Dto.StoreDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store")
public class StoreEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_no;

    @Column(nullable = false)//not null
    private String store_name;

    @OneToMany
    @Builder.Default
    private List<SellEntity> sellEntityList = new ArrayList<>();

    public StoreDto toDto() {
        return StoreDto.builder()
                .store_no(this.store_no)
                .store_name(this.store_name)
                .build();
    }

}
