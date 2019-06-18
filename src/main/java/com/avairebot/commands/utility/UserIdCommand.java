/*
 * Copyright (c) 2018.
 *
 * This file is part of AvaIre.
 *
 * AvaIre is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AvaIre is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AvaIre.  If not, see <https://www.gnu.org/licenses/>.
 *
 *
 */

package com.avairebot.commands.utility;

import com.avairebot.AvaIre;
import com.avairebot.commands.CommandMessage;
import com.avairebot.contracts.commands.Command;
import com.avairebot.contracts.commands.CommandGroup;
import com.avairebot.contracts.commands.CommandGroups;
import com.avairebot.utilities.MentionableUtil;
import net.dv8tion.jda.core.entities.User;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserIdCommand extends Command {

    public UserIdCommand(AvaIre avaire) {
        super(avaire, false);
    }

    @Override
    public String getName() {
        return "User ID Command";
    }

    @Override
    public String getDescription() {
        return "Shows your Discord account user ID, or the ID of the user tagged in the command.";
    }

    @Override
    public List<String> getUsageInstructions() {
        return Collections.singletonList("`:command [user]` - Gets the ID of the user who ran the command, or the mentioned user.");
    }

    @Override
    public List<String> getExampleUsage() {
        return Arrays.asList(
            "`:command @Senither`",
            "`:command alexis`",
            "`:command 88739639380172800`"
        );
    }

    @Override
    public List<Class<? extends Command>> getRelations() {
        return Collections.singletonList(UserInfoCommand.class);
    }

    @Override
    public List<String> getTriggers() {
        return Arrays.asList("userid", "uid");
    }

    @Nonnull
    @Override
    public List<CommandGroup> getGroups() {
        return Collections.singletonList(CommandGroups.INFORMATION);
    }

    @Override
    public boolean onCommand(CommandMessage context, String[] args) {
        User user = context.getAuthor();
        if (args.length > 0) {
            user = MentionableUtil.getUser(context, new String[]{String.join(" ", args)});
        }

        if (user == null) {
            return sendErrorMessage(context, "errors.noUsersWithNameOrId", args[0]);
        }

        context.makeSuccess(context.i18n("message"))
            .set("target", user.getAsMention())
            .set("targetid", user.getId())
            .queue();

        return true;
    }
}
