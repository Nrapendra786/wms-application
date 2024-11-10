package com.nrapendra.wms.groceryorders;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroceryOrderRepository extends ListCrudRepository<GroceryOrder,Long> {

    @Query(nativeQuery=true, value = "SELECT ID,LOCAL_DATE,ITEMS FROM GROCERY_ORDER g where g.LOCAL_DATE=:localDate" )
    List<GroceryOrder> findByDate(@Param("localDate") String localDate);

}
