package com.prodprice.prodprice_service.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RequiredArgsConstructor
@Entity
@Table(schema = "prod_price", name = "product")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotNull
    @Size(min = 3, max = 100, message = "Product name should be min 3 characters long and maximum of 100 chars.")
    @Getter
    @Setter
    private String prod_name;

    @Size( max = 100, message = "Product description should be no more than 100 characters.")
    @Getter
    @Setter
    private String prod_desc;

    @NotNull
    @OneToMany(mappedBy = "product_owner", fetch = FetchType.LAZY)
    @Getter
    @Setter
    private List<Price> prices;

    @Getter
    @Setter
    private int scu;
}
