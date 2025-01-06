/*******************************************************************************
 * Copyright 2014 Tiese Barrell
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.toxos.processassertions.activiti;

/**
 * Messages used in log statements.
 * 
 * @author Tiese Barrell
 * 
 */
public enum LogMessage {

    /**
     * Configuration is initialized.
     */
    CONFIGURATION_1,

    /**
     * Configuration is deinitialized due to engine close down.
     */
    CONFIGURATION_2;

    private final String bundleKey;

    /**
     * Constructs a new LogMessage.
     */
    private LogMessage() {
        this.bundleKey = name().replaceAll("_", ".").toLowerCase();
    }

    /**
     * Gets the bundle key for the LogMessage.
     * 
     * @return the bundle key
     */
    public String getBundleKey() {
        return bundleKey;
    }

}
