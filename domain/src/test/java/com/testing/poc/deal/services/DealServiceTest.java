package com.testing.poc.deal.services;

import com.testing.poc.deal.Repository.IDealRepository;
import com.testing.poc.deal.model.Deal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class DealServiceTest {

    @Mock
    private IDealRepository dealRepository;

    @InjectMocks
    private DealService dealService;

    @Captor
    private ArgumentCaptor<Deal> dealArgumentCaptor;

    @Test
    public void should_create_deal() {
        Deal deal = new Deal("deal-id", "deal Name",15);
        when(dealRepository.save(deal)).thenReturn(deal);

        Deal result = dealService.create(deal);

        verify(dealRepository).save(dealArgumentCaptor.capture());
        assertNotNull(result);
        assertEquals("deal-id",dealArgumentCaptor.getValue().getId());
        assertEquals("deal Name",dealArgumentCaptor.getValue().getName());
    }

    @Test
    public void should_not_create_deal() {
        Deal deal = null;

        Deal result = dealService.create(deal);

        assertNull(result);
        verify(dealRepository,times(0)).save(deal);
    }


    @Test
    public void should_not_create_deal_when_id_is_null() {
        Deal deal = new Deal(null, "deal Name",15);

        Deal result = dealService.create(deal);

        assertNull(result);
        verify(dealRepository,times(0)).save(deal);
    }

    @Test
    public void should_return_deal_by_id() throws Exception {
        Deal deal = new Deal("deal-id", "deal Name",15);
        when(dealRepository.findById("deal-id")).thenReturn(deal);

        Deal result = dealService.findById("deal-id");

        assertNotNull(result);
        assertEquals("deal-id",result.getId());

    }

    @Test(expected = Exception.class)
    public void should_throw_exception_when_deal_id_is_null() throws Exception {
        dealService.findById(null);
    }
}
