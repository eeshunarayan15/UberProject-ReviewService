package com.eeshu.uberreviewservice.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@MappedSuperclass//This annotaiton handles the inheritance in spiring data jpa

@EntityListeners(AuditingEntityListener.class)
public  abstract  class BaseModel {
    //this class is abstract we don't want any to make object of this class

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;
    @Column(nullable = false)
    @CreatedDate
    protected Date createdAt;
    @Column(nullable = false)
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;
}
