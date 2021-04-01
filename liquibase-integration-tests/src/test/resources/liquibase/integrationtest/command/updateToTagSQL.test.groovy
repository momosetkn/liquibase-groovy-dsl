package liquibase.integrationtest.command

import liquibase.integrationtest.setup.SetupDatabaseChangeLog

CommandTest.define {
    command = ["updateToTagSQL"]

    run {
        arguments = [
                tag: "version_2.0"
        ]

        setup new SetupDatabaseChangeLog("changelogs/hsqldb/complete/simple.tag.changelog.xml")

        expectedOutput ""

        expectedResults([
                statusMessage: "Successfully executed updateToTagSQL",
                statusCode   : 0
        ])
    }
}
