package formacion.bosonit.lotrgamefx.model.beast;

public enum BeastRace {
    Orco("Orco"),
    Trasgo("Trasgo");

    private final String text;

    BeastRace(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
