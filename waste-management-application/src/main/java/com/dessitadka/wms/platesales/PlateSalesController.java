package com.dessitadka.wms.platesales;

import com.dessitadka.wms.groceryorders.GroceryOrder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;

@RestController(value = "/api/v1/plateSales")
@RequiredArgsConstructor
@Slf4j
public class PlateSalesController {

    private final PlateSalesRepository plateSalesRepository;

    @PostMapping("/create/")
    public ResponseEntity<?> createGroceryOrder(){
        var plateSales = PlateSales.builder().id(1L).plateSales(new HashMap<>()).localDate(LocalDate.now()).build();
        plateSalesRepository.save(plateSales);
        return new ResponseEntity<>(plateSales, HttpStatus.CREATED);
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> getGroceryOrder(@PathVariable LocalDate date){
        var groceryOrder = GroceryOrder.builder().id(1L).groceryOrder(new HashMap<>()).request("Request").build();
        return new ResponseEntity<>(groceryOrder, HttpStatus.CREATED);
    }

}
