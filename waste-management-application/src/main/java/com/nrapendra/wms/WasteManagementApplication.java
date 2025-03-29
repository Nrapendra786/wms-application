package com.nrapendra.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.nrapendra.wms",
								"com.nrapendra.wms.groceryorders",
								"com.nrapendra.wms.platesales",
								"com.nrapendra.wms.wastecalculation"
                              })
public class WasteManagementApplication {

    // starter
	public static void main(String[] args) {
		SpringApplication.run(WasteManagementApplication.class, args);
	}
}

