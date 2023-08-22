package com.tmkim.stock.service.stock;

import com.tmkim.stock.domain.stock.Stock;
import com.tmkim.stock.domain.stock.StockRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceTest{

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @After
    public void cleanup() {
        stockRepository.deleteAll();
    }

    @Test
    public void 재고감소() {
        stockRepository.save(new Stock(1L, 1000L));

        stockService.decrease(1L, 100L);
        Stock stock = stockRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("stock doesn't exist"));
        Assertions.assertThat(stock.getQuantity()).isEqualTo(900);
    }

}