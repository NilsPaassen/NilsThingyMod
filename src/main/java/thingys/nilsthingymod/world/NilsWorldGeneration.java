package thingys.nilsthingymod.world;

import thingys.nilsthingymod.world.gen.NilsEntityGeneration;
import thingys.nilsthingymod.world.gen.NilsTreeGeneration;

public class NilsWorldGeneration {
    public static  void generateNilsWorldGen(){
        NilsTreeGeneration.generateTrees();
        NilsEntityGeneration.addSpawns();
    }
}
