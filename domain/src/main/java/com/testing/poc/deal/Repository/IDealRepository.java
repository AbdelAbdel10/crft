package com.testing.poc.deal.Repository;

import com.testing.poc.deal.model.Deal;

public interface IDealRepository {
    Deal save(Deal deal);

    Deal findById(String dealId);
}
