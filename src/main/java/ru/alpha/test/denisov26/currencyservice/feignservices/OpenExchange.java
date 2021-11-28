package ru.alpha.test.denisov26.currencyservice.feignservices;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;

@FeignClient(url = "${open_exchange.url}", name = "openExchange")
public interface OpenExchange {

    @GetMapping("/latest.json")
    ResponseEntity<CurrencyDto> getCurrencyRates(@RequestParam(name = "app_id") String appId);

}

//https://openexchangerates.org/api/latest.json?app_id=a864d23ee7fc4d328059a9114d3b6daa
//https://openexchangerates.org/api/latest.json?app_id=%7Bopen_exchange.app_id%7D