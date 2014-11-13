package com.training.effective.telescopingConstructor;

/**
 * the telescoping constructor pattern works, but it is hard to write client code 
 * when there are many parameters, and harder still to read it.
 * @author jlin
 *
 */
public class NutritionFacts {
	private final int servingSize; // (mL) required
	private final int servings; // (per container) required
	private final int calories; // optional
	private final int fat; // (g) optional
	private final int sodium; // (mg) optional
	private final int carbohydrate; // (g) optional

	public NutritionFacts(int servingSize, int servings) {
		this(servingSize, servings, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories) {
		this(servingSize, servings, calories, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat) {
		this(servingSize, servings, calories, fat, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat,
			int sodium) {
		this(servingSize, servings, calories, fat, sodium, 0);
	}

	public NutritionFacts(int servingSize, int servings, int calories, int fat,
			int sodium, int carbohydrate) {
		this.servingSize = servingSize;
		this.servings = servings;
		this.calories = calories;
		this.fat = fat;
		this.sodium = sodium;
		this.carbohydrate = carbohydrate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calories;
		result = prime * result + carbohydrate;
		result = prime * result + fat;
		result = prime * result + servingSize;
		result = prime * result + servings;
		result = prime * result + sodium;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NutritionFacts other = (NutritionFacts) obj;
		if (calories != other.calories)
			return false;
		if (carbohydrate != other.carbohydrate)
			return false;
		if (fat != other.fat)
			return false;
		if (servingSize != other.servingSize)
			return false;
		if (servings != other.servings)
			return false;
		if (sodium != other.sodium)
			return false;
		return true;
	}
}
