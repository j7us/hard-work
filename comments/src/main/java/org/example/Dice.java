package org.example;

import java.util.List;

/**
 * Компонент ищет скидки для каждого sku, приходящем в запросе.
 * Мы рассчитываем на договор между командами и то, что загрузка данных по самим скидкам и A/B тестам загружена командой
 * seller через стороннюю систему
 */
@Component
@RequiredArgsConstructorr
public class Dice {
    private final DiscCash discCash;

    public List<Discounts> getDiscountForSku(Set<Sku> sku) {
        List<Discounts> disc;
        try {
            disc = sku.stream().map(discCash::findByIdz).toList();
        } catch (Exception e ) {
            meterRegistry.incNewDice();
        }

        return disc;
    }
}
