package com.prodprice.prodprice_service.domain.entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "prod_price", name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NonNull
    @Size(min = 3, max = 100, message = "Product name should be min 3 characters long and maximum of 100 chars.")
    @Getter
    @Setter
    private String prod_name;

    @Size( max = 100, message = "Product description should be no more than 100 characters.")
    @Getter
    @Setter
    private String prod_desc;

    @NonNull
    @OneToMany(mappedBy = "product_owner", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Price> prices;

    @Getter
    @Setter
    @NonNull
    private int scu;
}
