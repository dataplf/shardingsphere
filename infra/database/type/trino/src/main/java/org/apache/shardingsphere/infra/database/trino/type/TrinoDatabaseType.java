/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.database.trino.type;

import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.spi.type.typed.TypedSPILoader;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Database type of Trino.
 * ClickHouse currently uses MySQL dialect parsing.
 */
public final class TrinoDatabaseType implements DatabaseType {
    
    @Override
    public Collection<String> getJdbcUrlPrefixes() {
        return Arrays.asList("jdbc:trino:");
    }

    @Override
    public Optional<DatabaseType> getTrunkDatabaseType() {
        return Optional.of(TypedSPILoader.getService(DatabaseType.class, "MySQL"));
    }
    
    @Override
    public String getType() {
        return "Trino";
    }
}