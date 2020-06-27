package com.prodprice.prodprice_service.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@Entity
@Table(schema = "prod_price", name = "price")
public class Price
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @Getter
    @Setter
    private Product product_owner;

    @NotNull
    @Getter
    @Setter
    private Date date_from;

    @NotNull
    @Getter
    @Setter
    private Date date_to;

    @Getter
    @Setter
    BigDecimal price;

    @AssertTrue (message= "The from date should be before the to date.")
    private boolean isDateFromBeforeDateTo() {
        return date_from.before(date_to);
    }
}
