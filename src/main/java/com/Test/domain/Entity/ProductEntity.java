package com.Test.domain.Entity;

import com.Test.domain.Dto.ProductDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Table(name = "Test")
@Entity
public class ProductEntity {

    private int startbtn;
    private int endbtn;

    public ProductDto toDto() {


    }
}
