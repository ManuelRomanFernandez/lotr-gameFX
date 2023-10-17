package formacion.bosonit.lotrgamefx.view;

import formacion.bosonit.lotrgamefx.model.Unit;
import formacion.bosonit.lotrgamefx.model.beast.Beast;
import formacion.bosonit.lotrgamefx.model.hero.Hero;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class GameView {
    public void displayGameStart(TextArea pane) {
        Platform.runLater(() -> {
            pane.appendText(("*".repeat(85)) + "\n");
            pane.appendText("¡Comienza la batalla por la Tierra Media!\n");
            pane.appendText(("*".repeat(85)) + "\n\n");
        });
    }

    public void displayTurn(TextArea pane, int turn) {
        Platform.runLater(() -> {
            pane.appendText(("*".repeat(85)) + "\n");
            pane.appendText("Turno " + turn + "\n");
            pane.appendText(("*".repeat(85)) + "\n");
        });
    }

    public void displayFightWarning(TextArea pane, Hero hero, Beast beast) {
        Platform.runLater(() -> {
            pane.appendText("Lucha entre " + hero.printUnitStats() + " y " + beast.printUnitStats() + "\n");
        });

    }

    public void displayFightFirstAttack(TextArea pane, Unit attacker, Unit defender, int[] attack) {
        Platform.runLater(() -> {
            pane.appendText(attacker.getName() + " ataca primero, saca " + attack[0] + " y le quita " + attack[1] + " puntos de vida a " + defender.getName() + "\n");
        });

    }
    public void displayFightSecondAttack(TextArea pane, Unit attacker, Unit defender, int[] attack) {
        Platform.runLater(() -> {
            pane.appendText(attacker.getName() + " responde, saca " + attack[0] + " y le quita " + attack[1] + " puntos de vida a " + defender.getName() + "\n\n");
        });
    }

    public void displayHeroDeath(TextArea pane, Hero hero) {
        Platform.runLater(() -> {
            pane.appendText("¡Muere " + hero.printHeroTitle() + "!\n\n");
        });
    }

    public void displayBeastDeath(TextArea pane, Beast beast) {
        Platform.runLater(() -> {
            pane.appendText("¡Muere " + beast.printBeastTitle() + "!\n\n");
        });
    }

    public void displayHeroWin(TextArea pane) {
        Platform.runLater(() -> {
            pane.appendText(("*".repeat(85)) + "\n");
            pane.appendText("¡Victoria de los Héroes!\n");
            pane.appendText("La Tierra Media ha sido salvada\n");
            pane.appendText(("*".repeat(85)) + "\n");
        });
    }

    public void displayBeastWin(TextArea pane) {
        Platform.runLater(() -> {
            pane.appendText(("*".repeat(85)) + "\n");
            pane.appendText("¡Victoria de las Bestias!\n");
            pane.appendText("La Tierra Media ha sido condenada\n");
            pane.appendText(("*".repeat(85)) + "\n");
        });
    }
}
