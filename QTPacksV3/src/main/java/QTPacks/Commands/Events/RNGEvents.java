package QTPacks.Commands.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.requests.restaction.pagination.ReactionPaginationAction;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RNGEvents {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        //List
        String[] rngEvents = {
                "Click the [check] for free VBucks!",
                "Guys, click the [check] or else you won't get VBucks",
                "Guys, if you don't click the [check] in three seconds, a spider will crawl into your mouth the next time you sleep.",
                "CLICK THE [check] FOR FREE 5$ AMAZON GIFT CARD",
                "CLICK THE [check] TO MEET JESUS HIMSELF",
                "Do you want to learn the secret of the universe? Click the [check].",
                "Click the [check] to win your next game of league."
        };

        //Init
        if (e.getAuthor().isBot()) {
            return;
        }

        Random rand = new Random();
        int num = rand.nextInt(rngEvents.length);
        int i = 0;
        AtomicInteger ii = new AtomicInteger();
        EmbedBuilder rngEmbed = new EmbedBuilder();

        //EmbedBuilder
        rngEmbed.setColor(0x73e639);
        rngEmbed.setDescription(rngEvents[num].replace("[check]", "✓"));

        //RNGEvents Command
        if(e.getMessage().getContentRaw().equalsIgnoreCase("qt!disableRNG")) {
            i = 1;
            e.getChannel().sendMessage("RNG Events are disabled.").queue();

        }
        if(e.getMessage().getContentRaw().equalsIgnoreCase("qt!disableRNG") &&
                i == 1) {
            e.getChannel().sendMessage("RNG Events were already disabled!").queue();

        }
        if(e.getMessage().getContentRaw().equalsIgnoreCase("qt!enableRNG") &&
                i == 1) {
            i = 0;
            e.getChannel().sendMessage("RNG Events are enabled!").queue();

        }
        if(e.getMessage().getContentRaw().equalsIgnoreCase("qt!enableRNG") &&
                i == 0) {
            e.getChannel().sendMessage("RNG Events were already enabled!").queue();
        }

        while(i == 0) {
            int randInterval = (int)(Math.random() * 101);

            //RNGEvent Build
            if(randInterval == 101) {
                e.getChannel().sendMessage(rngEmbed.build()).queue(message -> {
                    message.addReaction("✅").queue();
                });
            }

            //Trigger + Send
            ReactionPaginationAction users = e.getMessage().retrieveReactionUsers("✅");
            users.forEachAsync((user) -> {
                ii.getAndIncrement();
                return false;
            });
            if(ii.get() == 2) {
                e.getChannel().sendMessage("Virus Activated.").queue();
            }
        }
    }
}
