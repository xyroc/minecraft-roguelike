package greymerk.roguelike.command;

import greymerk.roguelike.dungeon.base.DungeonRoom;
import greymerk.roguelike.dungeon.base.IDungeonRoom;
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

public class CommandBuildRoom extends CommandBase {

    @Override
    public String getName() {
        return "build-room";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender iCommandSender, String[] strings) throws CommandException {
        if (strings.length != 1) {
            return;
        }
        if (iCommandSender instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) iCommandSender;
            String roomName = strings[0].toUpperCase(Locale.ROOT);

            IWorldEditor worldEditor = new SolidWorldEditor(new WorldEditor(player.world));
            LevelSettings levelSettings = new LevelSettings();
            levelSettings.setTheme(Theme.getTheme(Theme.OAK));
            levelSettings.setDifficulty(1);

            IDungeonRoom room = DungeonRoom.getInstance(DungeonRoom.valueOf(roomName));
            if (room == null) {
                iCommandSender.sendMessage(new TextComponentString("Unknown room type: " + roomName));
                return;
            }

            room.generate(worldEditor, new Random(), levelSettings, new Cardinal[]{Cardinal.EAST}, new Coord(player.getPosition()));
        }
    }
}
