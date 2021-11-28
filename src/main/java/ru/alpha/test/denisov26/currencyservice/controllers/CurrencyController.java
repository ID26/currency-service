package ru.alpha.test.denisov26.currencyservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;
import ru.alpha.test.denisov26.currencyservice.services.CurrencyService;

import java.util.Map;

@RestController
@RequestMapping("/rate")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public ResponseEntity<CurrencyDto> getCurrencyRates(@RequestParam String currencyName) {
        ResponseEntity<CurrencyDto> response = currencyService.getRate(currencyName);


        return response;
    }

//    @GetMapping
    public ResponseEntity getGifThenRateChange() {
        return ResponseEntity.ok("");
    }
}
