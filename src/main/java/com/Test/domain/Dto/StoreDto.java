package com.Test.domain.Dto;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@ToString
@Builder @Getter @Setter
public class StoreDto {
    /*  store_no
        store_name
        store_nowday
        store_updateday
*/

    //세팅
    private int store_no;  // 게시물번호
    private String store_name; // 게시물제목
    private String store_nowday;
    private String store_updateda;
}
