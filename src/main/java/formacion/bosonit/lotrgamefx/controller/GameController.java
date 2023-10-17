package formacion.bosonit.lotrgamefx.controller;

import formacion.bosonit.lotrgamefx.model.beast.Beast;
import formacion.bosonit.lotrgamefx.model.beast.BeastRace;
import formacion.bosonit.lotrgamefx.model.beast.Goblin;
import formacion.bosonit.lotrgamefx.model.beast.Orc;
import formacion.bosonit.lotrgamefx.model.hero.*;
import formacion.bosonit.lotrgamefx.view.GameView;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.*;

public class GameController implements Initializable {
    private GameView gameView;
    private List<Hero> heroTeam = new ArrayList<>();
    private List<Beast> beastTeam = new ArrayList<>();
    private String heroNameValue = "";
    private HeroRace heroRaceValue = HeroRace.Humano;
    private int heroHealthValue = 120;
    private int heroArmorValue = 35;
    private String beastNameValue = "";
    private BeastRace beastRaceValue = BeastRace.Orco;
    private int beastHealthValue = 120;
    private int beastArmorValue = 35;

    @FXML
    private TextField heroName;
    @FXML
    private ComboBox<HeroRace> heroRace;
    @FXML
    private Spinner<Integer> heroHealth;
    @FXML
    private Spinner<Integer> heroArmor;
    @FXML
    private TextField beastName;
    @FXML
    private ComboBox<BeastRace> beastRace;
    @FXML
    private Spinner<Integer> beastHealth;
    @FXML
    private Spinner<Integer> beastArmor;
    @FXML
    private ListView<String> heroList;
    @FXML
    private ListView<String> beastList;
    @FXML
    private TextArea gameLog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.gameView = new GameView();

        this.heroRace.setItems(FXCollections.observableArrayList(HeroRace.values()));
        this.beastRace.setItems(FXCollections.observableArrayList(BeastRace.values()));

