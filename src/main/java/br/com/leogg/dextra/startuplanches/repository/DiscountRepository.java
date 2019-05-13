package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.leogg.dextra.startuplanches.models.Discount;

public interface DiscountRepository extends JpaRepository<Discount,Long>{
  public Discount findByName(String name);
}
