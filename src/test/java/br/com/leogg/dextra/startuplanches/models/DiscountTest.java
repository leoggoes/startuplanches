package br.com.leogg.dextra.startuplanches.models;

import java.util.Arrays;
import br.com.leogg.dextra.startuplanches.models.Sandwitch;
import br.com.leogg.dextra.startuplanches.models.Ingredient;
import br.com.leogg.dextra.startuplanches.models.Discount;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;


public class DiscountTest {
	Ingredient hamburger = new Ingredient();
  Ingredient egg = new Ingredient();
  Ingredient cheese = new Ingredient();
	Ingredient otherCheese = new Ingredient();
  Sandwitch xegg = new Sandwitch();
	Discount percentageDiscount = new Discount();
	Discount leapDiscount = new Discount();
	Discount noDiscount = new Discount();
	Discount noDiscountEither = new Discount();

  @Before
  public void init(){
    hamburger.setName("hamburger");
    hamburger.setPrice(3.0);

    egg.setName("egg");
    egg.setPrice(0.8);

    cheese.setName("cheese");
    cheese.setPrice(1.5);

		otherCheese.setName("cheese");
    otherCheese.setPrice(1.5);

    xegg.setName("x-egg");
    xegg.getIngredients().addAll(Arrays.asList(hamburger,egg,cheese,otherCheese));

		percentageDiscount.setName("percentage test");
		percentageDiscount.setDescription("every sandwitch that has egg gets 20% "
																				+"discount");
		percentageDiscount.setDiscountMethod(Discount.DISCOUNT_METHOD_PERCENTAGE);
		percentageDiscount.setDiscountPercent(20.0);
		percentageDiscount.getIngredientsOnNames().add(egg.getName());
		percentageDiscount.getIngredientsOnMinAmount().add(1);

		leapDiscount.setName("leap test");
		leapDiscount.setDescription("for every 2 amount of cheese, the second "
															+"get 50% discount");
		leapDiscount.setDiscountMethod(Discount.DISCOUNT_METHOD_LEAP);
		leapDiscount.setDiscountPercent(50.0);
		leapDiscount.setLeapIngredientName(cheese.getName());
		leapDiscount.getIngredientsOnNames().add(cheese.getName());
		leapDiscount.getIngredientsOnMinAmount().add(2);
		leapDiscount.setLeap(2);

		noDiscount.setName("percentage test 2");
		noDiscount.setDescription("every sandwitch that has 2 eggs gets 15% "
																				+"discount");
		noDiscount.setDiscountMethod(Discount.DISCOUNT_METHOD_PERCENTAGE);
		noDiscount.setDiscountPercent(15.0);
		noDiscount.getIngredientsOnNames().add(egg.getName());
		noDiscount.getIngredientsOnMinAmount().add(2);

		noDiscountEither.setName("leap test 2");
		noDiscountEither.setDescription("for every sandwitch without hamburger, the second "
															+" of every 2 cheeses get 45% discount");
		noDiscountEither.setDiscountMethod(Discount.DISCOUNT_METHOD_LEAP);
		noDiscountEither.setDiscountPercent(45.0);
		noDiscountEither.setLeapIngredientName(cheese.getName());
		noDiscountEither.getIngredientsOffNames().add(hamburger.getName());
		noDiscountEither.setLeap(2);

  }

	@Test
	public void testDiscountRule() {
		double expectedPrice;
		xegg.setIngredientsDiscountPriceDefault();
		percentageDiscount.applyDiscount(xegg);
		expectedPrice = xegg.getPrice()*((100.0-percentageDiscount.getDiscountPercent())/100.0);
		assertEquals(expectedPrice,xegg.getDiscountPrice(),0.0001);

		xegg.setIngredientsDiscountPriceDefault();
		leapDiscount.applyDiscount(xegg);
		expectedPrice = hamburger.getPrice()+egg.getPrice()+cheese.getPrice()
			+ otherCheese.getPrice()*((100.0-leapDiscount.getDiscountPercent())/100.0);
		assertEquals(expectedPrice,xegg.getDiscountPrice(),0.0001);

		xegg.setIngredientsDiscountPriceDefault();
		noDiscount.applyDiscount(xegg);
		assertEquals(xegg.getPrice(),xegg.getDiscountPrice(),0.0001);

		xegg.setIngredientsDiscountPriceDefault();
		noDiscountEither.applyDiscount(xegg);
		assertEquals(xegg.getPrice(),xegg.getDiscountPrice(),0.0001);

		Discount nowThereIsDiscount = noDiscountEither;
		xegg.getIngredients().remove(hamburger);

		xegg.setIngredientsDiscountPriceDefault();
		nowThereIsDiscount.applyDiscount(xegg);
		expectedPrice = egg.getPrice() + cheese.getPrice()
			+ otherCheese.getPrice()*((100.0-nowThereIsDiscount.getDiscountPercent())/100.0);
		assertEquals(expectedPrice,xegg.getDiscountPrice(),0.0001);
	}

}
