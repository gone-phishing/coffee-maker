package coffeemaker.Machine;

import java.util.ArrayList;
import java.util.List;

import coffeemaker.Menu.Beverage;
import coffeemaker.Menu.Ingredient;


public class BrandMachine {
  List<Ingredient> ingredients = new ArrayList<>();
  List<Beverage> beverages = new ArrayList<>();

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public void addIngredient(Ingredient ingredient) {
    ingredients.add(ingredient);
  }

  public List<Beverage> getBeverages() {
    return beverages;
  }

  public void setBeverages(List<Beverage> beverages) {
    this.beverages = beverages;
  }

  public void addBeverage(Beverage beverage) {
    beverages.add(beverage);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Machine [ingredients=");
    builder.append(ingredients);
    builder.append(", beverages=");
    builder.append(beverages);
    builder.append("]");
    return builder.toString();
  }

	public void makeBeverage(Beverage b) throws Exception{
		// TODO Auto-generated method stub
		for(Ingredient i:b.getIngredients()) {
			for(Ingredient availableI:ingredients) {
				if(availableI.getName().equals(i.getName())) {
					if(i.getQuantity() > availableI.getQuantity())
						throw new Exception();
				}
			}
		}
	}

	public void pour(Beverage b) {
		// TODO Auto-generated method stub
		for(Ingredient i:b.getIngredients()) {
			for(Ingredient availableI:ingredients) {
				if(availableI.getName().equals(i.getName())) {
					
//					System.out.println(availableI.getName()+" "+i.getName()+" "+(availableI.getQuantity()-i.getQuantity()));
					availableI.setQuantity(availableI.getQuantity()-i.getQuantity());
				}
			}
		}
	}
}
