package formacion.bosonit.lotrgamefx.model.beast;

import formacion.bosonit.lotrgamefx.model.Unit;

public abstract class Beast extends Unit {
    private BeastRace race;
    @Override
    public int[] attack(Unit enemy) {
        int dice = (int)(Math.ceil(Math.random()*90+1));
        int damage = dice > enemy.getArmor()
                ? dice - enemy.getArmor()
                : 0;

        return new int[]{dice, damage};
    }

    public String printBeastTitle() {
        return this.getName() + " (" + this.race.getText() + ")";
    }

    public String printBeastInfo() {
        return this.getName()
                + " ("
                + this.getRace().getText()
                + ")"
                + " (Vida:"
                + this.getHealth()
                + " | Armadura:"
                + this.getArmor()
                + ")";
    }

    public BeastRace getRace() {
        return race;
    }

    public void setRace(BeastRace race) {
        this.race = race;
    }
}
