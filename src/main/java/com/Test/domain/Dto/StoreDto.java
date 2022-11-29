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

    private int store_no;
    private String store_name;

    public StoreEntity toEntity() {
        return StoreEntity.builder()
                .store_no(this.store_no)
                .store_name(this.store_name)
                .build();

    }


}