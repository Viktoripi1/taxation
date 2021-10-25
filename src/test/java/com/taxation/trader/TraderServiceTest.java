package com.taxation.trader;

import com.taxation.calculation.CalculationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TraderServiceTest {

    @Mock
    private TraderRepository traderRepository;
    private CalculationService calculationService;
    private TraderService underTest;

    private Trader trader = new Trader(new BigDecimal("3.2"),new BigDecimal("2"));

    @BeforeEach
    void setUp() {
        underTest = new TraderService(traderRepository,calculationService);
        underTest.addNewTrader(trader);
    }

    @Test
    void TestGetAllTraders_success() {
        underTest.getTraders();
        //verify that this method was invoked in traderRepo
        verify(traderRepository).findAll();
    }

    @Test
    void TestGetTraderByID_success() {
        trader.setTraderId(1L);
        underTest.addNewTrader(trader);
        System.out.println(underTest.getTraders());
        Trader deliveredTrader= underTest.getTraderByID(1L);
        assertThat(deliveredTrader).isEqualTo(trader);
    }

    @Test
    void TestGetTraderByID_noTraders() {
        Trader deliveredTrader= underTest.getTraderByID(1L);
        assertThat(deliveredTrader).isNull();
    }

    @Test
    void GetTraderByID_traderDoesNotExist() {
        underTest.getTraderByID(-1L);
    }


    @Test
    void canAddNewTrader() {
        Trader trader = new Trader(new BigDecimal("3.2"),new BigDecimal("2"));
        underTest.addNewTrader(trader);
        ArgumentCaptor<Trader> argumentCaptor = ArgumentCaptor.forClass(Trader.class);
        verify(traderRepository).save(argumentCaptor.capture());
        Trader capturedTrader = argumentCaptor.getValue();
        assertThat(capturedTrader).isEqualTo(trader);
    }

    @Test
    @Disabled
    void deleteTrader() {
    }

    @Test
    @Disabled
    void updateTrader() {
    }
}