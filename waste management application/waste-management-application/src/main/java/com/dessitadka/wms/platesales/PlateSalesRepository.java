package com.dessitadka.wms.platesales;

import com.dessitadka.wms.groceryorders.GroceryOrder;
import org.springframework.data.repository.ListCrudRepository;

public interface PlateSalesRepository extends ListCrudRepository<PlateSales,Long> {
}
