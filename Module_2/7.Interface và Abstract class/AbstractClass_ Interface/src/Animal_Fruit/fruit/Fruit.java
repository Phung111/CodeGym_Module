package Animal_Fruit.fruit;

import Animal_Fruit.edible.Edible;

public abstract class Fruit implements Edible {

    @Override
    public String howtoEat() {
        return "cho vao mom";
    }

}
