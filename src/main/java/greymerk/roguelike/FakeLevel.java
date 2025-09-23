package greymerk.roguelike;

import greymerk.roguelike.dungeon.IDungeonLevel;
import greymerk.roguelike.dungeon.ILevelGenerator;
import greymerk.roguelike.dungeon.ILevelLayout;
import greymerk.roguelike.dungeon.LevelLayout;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.filter.IFilter;

import java.util.Random;

public class FakeLevel implements IDungeonLevel {

    public LevelSettings settings;
    public ILevelLayout layout = new LevelLayout();

    @Override
    public LevelSettings getSettings() {
        return settings;
    }

    @Override
    public boolean hasNearbyNode(Coord pos) {
        return false;
    }

    @Override
    public ILevelLayout getLayout() {
        return layout;
    }

    @Override
    public void encase(IWorldEditor editor, Random rand) {

    }

    @Override
    public void generate(ILevelGenerator generator, Coord start) {

    }

    @Override
    public void applyFilters(IWorldEditor editor, Random rand) {

    }

    @Override
    public void filter(IWorldEditor editor, Random rand, IFilter filter) {

    }
}