        this.heroRace.getSelectionModel().select(0);
        this.beastRace.getSelectionModel().select(0);
    }

    @FXML
    public void updateHeroName(KeyEvent event){
        this.heroNameValue = heroName.getText();
    }

    @FXML
    public void updateHeroRace(ActionEvent event){
        this.heroRaceValue = heroRace.getValue();
    }

    @FXML
    public void updateHeroHealth(KeyEvent event){
        this.heroHealthValue = Integer.parseInt(heroHealth.getEditor().getText());
    }

    @FXML
    public void updateHeroHealthSpinner(MouseEvent event){
        this.heroHealthValue = Integer.parseInt(heroHealth.getEditor().getText());
    }

    @FXML
    public void updateHeroArmor(KeyEvent event){
        this.heroArmorValue = Integer.parseInt(heroArmor.getEditor().getText());
    }

    @FXML
    public void updateHeroArmorSpinner(MouseEvent event){
        this.heroArmorValue = Integer.parseInt(heroArmor.getEditor().getText());
    }

    @FXML
    public void updateBeastName(KeyEvent event){
        this.beastNameValue = beastName.getText();
    }

    @FXML
    public void updateBeastRace(ActionEvent event){
        this.beastRaceValue = beastRace.getValue();
    }

    @FXML
    public void updateBeastHealth(KeyEvent event){
        this.beastHealthValue = Integer.parseInt(beastHealth.getEditor().getText());
    }

    @FXML
    public void updateBeastHealthSpinner(MouseEvent event){
        this.beastHealthValue = Integer.parseInt(beastHealth.getEditor().getText());
    }

    @FXML
    public void updateBeastArmor(KeyEvent event){
        this.beastArmorValue = Integer.parseInt(beastArmor.getEditor().getText());
    }

    @FXML
    public void updateBeastArmorSpinner(MouseEvent event){
        this.beastArmorValue = Integer.parseInt(beastArmor.getEditor().getText());
    }

    @FXML
    public void addHero(MouseEvent event) {
        if (!Objects.equals(this.heroNameValue, "")) {
            Hero unit = null;

            switch (this.heroRaceValue) {
                case Humano -> {
                    unit = new Human();
                    unit.setRace(HeroRace.Humano);
                }
                case Elfo -> {
                    unit = new Elf();
                    unit.setRace(HeroRace.Elfo);
                }
                case Hobbit -> {
                    unit = new Hobbit();
                    unit.setRace(HeroRace.Hobbit);
                }
            }

            unit.setName(this.heroNameValue);
            unit.setHealth(this.heroHealthValue);
            unit.setArmor(this.heroArmorValue);
            unit.setAlive(true);

            this.heroTeam.add(unit);

            this.updateHeroTeam();

            heroName.setText("");
            this.heroNameValue = "";
            heroRace.getSelectionModel().select(0);
            this.heroRaceValue = HeroRace.Humano;
            heroHealth.getValueFactory().setValue(120);
            this.heroHealthValue = 120;
            heroArmor.getValueFactory().setValue(35);
            this.heroArmorValue = 35;
        }
    }

    @FXML
    public void addBeast(MouseEvent event) {
        if (!Objects.equals(this.beastNameValue, "")) {
            Beast unit = null;

            switch (this.beastRaceValue) {
                case Orco -> {
                    unit = new Orc();
                    unit.setRace(BeastRace.Orco);
                }
                case Trasgo -> {
                    unit = new Goblin();
                    unit.setRace(BeastRace.Trasgo);
                }
            }

            unit.setName(this.beastNameValue);
            unit.setHealth(this.beastHealthValue);
            unit.setArmor(this.beastArmorValue);
            unit.setAlive(true);

            this.beastTeam.add(unit);

            this.updateBeastTeam();

            beastName.setText("");
            this.beastNameValue = "";
            beastRace.getSelectionModel().select(0);
            this.beastRaceValue = BeastRace.Orco;
            beastHealth.getValueFactory().setValue(120);
            this.beastHealthValue = 120;
            beastArmor.getValueFactory().setValue(35);
            this.beastArmorValue = 35;
        }
    }

    @FXML
    public void moveHeroUp(MouseEvent event){
        try{
            int index = this.heroList.getSelectionModel().getSelectedIndex();
            Collections.swap(heroTeam, index, (index - 1));
            this.updateHeroTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void moveHeroDown(MouseEvent event){
        try{
            int index = this.heroList.getSelectionModel().getSelectedIndex();
            Collections.swap(heroTeam, index, (index + 1));
            this.updateHeroTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void removeHero(MouseEvent event){
        try{
            int index = this.heroList.getSelectionModel().getSelectedIndex();
            heroTeam.remove(index);
            this.updateHeroTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void moveBeastUp(MouseEvent event){
        try{
            int index = this.beastList.getSelectionModel().getSelectedIndex();
            Collections.swap(beastTeam, index, (index - 1));
            this.updateBeastTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void moveBeastDown(MouseEvent event){
        try{
            int index = this.beastList.getSelectionModel().getSelectedIndex();
            Collections.swap(beastTeam, index, (index + 1));
            this.updateBeastTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void removeBeast(MouseEvent event){
        try{
            int index = this.beastList.getSelectionModel().getSelectedIndex();
            beastTeam.remove(index);
            this.updateBeastTeam();
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    @FXML
    public void gameStart(MouseEvent event){
        if (heroTeam.size() > 0 & beastTeam.size() > 0){
            Task<Void> task = new Task<>() {
                @Override
                protected Void call() throws Exception {
                    gameBattle();
                    return null;
                }
            };

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        }
    }

    private void gameBattle() {
        Random random = new Random();

        boolean battleBool = true;
        int turn = 1;

        gameView.displayGameStart(gameLog);

        while (battleBool) {
            int fightsNum = Math.min(heroTeam.size(), beastTeam.size());

            gameView.displayTurn(gameLog, turn);
            this.updateBattle();

            this.gameDelay(1000);

            for (int i = 0; i < fightsNum; i++) {
                if ((heroTeam.size() - 1) < i | (beastTeam.size() - 1) < i) {
                    break;
                }

                Hero hero = heroTeam.get(i);
                Beast beast = beastTeam.get(i);

                gameView.displayFightWarning(gameLog, hero, beast);
                this.gameDelay(1000);

                if ((random.nextInt(99) + 1) % 2 == 0) {
                    int[] heroAttack = hero.attack(beast);
                    gameView.displayFightFirstAttack(gameLog, hero, beast, heroAttack);
                    this.gameDelay(500);

                    beast.getAttacked(heroAttack[1]);

                    if (beast.getHealth() <= 0) {
                        gameView.displayBeastDeath(gameLog, beast);
                        this.gameDelay(500);

                        beastTeam.remove(beast);

                        continue;
                    }

                    this.updateBattle();

                    int[] beastAttack = beast.attack(hero);
                    gameView.displayFightSecondAttack(gameLog, beast, hero, beastAttack);
                    this.gameDelay(500);

                    hero.getAttacked(beastAttack[1]);

                    if (hero.getHealth() <= 0) {
                        gameView.displayHeroDeath(gameLog, hero);
                        this.gameDelay(500);

                        heroTeam.remove(hero);
                    }

                    this.updateBattle();
                } else {
                    int[] beastAttack = beast.attack(hero);
                    gameView.displayFightFirstAttack(gameLog, beast, hero, beastAttack);
                    this.gameDelay(500);

                    hero.getAttacked(beastAttack[1]);

                    if (hero.getHealth() <= 0) {
                        gameView.displayHeroDeath(gameLog, hero);
                        this.gameDelay(500);

                        heroTeam.remove(hero);

                        continue;
                    }

                    this.updateBattle();

                    int[] heroAttack = hero.attack(beast);
                    gameView.displayFightSecondAttack(gameLog, hero, beast, heroAttack);
                    this.gameDelay(500);

                    beast.getAttacked(heroAttack[1]);

                    if (beast.getHealth() <= 0) {
                        gameView.displayBeastDeath(gameLog, beast);
                        this.gameDelay(500);

                        beastTeam.remove(beast);
                    }

                    try{
                        this.updateBattle();
                    } catch (IllegalStateException e){
                        System.out.println("Error: " + e.getMessage());
                    }

                }

            }

            if (heroTeam.size() == 0) {
                this.updateBattle();
                gameView.displayBeastWin(gameLog);
                battleBool = false;
            } else if (beastTeam.size() == 0) {
                this.updateBattle();
                gameView.displayHeroWin(gameLog);
                battleBool = false;
            }

            turn++;
        }
    }

    public void updateHeroTeam(){
        List<String> heroList = new ArrayList<>();
        for (Hero hero : heroTeam){
            heroList.add(hero.printHeroInfo());
        }
        this.heroList.setItems(FXCollections.observableArrayList(heroList));
    }

    public void updateBeastTeam(){
        List<String> beastList = new ArrayList<>();
        for (Beast beast : beastTeam){
            beastList.add(beast.printBeastInfo());
        }
        this.beastList.setItems(FXCollections.observableArrayList(beastList));
    }

    private void updateBattle() {
        Platform.runLater(() -> {
            this.updateHeroTeam();
            this.updateBeastTeam();
        });
    }

    public void gameDelay(int mil) {
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}