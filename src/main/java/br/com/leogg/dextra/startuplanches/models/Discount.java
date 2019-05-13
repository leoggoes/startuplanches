package br.com.leogg.dextra.startuplanches.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ElementCollection;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="discount")
public class Discount{
  public static final String DISCOUNT_METHOD_PERCENTAGE = "PERCENTAGE";
  public static final String DISCOUNT_METHOD_LEAP = "LEAP";

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private String discountMethod;
  private Double discountPercent;
  private Integer leap;
  private String leapIngredientName;

  @ElementCollection
  @CollectionTable(name="ingredient_on", joinColumns=@JoinColumn(name="id"))
  @Column(name="name")
  private List<String> ingredientsOnNames = new ArrayList<>();
  @ElementCollection
  @CollectionTable(name="ingredient_on_min", joinColumns=@JoinColumn(name="id"))
  @Column(name="amount")
  private List<Integer> ingredientsOnMinAmount = new ArrayList<>();;
  @ElementCollection
  @CollectionTable(name="ingredient_off", joinColumns=@JoinColumn(name="id"))
  @Column(name="name")
  private Set<String> ingredientsOffNames = new HashSet<>();

  //Method that applies (or not) the discount to sandwitches' discountPrice field
  public void applyDiscount(Sandwitch sandwitch){
    if(isElegible(sandwitch)){
      switch(discountMethod){
        case DISCOUNT_METHOD_PERCENTAGE:{
          discountPercentage(sandwitch);
          break;
        }
        case DISCOUNT_METHOD_LEAP:{
          discountLeapFree(sandwitch);
          break;
        }
      }
    }
  }

  //applies the percentage discount to all sandwitch ingredients
  private void discountPercentage(Sandwitch sandwitch){
      final double discountMultiplier = (100.0 - discountPercent)/100.0;
      sandwitch.getIngredients().forEach(ingredient->{
        ingredient.setDiscountPrice(ingredient.getDiscountPrice()
          * discountMultiplier);
      });
  }

  //applies the ingredient discount to specific sandwitch ingredients every leap
  private void discountLeapFree(Sandwitch sandwitch){
      final double discountMultiplier = (100.0 - discountPercent)/100.0;
      final int leapIndex = leap - 1;
      int[] i = new int[1];
      i[0]=0;
      sandwitch.getIngredients().stream()
          .filter(ingredient->ingredient.getName().equalsIgnoreCase(leapIngredientName))
          .forEach(ingredient->{
            if(i[0]==leapIndex){
              i[0]=0;
              ingredient.setDiscountPrice(ingredient.getDiscountPrice()
                * discountMultiplier);
            }else{
              i[0]++;
            }
          });
  }

  /*verifies that the sandwitch has the needed amount of ingredients
  and/or doesn't have the rejected ingredients to the discount utilization*/
  private boolean isElegible(Sandwitch sandwitch){
    return sandwitch.getIngredients().stream()
        .map(ingredient->ingredient.getName())
        .filter(ingredientsOffNames::contains).count() == 0 &&
        hasIngredientsAmount(sandwitch);

  }

  //verifies if sandwitch has the needed amount of ingredients related to the discount
  private boolean hasIngredientsAmount(Sandwitch sandwitch){
    final int[] i = new int[1];
    for(i[0]=0;i[0]<ingredientsOnNames.size();i[0]++){
      if(sandwitch.getIngredients().stream().map(ingredient->ingredient.getName())
        .filter(ingredientName->ingredientName.equalsIgnoreCase(ingredientsOnNames.get(i[0])))
        .count() < ingredientsOnMinAmount.get(i[0])){
          return false;
        }
    }
    return true;
  }

	/**
	* Returns value of id
	* @return
	*/
	public Long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Long id) {
		this.id = id;
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
	* Returns value of description
	* @return
	*/
	public String getDescription() {
		return description;
	}

	/**
	* Sets new value of description
	* @param
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	* Returns value of discountMethod
	* @return
	*/
	public String getDiscountMethod() {
		return discountMethod;
	}

	/**
	* Sets new value of discountMethod
	* @param
	*/
	public void setDiscountMethod(String discountMethod) {
		this.discountMethod = discountMethod;
	}

	/**
	* Returns value of discountPercent
	* @return
	*/
	public Double getDiscountPercent() {
		return discountPercent;
	}

	/**
	* Sets new value of discountPercent
	* @param
	*/
	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	* Returns value of leap
	* @return
	*/
	public Integer getLeap() {
		return leap;
	}

	/**
	* Sets new value of leap
	* @param
	*/
	public void setLeap(Integer leap) {
		this.leap = leap;
	}

	/**
	* Returns value of leapIngredientName
	* @return
	*/
	public String getLeapIngredientName() {
		return leapIngredientName;
	}

	/**
	* Sets new value of leapIngredientName
	* @param
	*/
	public void setLeapIngredientName(String leapIngredientName) {
		this.leapIngredientName = leapIngredientName;
	}

	/**
	* Returns value of ingredientsOnNames
	* @return
	*/
	public List<String> getIngredientsOnNames() {
		return ingredientsOnNames;
	}

	/**
	* Sets new value of ingredientsOnNames
	* @param
	*/
	public void setIngredientsOnNames(List<String> ingredientsOnNames) {
		this.ingredientsOnNames = ingredientsOnNames;
	}

	/**
	* Returns value of ingredientsOnMinAmount
	* @return
	*/
	public List<Integer> getIngredientsOnMinAmount() {
		return ingredientsOnMinAmount;
	}

	/**
	* Sets new value of ingredientsOnMinAmount
	* @param
	*/
	public void setIngredientsOnMinAmount(List<Integer> ingredientsOnMinAmount) {
		this.ingredientsOnMinAmount = ingredientsOnMinAmount;
	}

	/**
	* Returns value of ingredientsOffNames
	* @return
	*/
	public Set<String> getIngredientsOffNames() {
		return ingredientsOffNames;
	}

	/**
	* Sets new value of ingredientsOffNames
	* @param
	*/
	public void setIngredientsOffNames(Set<String> ingredientsOffNames) {
		this.ingredientsOffNames = ingredientsOffNames;
	}
}
