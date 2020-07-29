package ru.kalashnikov.example.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.ConverterRegistry;
import org.springframework.core.convert.support.DefaultConversionService;
import ru.kalashnikov.example.auction.converter.LocalDateToStringConverter;

@SpringBootApplication
public class AuctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionApplication.class, args);

        ConversionService conversionService = DefaultConversionService.getSharedInstance();
        ConverterRegistry converters = (ConverterRegistry) conversionService;
        converters.addConverter(new LocalDateToStringConverter());
    }

}
