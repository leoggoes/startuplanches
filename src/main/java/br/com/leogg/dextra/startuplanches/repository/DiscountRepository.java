package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.leogg.dextra.startuplanches.models.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount,Long>{
  public Discount findByName(String name);
}
