package br.com.leogg.dextra.startuplanches.repository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import java.util.Optional;
import java.util.List;
import br.com.leogg.dextra.startuplanches.models.Discount;

@Service
public class DiscountRepoService {
  @Autowired
  private DiscountRepository repository;

  public Discount findByName(String name){
    return repository.findByName(name);
  }

  public Optional<Discount> findById(Long id){
    return repository.findById(id);
  }

  public List<Discount> findAll(){
    return repository.findAll(/*new Sort(Sort.Direction.ASC,"id")*/);
  }

  public Discount save(Discount discount){
    return repository.saveAndFlush(discount);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }
}
