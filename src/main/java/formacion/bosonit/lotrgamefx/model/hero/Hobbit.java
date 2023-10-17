package formacion.bosonit.lotrgamefx.model.hero;

import formacion.bosonit.lotrgamefx.model.Unit;
import formacion.bosonit.lotrgamefx.model.beast.Goblin;

public class Hobbit extends Hero{
    @Override
    public int[] attack(Unit enemy) {
        if (enemy instanceof Goblin){
            int dice = super.attack(enemy)[0] - 5;

            int damage = dice > enemy.getArmor()
                    ? dice - enemy.getArmor()
                    : 0;

            return new int[]{dice, damage};
        }

        return super.attack(enemy);
    }
}
