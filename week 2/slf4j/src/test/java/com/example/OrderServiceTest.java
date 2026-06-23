package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private PricingClient pricing;

    @InjectMocks
    private OrderService service;

    @Test
    void totalMultipliesPriceByQty() {
        when(pricing.priceFor("widget")).thenReturn(2.5);
        assertEquals(10.0, service.total("widget", 4));
    }
}
