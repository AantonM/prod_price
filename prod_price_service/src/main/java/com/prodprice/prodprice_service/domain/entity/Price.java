package com.prodprice.prodprice_service.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.AssertTrue;
import java.math.BigDecimal;
import java.util.Date;

@RequiredArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @Getter
    @Setter
    private Product product_owner;

    @NonNull
    @Getter
    @Setter
    private Date date_from;

    @NonNull
    @Getter
    @Setter
    private Date date_to;

    @Getter
    @Setter
    @NonNull
    BigDecimal price;

    @AssertTrue(message = "The from date should be before the to date.")
    private boolean isDateFromBeforeDateTo()
    {
        return date_from.before(date_to);
    }
}
