package br.com.leogg.dextra.startuplanches.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

//Not the UI Menu, the food Menu
@Entity
@Table(name="menu")
public class Menu{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;
  @OneToMany(cascade=CascadeType.PERSIST)
  private List<Sandwitch> sandwitches;
  @OneToMany(cascade=CascadeType.PERSIST)
  private List<Discount> discounts;

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
	* Returns value of sandwitches
	* @return
	*/
	public List<Sandwitch> getSandwitches() {
		return sandwitches;
	}

	/**
	* Sets new value of sandwitches
	* @param
	*/
	public void setSandwitches(List<Sandwitch> sandwitches) {
		this.sandwitches = sandwitches;
	}
}
