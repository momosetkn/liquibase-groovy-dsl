/*
 * Copyright 2011 Tim Berglund
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.augusttechgroup.liquibase.delegate

/**
 * This class processes the {@code arg} closure that can be present in an
 * {@code executeCommand} change.
 */
class ArgumentDelegate {
	def args = []

	/**
	 * Process an argument where the argument is simply a string.  This is not
	 * how the Liquibase XML works, but it is really nice shorthand.
	 * @param value the argument to add
	 */
	def arg(String value) {
		args << value
	}

	/**
	 * Process an argument where the argument is in the {@code value} entry of
	 * the given map.  This is consistent with how Liquibase XML works.
	 * @param valueMap the map containing the argument.
	 */
	def arg(Map valueMap) {
		args << valueMap.value
	}
}