package com.nrapendra.wms.platesales;

import com.nrapendra.wms.groceryorders.GroceryOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlateSalesRepository extends ListCrudRepository<PlateSales,Long> {

    @Query(nativeQuery=true, value = "SELECT ID,LOCAL_DATE,SALES_RECORD FROM PLATE_SALES g where g.LOCAL_DATE=:localDate" )
    List<PlateSales> findByDate(@Param("localDate") String localDate);

}
