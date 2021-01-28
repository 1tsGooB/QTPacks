package QTPacks;

import QTPacks.Commands.NoU;
import QTPacks.Commands.Packs;
import QTPacks.Commands.Events.RNGEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main {
    public static void main(String[] args) throws Exception {
        //Init
        JDA jda = JDABuilder.createDefault("Nzk5MDM3NTM2ODIzMjc5NjU3.X_9vsg.fSbEIvqJlVDQH8XTEnczlLkXfFI").build();
        jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
        jda.getPresence().setActivity(Activity.playing("BAN! BAN! BAN!"));

        //Events
        jda.addEventListener(new Packs());
        jda.addEventListener(new NoU());
        jda.addEventListener(new RNGEvents());
    }
}
