package com.neighborpil.unittesting.unittesting.data;

import com.neighborpil.unittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
