package liquibase.integrationtest.command

import liquibase.integrationtest.setup.SetupDatabaseChangeLog

CommandTest.define {
    command = ["dbDoc"]

    run {
        arguments = [
                outputDirectory: "target/test-classes"
        ]


        setup new SetupDatabaseChangeLog("changelogs/hsqldb/complete/simple.changelog.xml")

        expectedOutput ""

        expectedResults([
                statusMessage: "Successfully executed dbDoc",
                statusCode   : 0
        ])
    }
}
