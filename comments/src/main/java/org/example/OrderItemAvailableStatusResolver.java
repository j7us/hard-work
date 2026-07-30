package org.example;

/**
 * Сервис проверяет доступность отдельных товаров в заказе и их доступность для возврата.
 * Переиспользуется в нескольких пользовательских флоу для дополнительной проверки товара перед созданием заявки.
 * Требования к досутпности описаны также в Confluence
 */
@Component
@RequiredArgsConstructor
public class OrderItemAvailableStatusResolver {
    private final ReturnRepository returnRepository;

    public String getOrderItemStatus(OrderItem orderItem) {
        if (orderItem.getReturnable()) {
            return "NOT_AVAILABLE";
        }

        List<Return> returns = returnRepository.getAllByOrderItemId(orderItem.getId());

        if (!CollectionUtils.isEmpty(returns)) {
            return "NOT_AVAILABLE";
        }

        return "AVAILABLE";
    }
}
