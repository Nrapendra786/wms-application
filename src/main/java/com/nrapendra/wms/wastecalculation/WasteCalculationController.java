package com.nrapendra.wms.wastecalculation;

import com.nrapendra.wms.platesales.PlateSales;
import com.nrapendra.wms.platesales.PlateSalesRepository;
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

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@Slf4j
public class WasteCalculationController {

    private final WasteCalculationRepository wasteCalculationRepository;

    @GetMapping(value = "/wasteCalculation/create/")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Successful",  content = { @Content( mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(schema = @Schema(),mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = { @Content(schema = @Schema(),mediaType = "application/json") })
    })
    public ResponseEntity<?> createPlateSales(){
        var plateSales = WasteCalculation.builder().id(1L).build();
        wasteCalculationRepository.save(plateSales);
        return new ResponseEntity<>(plateSales, HttpStatus.CREATED);
    }

}
