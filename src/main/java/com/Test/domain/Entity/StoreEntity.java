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
    private int storeno;

    @Column(nullable = false)//not null
    private String storename;

    @OneToMany(mappedBy = "storeEntity" )
    @Builder.Default
    @ToString.Exclude
    private List<SellEntity> sellEntityList = new ArrayList<>();

    public StoreDto toDto() {
        return StoreDto.builder()
                .storeno(this.storeno)
                .storename(this.storename)
                .build();
    }

}
