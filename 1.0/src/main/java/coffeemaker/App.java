package coffeemaker;

import coffeemaker.Machine.BrandMachine;
import coffeemaker.Machine.BrandMachineLauncher;
import coffeemaker.Menu.Beverage;
import coffeemaker.Menu.MenuChoices;


public class App 
{
    
    public static void main( String[] args )
    {
        BrandMachine brandMachine = new BrandMachineLauncher().launch();
        System.out.println(brandMachine);
        // Beverage black_tea = takeAway(brandMachine, MenuChoices.black_tea);
        // black_tea.pour();
        
        
        for(Beverage b:brandMachine.getBeverages()) {
//        	System.out.println(b.getName());
        	if(takeAway(brandMachine, b)) {
        		brandMachine.pour(b);
        	}
//        	System.out.println(brandMachine.getIngredients());
        	
        }

    }


     private static boolean takeAway(BrandMachine brandMachine, Beverage b) {
          try{
              brandMachine.makeBeverage(b);
              System.out.println(b.getName() +" can be made as of now");
              return true;
          } catch (Exception e) {
              System.out.println(b.getName() +" can not be made as of now");
              return false;
          }
        
     }
}
