package com.tmkim.stock.domain.orders;

import com.tmkim.stock.domain.BaseTimeEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
