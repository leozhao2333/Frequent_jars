/*******************************************************************************
 * Copyright 2017 Tiese Barrell
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

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.history.HistoryLevel;
import org.toxos.processassertions.api.internal.ApiCallback;
import org.toxos.processassertions.api.internal.AssertFactory;

/**
 * Base class for Activiti process assertables. Provides access to services from configuration.
 *
 * @author Tiese Barrell
 */
public abstract class AbstractProcessAssertable {

    protected final ApiCallback callback;
    protected final ProcessAssertActivitiConfiguration configuration;

    AbstractProcessAssertable(final ApiCallback callback, final ProcessAssertActivitiConfiguration configuration) {
        this.callback = callback;
        this.configuration = configuration;
    }

    protected RuntimeService getRuntimeService() {
        return configuration.getProcessEngine().getRuntimeService();
    }

    protected HistoryService getHistoryService() {
        return configuration.getProcessEngine().getHistoryService();
    }

    protected TaskService getTaskService() {
        return configuration.getProcessEngine().getTaskService();
    }

    protected HistoryLevel getConfiguredHistoryLevel() {
        return configuration.getConfiguredHistoryLevel();
    }

    protected AssertFactory getAssertFactory() {
        return configuration.getAssertFactory();
    }

}
