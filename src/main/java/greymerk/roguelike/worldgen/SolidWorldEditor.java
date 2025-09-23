package greymerk.roguelike.worldgen;

import greymerk.roguelike.treasure.ITreasureChest;
import greymerk.roguelike.treasure.TreasureManager;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

import java.util.Map;
import java.util.Random;

public class SolidWorldEditor implements IWorldEditor {

    private final IWorldEditor base;

    public SolidWorldEditor(IWorldEditor base) {
        this.base = base;
    }

    @Override
    public boolean setBlock(Coord pos, MetaBlock metaBlock, boolean fillAir, boolean replaceSolid) {
        return base.setBlock(pos, metaBlock, true, true);
    }

    @Override
    public MetaBlock getBlock(Coord pos) {
        return base.getBlock(pos);
    }

    @Override
    public boolean isAirBlock(Coord pos) {
        return base.isAirBlock(pos);
    }

    @Override
    public TileEntity getTileEntity(Coord pos) {
        return base.getTileEntity(pos);
    }

    @Override
    public long getSeed() {
        return base.getSeed();
    }

    @Override
    public Random getSeededRandom(int m, int n, int i) {
        return base.getSeededRandom(m, n, i);
    }

    @Override
    public void fillDown(Random rand, Coord pos, IBlockFactory pillar) {
        base.fillDown(rand, pos, pillar);
    }

    @Override
    public boolean canPlace(MetaBlock block, Coord pos, Cardinal dir) {
        return base.canPlace(block, pos, dir);
    }

    @Override
    public boolean validGroundBlock(Coord pos) {
        return base.validGroundBlock(pos);
    }

    @Override
    public void spiralStairStep(Random rand, Coord pos, IStair stair, IBlockFactory pillar) {
        base.spiralStairStep(rand, pos, stair, pillar);
    }

    @Override
    public int getStat(Block block) {
        return base.getStat(block);
    }

    @Override
    public Map<Block, Integer> getStats() {
        return base.getStats();
    }

    @Override
    public TreasureManager getTreasure() {
        return base.getTreasure();
    }

    @Override
    public void addChest(ITreasureChest chest) {
        base.addChest(chest);
    }

    @Override
    public IPositionInfo getInfo(Coord pos) {
        return base.getInfo(pos);
    }

    @Override
    public Coord findNearestStructure(VanillaStructure type, Coord pos) {
        return base.findNearestStructure(type, pos);
    }

    @Override
    public boolean alwaysBuildSegments() {
        return true;
    }
}
