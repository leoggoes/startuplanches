package br.com.leogg.dextra.startuplanches.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="sandwitch")
public class Sandwitch{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  @ManyToMany(cascade=CascadeType.PERSIST)
  private List<Ingredient> ingredients = new ArrayList<>();

  public double getPrice(){
    return ingredients.stream()
            .mapToDouble(ingredient->ingredient.getPrice())
            .sum();
  }

  public double getDiscountPrice(){
    return ingredients.stream()
            .mapToDouble(ingredient->ingredient.getDiscountPrice())
            .sum();
  }

  public void setIngredientsDiscountPriceDefault(){
    ingredients.forEach(ingredient->ingredient.setDiscountPrice(ingredient.getPrice()));
  }

	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets new value of name
	* @param
	*/
	public void setName(String name) {
		this.name = name;
	}

	/**
	* Returns value of ingredients
	* @return
	*/
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	* Sets new value of ingredients
	* @param
	*/
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
