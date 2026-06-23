package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VoidMethodTest {

    @Test
    void voidMethodDoesNothingByDefault() {
        ExternalApi api = mock(ExternalApi.class);
        doNothing().when(api).saveData("x");

        api.saveData("x");

        verify(api).saveData("x");
    }

    @Test
    void voidMethodCanBeStubbedToThrow() {
        ExternalApi api = mock(ExternalApi.class);
        doThrow(new RuntimeException("disk full")).when(api).saveData("big");

        assertThrows(RuntimeException.class, () -> api.saveData("big"));
    }
}
