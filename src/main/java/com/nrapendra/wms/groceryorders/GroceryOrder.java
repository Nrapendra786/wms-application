package com.nrapendra.wms.groceryorders;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "grocery_order")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GroceryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "local_date")
    private LocalDate localDate;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> items = new HashMap<>();

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Item {
    private String itemName;
    private Long itemQuantity;
}