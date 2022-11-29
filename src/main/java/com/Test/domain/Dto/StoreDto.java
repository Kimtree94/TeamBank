package com.Test.domain.Dto;

import com.Test.domain.Entity.StoreEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class StoreDto {

    private int storeno;
    private String storename;

    public StoreEntity toEntity() {
        return StoreEntity.builder()
                .storeno(this.storeno)
                .storename(this.storename)
                .build();

    }


}