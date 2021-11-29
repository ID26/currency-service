package ru.alpha.test.denisov26.currencyservice.feignservices;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;

import java.time.LocalDate;

@FeignClient(url = "${open_exchange.url}", name = "openExchange")
public interface OpenExchange {

    @GetMapping("/latest.json")
    ResponseEntity<CurrencyDto> getCurrencyRates(@RequestParam(name = "app_id") String appId);

    @GetMapping("/historical/{localDate}.json")
    ResponseEntity<CurrencyDto> getCurrencyRatesByDate(
            @PathVariable("localDate") String localDate,
            @RequestParam("app_id") String appId);
}


//https://openexchangerates.org/api/historical/2012-07-10.json?app_id=YOUR_APP_ID