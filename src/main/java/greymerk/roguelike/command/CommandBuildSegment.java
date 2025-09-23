package greymerk.roguelike.command;

import greymerk.roguelike.FakeLevel;
import greymerk.roguelike.dungeon.segment.ISegment;
import greymerk.roguelike.dungeon.segment.Segment;
import greymerk.roguelike.dungeon.settings.LevelSettings;
import greymerk.roguelike.theme.Theme;
import greymerk.roguelike.worldgen.Cardinal;
import greymerk.roguelike.worldgen.Coord;
import greymerk.roguelike.worldgen.IWorldEditor;
import greymerk.roguelike.worldgen.SolidWorldEditor;
import greymerk.roguelike.worldgen.WorldEditor;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

import java.util.Locale;
import java.util.Random;

public class CommandBuildSegment extends CommandBase {
    @Override
    public String getName() {
        return "build-segment";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length != 1) {
            return;
        }
        if (sender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender;
            String roomName = args[0].toUpperCase(Locale.ROOT);

            IWorldEditor worldEditor = new SolidWorldEditor(new WorldEditor(player.world));
            LevelSettings levelSettings = new LevelSettings();
            levelSettings.setTheme(Theme.getTheme(Theme.OAK));
            levelSettings.setDifficulty(1);

            Coord playerPos = new Coord(player.getPosition().getX(), player.getPosition().getY(),
                    player.getPosition().getZ());
            FakeLevel level = new FakeLevel();
            level.settings = levelSettings;

            ISegment segment = Segment.getSegment(Segment.valueOf(roomName));
            if (segment == null) {
                sender.sendMessage(new TextComponentString("Unknown segment type: " + roomName));
                return;
            }

            segment.generate(worldEditor, new Random(), level, Cardinal.EAST, Theme.getTheme(Theme.OAK), playerPos);
        }
    }
}
