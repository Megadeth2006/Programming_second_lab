import ru.ifmo.se.pokemon.Battle;
import Pokemons.*;
public class Main {
    public static void main(String[] args) {

        Battle b = new Battle();

       b.addFoe(new Fearow("Гигачад", 1));
       b.addAlly(new Pichu("Мелочь Пузатая", 1));
       b.addFoe(new Pikachu("Мышь", 1));
       b.addAlly(new Raichu("Ноунейм", 1));
       b.addFoe(new Spearow("Сигма", 1));
       b.addAlly(new Victini("Инопланетянин", 1));

        b.go();

    }
}