package com.testing.poc.deal.services;

import com.testing.poc.deal.Repository.IDealRepository;
import com.testing.poc.deal.model.Deal;

import java.util.Objects;

public class DealService {

    private IDealRepository dealRepository;

    public DealService(IDealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public Deal create(Deal deal) {
        if (Objects.isNull(deal) || Objects.isNull(deal.getId())) {
            return null;
        }

        return dealRepository.save(deal);
    }


    public Deal findById(String dealId) throws Exception {
        if (Objects.isNull(dealId)) {
            throw new Exception();
        }
        return dealRepository.findById(dealId);
    }
}
