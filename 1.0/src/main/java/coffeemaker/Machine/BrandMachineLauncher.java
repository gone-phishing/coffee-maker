package coffeemaker.Machine;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import coffeemaker.Menu.Beverage;
import coffeemaker.Menu.Ingredient;

public class BrandMachineLauncher {
    private BrandMachine brandMachine;
    static final String payload = "{  \"machine\": {    \"outlets\": {      \"count_n\": 3    },    \"total_items_quantity\": {      \"hot_water\": 500,      \"hot_milk\": 500,      \"ginger_syrup\": 100,      \"sugar_syrup\": 100,      \"tea_leaves_syrup\": 100    },    \"beverages\": {      \"hot_tea\": {        \"hot_water\": 200,        \"hot_milk\": 100,        \"ginger_syrup\": 10,        \"sugar_syrup\": 10,        \"tea_leaves_syrup\": 30      },      \"hot_coffee\": {        \"hot_water\": 100,        \"ginger_syrup\": 30,        \"hot_milk\": 400,        \"sugar_syrup\": 50,        \"tea_leaves_syrup\": 30      },      \"black_tea\": {        \"hot_water\": 300,        \"ginger_syrup\": 30,        \"sugar_syrup\": 50,        \"tea_leaves_syrup\": 30      },      \"green_tea\": {        \"hot_water\": 100,        \"ginger_syrup\": 30,        \"sugar_syrup\": 50,        \"green_mixture\": 30      },    }  }}";
    
    public BrandMachine launch() {
        try {
            if(brandMachine == null) {
                this.brandMachine = getBrandMachine();
            }
        } catch (Exception e) {
            
        }
        
        return this.brandMachine;
    }

    private static BrandMachine getBrandMachine() throws Exception{
        JSONObject obj = (JSONObject) new JSONParser().parse(payload);
        JSONObject machineObject = (JSONObject) obj.get("machine");
        JSONObject ingredientsObject = (JSONObject) machineObject.get("total_items_quantity");
        BrandMachine machine = new BrandMachine();
        ingredientsObject
            .forEach((k, v) -> machine.addIngredient(new Ingredient((String) k, (Long) v)));

        JSONObject beveragesObject = (JSONObject) machineObject.get("beverages");
        beveragesObject.forEach((k, v) -> machine.addBeverage(getBeverage(k, v)));
        return machine;
    }

    private static Beverage getBeverage(Object k, Object v) {
        String beverageName = (String) k;
        List<Ingredient> ingredients = new ArrayList<>();
        JSONObject ingredientsObject = (JSONObject) v;
        ingredientsObject.forEach((x, y) -> ingredients.add(new Ingredient((String) x, (Long) y)));
        return new Beverage(beverageName, ingredients);
      }
}