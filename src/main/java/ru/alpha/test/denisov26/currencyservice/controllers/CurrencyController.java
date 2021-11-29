package ru.alpha.test.denisov26.currencyservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alpha.test.denisov26.currencyservice.dto.CurrencyDto;
import ru.alpha.test.denisov26.currencyservice.services.CurrencyService;

import java.time.LocalDate;

@RestController
@RequestMapping("/rate")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final String localDate = LocalDate.now().minusDays(1).toString();

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping/*("date")*/
    public ResponseEntity<CurrencyDto> getCurrencyRates(/*@RequestParam LocalDate localDate*/) {
        ResponseEntity<CurrencyDto> response = currencyService.getRate(localDate);


        return response;
    }

//    @GetMapping
    public ResponseEntity getGifThenRateChange() {
        return ResponseEntity.ok("");
    }
}
