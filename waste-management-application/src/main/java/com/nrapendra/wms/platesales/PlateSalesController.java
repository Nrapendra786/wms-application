package com.nrapendra.wms.platesales;

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
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PlateSalesController {

    private final PlateSalesRepository plateSalesRepository;

    @PostMapping(value = "/plateSales/create/")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Successful",  content = { @Content( mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(),mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema(),mediaType = "application/json") })
    })
    public ResponseEntity<?> createPlateSales(@RequestParam("plateSales") String platesSale){
        var plateSales = PlateSales.builder().salesRecord(mapPlateSalesToMap(platesSale)).localDate(LocalDate.now()).build();
        plateSalesRepository.save(plateSales);
        return new ResponseEntity<>(plateSales, HttpStatus.CREATED);
    }

    @GetMapping(value = "/plateSales/{date}")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Successful",  content = { @Content( mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(),mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema(),mediaType = "application/json") })
    })
    public ResponseEntity<?> getPlateSales(@PathVariable LocalDate date){
        var plateSales = plateSalesRepository.findByDate(String.valueOf(date));
        return new ResponseEntity<>(plateSales, HttpStatus.OK);
    }

    private Map<String,String> mapPlateSalesToMap(String items){
        return new Gson().fromJson(items,Map.class);
    }

}
