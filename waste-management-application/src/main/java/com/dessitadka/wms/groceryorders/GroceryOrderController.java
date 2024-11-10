package com.dessitadka.wms.groceryorders;

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

@RestController(value = "/api/v1/groceryOrder")
@RequiredArgsConstructor
@Slf4j
public class GroceryOrderController {

    private final GroceryOrderRepository groceryOrderRepository;

    @PostMapping("/create/")
    public ResponseEntity<?> createGroceryOrder(){
        var groceryOrder = GroceryOrder.builder().id(1L).groceryOrder(new HashMap<>()).request("Request").build();
        groceryOrderRepository.save(groceryOrder);
        return new ResponseEntity<>(groceryOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> getGroceryOrder(@PathVariable LocalDate date){
        var groceryOrder = GroceryOrder.builder().id(1L).groceryOrder(new HashMap<>()).request("Request").build();
        groceryOrderRepository.save(groceryOrder);
        return new ResponseEntity<>(groceryOrder, HttpStatus.CREATED);
    }

}
