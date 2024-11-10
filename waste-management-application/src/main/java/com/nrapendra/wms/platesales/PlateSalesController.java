package com.nrapendra.wms.platesales;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController(value = "/api/v1/plateSales")
@RequiredArgsConstructor
@Slf4j
public class PlateSalesController {

    private final PlateSalesRepository plateSalesRepository;

    @PostMapping(value = "/plateSales/create/")
    public ResponseEntity<?> createPlateSales(@RequestParam("plateSales") String platesSale){
        var plateSales = PlateSales.builder().salesRecord(mapPlateSalesToMap(platesSale)).localDate(LocalDate.now()).build();
        plateSalesRepository.save(plateSales);
        return new ResponseEntity<>(plateSales, HttpStatus.CREATED);
    }

    @GetMapping(value = "/plateSales/{date}")
    public ResponseEntity<?> getPlateSales(@PathVariable LocalDate date){
        var plateSales = plateSalesRepository.findByDate(String.valueOf(date));
        return new ResponseEntity<>(plateSales, HttpStatus.OK);
    }

    private Map<String,String> mapPlateSalesToMap(String items){
        return new Gson().fromJson(items,Map.class);
    }

}
