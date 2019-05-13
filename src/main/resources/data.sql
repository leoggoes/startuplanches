insert into MENU(ID,NAME) values(1,'MainMenu')

insert into INGREDIENT(ID,NAME,PRICE) values(1,'Alface',0.4)

insert into INGREDIENT(ID,NAME,PRICE) values(2,'Bacon',2.0)

insert into INGREDIENT(ID,NAME,PRICE) values(3,'Hambúrguer de Carne',3.0)

insert into INGREDIENT(ID,NAME,PRICE) values(4,'Ovo',0.8)

insert into INGREDIENT(ID,NAME,PRICE) values(5,'Queijo',1.5)

insert into SANDWITCH(ID,NAME) values(1,'X-Bacon')

insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(1,2)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(1,3)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(1,5)

insert into SANDWITCH(ID,NAME) values(2,'X-Burger')

insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(2,3)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(2,5)

insert into SANDWITCH(ID,NAME) values(3,'X-Egg')

insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(3,4)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(3,3)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(3,5)

insert into SANDWITCH(ID,NAME) values(4,'X-Egg Bacon')

insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(4,4)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(4,2)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(4,3)
insert into SANDWITCH_INGREDIENTS(SANDWITCH_ID,INGREDIENTS_ID) values(4,5)

insert into MENU_SANDWITCHES(MENU_ID,SANDWITCHES_ID) values(1,1)
insert into MENU_SANDWITCHES(MENU_ID,SANDWITCHES_ID) values(1,2)
insert into MENU_SANDWITCHES(MENU_ID,SANDWITCHES_ID) values(1,3)
insert into MENU_SANDWITCHES(MENU_ID,SANDWITCHES_ID) values(1,4)

insert into DISCOUNT(ID,DESCRIPTION,DISCOUNT_METHOD,DISCOUNT_PERCENT,LEAP,LEAP_INGREDIENT_NAME,NAME) values(1,'Se o lanche tem alface e não tem bacon, ganha 10% de desconto.','PERCENTAGE',10.0,NULL,NULL,'Light')
insert into INGREDIENT_ON(ID,NAME) values(1,'Alface')
insert into INGREDIENT_ON_MIN(ID,AMOUNT) values(1,1)
insert into INGREDIENT_OFF(ID,NAME) values(1,'Bacon')

insert into DISCOUNT(ID,DESCRIPTION,DISCOUNT_METHOD,DISCOUNT_PERCENT,LEAP,LEAP_INGREDIENT_NAME,NAME) values(2,'A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante...','LEAP',100.0,3,'Hambúrguer de Carne','Muita Carne')
insert into INGREDIENT_ON(ID,NAME) values(2,'Hambúrguer de Carne')
insert into INGREDIENT_ON_MIN(ID,AMOUNT) values(2,3)

insert into DISCOUNT(ID,DESCRIPTION,DISCOUNT_METHOD,DISCOUNT_PERCENT,LEAP,LEAP_INGREDIENT_NAME,NAME) values(3,'A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, o cliente pagará 4. Assim por diante...','LEAP',100.0,3,'Queijo','Muito Queijo')
insert into INGREDIENT_ON(ID,NAME) values(3,'Queijo')
insert into INGREDIENT_ON_MIN(ID,AMOUNT) values(3,3)

insert into MENU_DISCOUNTS(MENU_ID,DISCOUNTS_ID) values(1,1)
insert into MENU_DISCOUNTS(MENU_ID,DISCOUNTS_ID) values(1,2)
insert into MENU_DISCOUNTS(MENU_ID,DISCOUNTS_ID) values(1,3)