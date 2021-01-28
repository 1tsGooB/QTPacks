package QTPacks.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Objects;

public class Packs extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        //Init
        if (e.getAuthor().isBot()) {
            return;
        }

        //Default Embeds
        EmbedBuilder epEmbed = new EmbedBuilder();
        EmbedBuilder epConfirmEmbed = new EmbedBuilder();
        EmbedBuilder epInvalidEmbed = new EmbedBuilder();

        //Goob Embeds
        EmbedBuilder epGoobEmbed1 = new EmbedBuilder();
        EmbedBuilder epGoobEmbed2 = new EmbedBuilder();
        EmbedBuilder epGoobEmbed3 = new EmbedBuilder();
        EmbedBuilder epGoobEmbed4 = new EmbedBuilder();

        //Coin Embeds
        EmbedBuilder epCoinEmbed1 = new EmbedBuilder();
        EmbedBuilder epCoinEmbed2 = new EmbedBuilder();

        //Pixel Embeds
        EmbedBuilder epPixelEmbed1 = new EmbedBuilder();
        EmbedBuilder epPixelEmbed2 = new EmbedBuilder();

        //Default EmbedBuilder
        epEmbed.setTitle("Emoji Packs");
        epEmbed.addField("1| Gooby Pack", "<:GOOB:802360043709399061> <:GOOB2:802359905205878844> <:GOOB3:802359839833587743> <:GOOB4:802359781599346719>", false);
        epEmbed.addField("2| Coin Pack", "<a:9COIN:802360256558006282> <a:32COIN:802360210660392980>", false);
        epEmbed.addField("3| Pixel Pack", "<:FKey:802360169841295360> <:Horse:802360489635610625>", false);
        epEmbed.setFooter("Input a number to preview the packs, or type C to cancel");

        epConfirmEmbed.setTitle("Are you sure? (Y/N)");
        epInvalidEmbed.setTitle("That is not valid.");

        //Goob EmbedBuilder
        epGoobEmbed1.setTitle("Gooby Pack | Emoji 1");
        epGoobEmbed1.setImage("https://i.imgur.com/uCoZNi2.png");
        epGoobEmbed1.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        epGoobEmbed2.setTitle("Gooby Pack | Emoji 2");
        epGoobEmbed2.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        epGoobEmbed3.setTitle("Gooby Pack | Emoji 3");
        epGoobEmbed3.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        epGoobEmbed4.setTitle("Gooby Pack | Emoji 4");
        epGoobEmbed4.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        //Coin EmbedBuilder
        epCoinEmbed1.setTitle("Coin Pack | Emoji 1");
        epCoinEmbed1.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        epCoinEmbed2.setTitle("Coin Pack | Emoji 2");
        epCoinEmbed2.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        //Pixel EmbedBuilder
        epPixelEmbed1.setTitle("Pixel Pack | Emoji 1");
        epPixelEmbed1.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        epPixelEmbed2.setTitle("Pixel Pack | Emoji 2");
        epPixelEmbed2.setFooter("Type \"qt!buy\" to buy this pack, send a number to see an emoji in the pack, or send \"cancel\" to go back to the main page");

        //RoleID
        Role Gooby = e.getGuild().getRoleById("802444901329141760");
        Role Coin = e.getGuild().getRoleById("802444966445842444");
        Role Pixel = e.getGuild().getRoleById("802445061186519070");

        //Trigger + Send
        if (e.getMessage().getContentRaw().equalsIgnoreCase("qt!packs")) {
            e.getChannel().sendMessage(epEmbed.build()).queue();
        }

        //Gooby Role Give
        if (e.getMessage().getContentRaw().equalsIgnoreCase("1")) {
            e.getChannel().sendMessage(epGoobEmbed1.build()).queue();

            String j = e.getMessage().getContentRaw();
            String h;

            switch (j) {
                case "1":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epGoobEmbed1.build()).queue();
                    h = "1";

                case "2":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epGoobEmbed2.build()).queue();
                    h = "2";

                case "3":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epGoobEmbed3.build()).queue();
                    h = "3";

                case "4":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epGoobEmbed4.build()).queue();
                    h = "4";

                case "qt!buy":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epConfirmEmbed.build()).queue();

                    if (e.getMessage().getContentRaw().equalsIgnoreCase("Y")) {
                        assert Gooby != null;
                        e.getGuild().addRoleToMember(Objects.requireNonNull(e.getMember()), Gooby).queue();

                    } else if (e.getMessage().getContentRaw().equalsIgnoreCase("N")) {
                        e.getMessage().delete().queue();
                        e.getMessage().delete().queue();

                    } else {
                        e.getMessage().delete().queue();
                        e.getMessage().editMessage(epInvalidEmbed.build()).queue();
                    }

                case "Cancel":
                    e.getMessage().delete().queue();
                    e.getMessage().delete().queue();

                default:
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epInvalidEmbed.build()).queue();
                    h = "5";
            }

            if (j.equals(h)) {
                e.getMessage().delete().queue();
                e.getMessage().editMessage(epInvalidEmbed.build()).queue();
            }
            //Coin Role Give
        } else if (e.getMessage().getContentRaw().equalsIgnoreCase("2")) {
            e.getChannel().sendMessage(epCoinEmbed1.build()).queue();

            String j = e.getMessage().getContentRaw();
            String h = null;

            switch (j) {
                case "1":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epCoinEmbed1.build()).queue();
                    h = "1";

                case "2":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epCoinEmbed2.build()).queue();
                    h = "2";

                case "qt!buy":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epConfirmEmbed.build()).queue();

                    if (e.getMessage().getContentRaw().equalsIgnoreCase("Y")) {
                        assert Coin != null;
                        e.getGuild().addRoleToMember(Objects.requireNonNull(e.getMember()), Coin).queue();

                    } else if (e.getMessage().getContentRaw().equalsIgnoreCase("N")) {
                        e.getMessage().delete().queue();
                        e.getMessage().delete().queue();

                    } else {
                        e.getMessage().delete().queue();
                        e.getMessage().editMessage(epInvalidEmbed.build()).queue();
                    }

                case "Cancel":
                    e.getMessage().delete().queue();
                    e.getMessage().delete().queue();

                default:
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epInvalidEmbed.build()).queue();
            }

            if (j.equals(h)) {
                e.getMessage().delete().queue();
                e.getMessage().editMessage(epInvalidEmbed.build()).queue();
            }
            //Pixel Role Give
        } else if (e.getMessage().getContentRaw().equalsIgnoreCase("3")) {
            e.getChannel().sendMessage(epPixelEmbed1.build()).queue();

            String j = e.getMessage().getContentRaw();
            String h;

            switch (j) {
                case "1":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epPixelEmbed1.build()).queue();
                    h = "1";

                case "2":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epPixelEmbed2.build()).queue();
                    h = "2";

                case "qt!buy":
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epConfirmEmbed.build()).queue();

                    if (e.getMessage().getContentRaw().equalsIgnoreCase("Y")) {
                        assert Pixel != null;
                        e.getGuild().addRoleToMember(Objects.requireNonNull(e.getMember()), Pixel).queue();

                    } else if (e.getMessage().getContentRaw().equalsIgnoreCase("N")) {
                        e.getMessage().delete().queue();
                        e.getMessage().delete().queue();

                    } else {
                        e.getMessage().delete().queue();
                        e.getMessage().editMessage(epInvalidEmbed.build()).queue();
                    }

                case "Cancel":
                    e.getMessage().delete().queue();
                    e.getMessage().delete().queue();

                default:
                    e.getMessage().delete().queue();
                    e.getMessage().editMessage(epInvalidEmbed.build()).queue();
                    h = "5";
            }

            if (j.equals(h)) {
                e.getMessage().delete().queue();
                e.getMessage().editMessage(epInvalidEmbed.build()).queue();
            }
        }
    }
}