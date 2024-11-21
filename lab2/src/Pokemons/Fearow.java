package Pokemons;
import Moves.Physical.*;
import Moves.Status.*;
import Moves.Special.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class Fearow extends Spearow{
    public static int a = 1;
    public Fearow(String name, int level){
        super(name, level);
        setStats(65, 90, 65, 61, 61, 100);
        setType(Type.NORMAL, Type.FLYING);
        setMove(new DrillRun());

    }

}
