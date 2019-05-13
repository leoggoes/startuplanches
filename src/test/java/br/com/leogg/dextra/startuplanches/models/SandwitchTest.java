package br.com.leogg.dextra.startuplanches.models;

import java.util.Arrays;
import br.com.leogg.dextra.startuplanches.models.Sandwitch;
import br.com.leogg.dextra.startuplanches.models.Ingredient;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;


public class SandwitchTest {
  Ingredient hamburger = new Ingredient();
  Ingredient egg = new Ingredient();
  Ingredient cheese = new Ingredient();
  Sandwitch xegg = new Sandwitch();

  @Before
  public void init(){
    hamburger.setName("hamburger");
    hamburger.setPrice(3.0);

    egg.setName("egg");
    egg.setPrice(0.8);

    cheese.setName("cheese");
    cheese.setPrice(1.5);

    xegg.setName("x-egg");
    xegg.getIngredients().addAll(Arrays.asList(hamburger,egg,cheese));
  }

	@Test
	public void testSandwitchPrice() {
    double price = hamburger.getPrice()+egg.getPrice()+cheese.getPrice();

    assertEquals(price, xegg.getPrice(), 0.0001);
	}

}
