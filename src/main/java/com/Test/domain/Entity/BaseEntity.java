package com.Test.domain.Entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter@Setter // 롬복
@MappedSuperclass // 상속받을 경우 자식 클래스에게 매핑 정보를 전달합니다.
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity{
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime Bdate;
    @LastModifiedDate
    private  LocalDateTime udate;
}
