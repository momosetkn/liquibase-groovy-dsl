/*
 * Copyright 2011-2024 Tim Berglund and Steven C. Saliman
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.liquibase.groovy.serialize

import org.junit.Test
import static org.junit.Assert.*

import liquibase.change.core.AddDefaultValueChange


/**
 * <p></p>
 *
 * @author Steven C. Saliman
 */
class DataQualityRefactoringSerializerTests extends SerializerTests {

    @Test
    void addDefaultValueBoolean() {
        def change = [
                tableName          : 'monkey',
                schemaName         : 'schema',
                columnName         : 'emotion',
                defaultValueBoolean: true
        ] as AddDefaultValueChange

        def serializedText = serializer.serialize(change, true)
        def expectedText = "addDefaultValue(columnName: '''emotion''', defaultValueBoolean: true, schemaName: '''schema''', tableName: '''monkey''')"
        assertEquals expectedText, serializedText
    }

}

