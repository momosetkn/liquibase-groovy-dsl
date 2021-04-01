package liquibase.integrationtest.command

import liquibase.integrationtest.setup.SetupDatabaseChangeLog

CommandTest.define {
    command = ["updateCountSQL"]

    run {
        arguments = [
                count: 1
        ]

        setup new SetupDatabaseChangeLog("changelogs/hsqldb/complete/simple.changelog.xml")

        expectedOutput ""

        expectedResults([
                statusMessage: "Successfully executed updateCountSQL",
                statusCode   : 0
        ])
    }
}
