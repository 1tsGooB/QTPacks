package QTPacks.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NoU extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        //Init
        if(e.getAuthor().isBot()) {
            return;
        }

        //Command
        if(e.getMessage().getContentRaw().equalsIgnoreCase("no u")) {
            e.getChannel().sendMessage("https://tenor.com/view/spiderman-no-u-gif-14873396").queue();
        }
    }
}

