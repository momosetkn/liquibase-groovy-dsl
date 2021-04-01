package liquibase.integrationtest.command

import liquibase.change.ColumnConfig
import liquibase.change.core.CreateTableChange
import liquibase.change.core.TagDatabaseChange
import liquibase.integrationtest.setup.SetupChangeLogSync
import liquibase.integrationtest.setup.SetupDatabaseChangeLog
import liquibase.integrationtest.setup.SetupDatabaseStructure

CommandTest.define {
    command = ["rollback"]

    run {
        arguments = [
                tag: "version_2.0"
        ]

        setup SetupDatabaseStructure.create(
                new CreateTableChange(
                        tableName: "FirstTable",
                        columns: [
                                ColumnConfig.fromName("FirstColumn")
                                        .setType("VARCHAR(255)")
                        ]
                ),
                new CreateTableChange(
                        tableName: "SecondTable",
                        columns: [
                                ColumnConfig.fromName("SecondColumn")
                                        .setType("VARCHAR(255)")
                        ]
                ),
                new TagDatabaseChange(
                        tag: "version_2.0"
                ),
                new CreateTableChange(
                        tableName: "liquibaseRunInfo",
                        columns: [
                                ColumnConfig.fromName("timesRan")
                                        .setType("INT")
                        ]
                ),
        ),
                new SetupDatabaseChangeLog("changelogs/hsqldb/complete/rollback.tag.changelog.xml"),
                new SetupChangeLogSync("changelogs/hsqldb/complete/rollback.tag.changelog.xml")

        expectedOutput ""

        expectedResults([
                statusMessage: "Successfully executed rollback",
                statusCode   : 0
        ])
    }
}
