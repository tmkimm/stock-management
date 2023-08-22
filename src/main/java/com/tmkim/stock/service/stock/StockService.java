package com.tmkim.stock.service.stock;

import com.tmkim.stock.domain.stock.Stock;
import com.tmkim.stock.domain.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        // stock 재고 조회
        // 재고 감소
        // 갱신된 값 저장
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("stock doesn't exist"));
        stock.decrease(quantity);
        stockRepository.saveAndFlush(stock);
    }
}
