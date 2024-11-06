package com.dessitadka.wms.wastecalculation;

import com.dessitadka.wms.platesales.PlateSales;
import org.springframework.data.repository.ListCrudRepository;

public interface WasteCalculationRepository extends ListCrudRepository<PlateSales,Long> {


}
