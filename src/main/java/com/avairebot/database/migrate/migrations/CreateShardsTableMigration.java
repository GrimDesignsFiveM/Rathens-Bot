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

package com.avairebot.database.migrate.migrations;

import com.avairebot.Constants;
import com.avairebot.contracts.database.migrations.Migration;
import com.avairebot.database.schema.Schema;

import java.sql.SQLException;

public class CreateShardsTableMigration implements Migration {

    @Override
    public String created_at() {
        return "Wed, Sep 20, 2017 9:25 PM";
    }

    @Override
    public boolean up(Schema schema) throws SQLException {
        return schema.createIfNotExists(Constants.SHARDS_TABLE_NAME, table -> {
            table.Integer("id");
            table.Integer("count");
            table.String("address").nullable();
            table.String("version").nullable();
            table.Integer("users").defaultValue(0);
            table.Integer("guilds").defaultValue(0);
            table.Integer("channels").defaultValue(0);
            table.Integer("voices").defaultValue(0);
            table.Integer("songs").defaultValue(0);
            table.Timestamps();
        });
    }

    @Override
    public boolean down(Schema schema) throws SQLException {
        return schema.dropIfExists(Constants.SHARDS_TABLE_NAME);
    }
}
