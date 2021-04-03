package coffeemaker.Menu;

import java.util.List;

public class Beverage {
  String name;
  List<Ingredient> ingredients;

  public Beverage(String name, List<Ingredient> ingredients) {
    this.name = name;
    this.ingredients = ingredients;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Beverage [name=");
    builder.append(name);
    builder.append(", ingredients=");
    builder.append(ingredients);
    builder.append("]");
    return builder.toString();
  }
}
