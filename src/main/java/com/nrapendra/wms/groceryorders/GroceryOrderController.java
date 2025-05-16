package com.nrapendra.wms.groceryorders;

import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@Slf4j
public class GroceryOrderController {

    private final GroceryOrderRepository groceryOrderRepository;

    @PostMapping("/groceryOrder/create/")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Successful",  content = { @Content( mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(),mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema(),mediaType = "application/json") })
    })
    public ResponseEntity<?> createGroceryOrder(@RequestParam("items") String items){
        var groceryOrder = GroceryOrder.builder().items(mapItemsToMap(items)).localDate(LocalDate.now()).build();
        groceryOrderRepository.save(groceryOrder);
        return new ResponseEntity<>(groceryOrder, HttpStatus.CREATED);
    }

    @GetMapping("/groceryOrder/{date}")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Successful",  content = { @Content( mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(),mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema(),mediaType = "application/json") })
    })
    public ResponseEntity<?> getGroceryOrder(@PathVariable LocalDate date){
        List<GroceryOrder> groceryOrderList = groceryOrderRepository.findByDate(String.valueOf(date));
        return new ResponseEntity<>(groceryOrderList, HttpStatus.OK);
    }

    private Map<String,String> mapItemsToMap(String items){
        return new Gson().fromJson(items,Map.class);
    }

}
