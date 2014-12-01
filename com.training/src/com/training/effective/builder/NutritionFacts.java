package com.training.effective.builder;

//Builder Pattern
/**
 * Builder pattern: Consider a builder when faced with many (optional) constructor parameters
 * the Builder pattern is a good choice when designing classes 
 * whose constructors or static factories would have more than a handful of parameters
 * @author jlin
 *
 */
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	/**
	 * NutritionFacts n = new NutritionFacts.builder(123, 321).calories(3).fat(8).sodium(88).carbohydrate(33);
	 * @author jlin
	 *
	 */
	public static class Builder{

        /**
         * required fields
         */
        private final int servingSize;
        private final int servings;
        
        
		/**
		 * optional fields
		 */
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings){
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int calories){
			this.calories = calories;
			return this;
		}
		
		public Builder fat(int fat){
			this.fat = fat;
			return this;
		}
		
		public Builder sodium(int sodium){
			this.sodium = sodium;
			return this;
		}
		
		public Builder carbohydrate(int carbohydrate){
			this.carbohydrate = carbohydrate;
			return this;
		}
		
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder){
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.carbohydrate = builder.carbohydrate;
		this.sodium = builder.sodium;
	}

	public int getServingSize() {
		return servingSize;
	}

	public int getServings() {
		return servings;
	}

	public int getCalories() {
		return calories;
	}

	public int getFat() {
		return fat;
	}

	public int getSodium() {
		return sodium;
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}
}
