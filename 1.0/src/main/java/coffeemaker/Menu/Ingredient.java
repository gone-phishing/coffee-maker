package coffeemaker.Menu;

public class Ingredient {
  String name;
  Long quantity;

  public Ingredient(String name, Long quantity) {
    this.name = name;
    this.quantity = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getQuantity() {
    return quantity;
  }

  public void setQuantity(Long quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Ingredient [name=");
    builder.append(name);
    builder.append(", quantity=");
    builder.append(quantity);
    builder.append("]");
    return builder.toString();
  }

}
