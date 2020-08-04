package com.food.app.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity  implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 2368085762420797845L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    private String name;
    
    private String city;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "restaurant")
    private Set<FoodItemEntity> foods=new HashSet<>();


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<FoodItemEntity> getFoods() {
		return foods;
	}

	public void setFoods(Set<FoodItemEntity> foods) {
		this.foods = foods;
	}

}
