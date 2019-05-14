package br.com.leogg.dextra.startuplanches.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.leogg.dextra.startuplanches.repository.MenuRepoService;
import br.com.leogg.dextra.startuplanches.repository.IngredientRepoService;
import br.com.leogg.dextra.startuplanches.models.Menu;
import br.com.leogg.dextra.startuplanches.models.Sandwitch;
import br.com.leogg.dextra.startuplanches.models.Ingredient;
import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuRepoService menuRepoService;

    @Autowired
    IngredientRepoService ingredientRepoService;

    @GetMapping("/")
    public ModelAndView index() {
        Menu menu = menuRepoService.findById(1L).get();
        List<Ingredient> ingredientList  = ingredientRepoService.findAll();

        menu.getSandwitches().forEach(sandwitch->{
          sandwitch.setIngredientsDiscountPriceDefault();
          menu.getDiscounts().forEach(discount->{
            discount.applyDiscount(sandwitch);
          });
        });

        ModelAndView mv = new ModelAndView("/get");
        mv.addObject("sandwitches", menu.getSandwitches());
        mv.addObject("discounts",menu.getDiscounts());
        mv.addObject("ingredientList",ingredientList);

        return mv;

    }

    @PostMapping("/")
    public ModelAndView posted(@RequestBody MultiValueMap<String,String> customSandwitchForm ){
      Menu menu = menuRepoService.findById(1L).get();
      List<Ingredient> ingredientList  = ingredientRepoService.findAll();

      Sandwitch customSandwitch = new Sandwitch();
      customSandwitch.setName(customSandwitchForm.getFirst("name"));
      ingredientList.forEach(ingredient->{
        if(customSandwitchForm.containsKey(ingredient.getName())){
          int amount = Integer.parseInt(customSandwitchForm.getFirst(ingredient.getName()));
          for(int i=0;i<amount;i++){
            customSandwitch.getIngredients().add(ingredient.clone());
          }
        }
      });

      menu.getSandwitches().add(customSandwitch);

      menu.getSandwitches().forEach(sandwitch->{
        sandwitch.setIngredientsDiscountPriceDefault();
        menu.getDiscounts().forEach(discount->{
          discount.applyDiscount(sandwitch);
        });
      });

      ModelAndView mv = new ModelAndView("/post");
      mv.addObject("sandwitches", menu.getSandwitches());
      mv.addObject("discounts",menu.getDiscounts());
      mv.addObject("ingredientList",ingredientList);

      return mv;
    }

}
