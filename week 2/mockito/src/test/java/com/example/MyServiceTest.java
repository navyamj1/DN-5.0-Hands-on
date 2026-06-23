package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;
class MyServiceTest {

    @Test
    void stubReturnsMockData() {
        ExternalApi api = mock(ExternalApi.class);
        when(api.getData()).thenReturn("mock data");

        MyService service = new MyService(api);
        assertEquals("mock data", service.fetchData());
    }

    @Test
    void verifyApiWasCalled() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.fetchData();
        verify(api).getData();
    }

    @Test
    void verifyCalledWithTheRightArgument() {
        ExternalApi api = mock(ExternalApi.class);
        MyService service = new MyService(api);

        service.backup("report.txt");
        verify(api).saveData(eq("report.txt"));
    }
}
