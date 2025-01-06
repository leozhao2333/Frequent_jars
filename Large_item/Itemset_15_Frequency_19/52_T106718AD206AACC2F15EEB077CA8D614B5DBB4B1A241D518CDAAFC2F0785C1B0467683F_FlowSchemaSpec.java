/*
 * Copyright (c) 2022 - Yupiik SAS - https://www.yupiik.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.yupiik.kubernetes.bindings.v1_22_5.v1beta1;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import io.yupiik.kubernetes.bindings.v1_22_5.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class FlowSchemaSpec implements Validable<FlowSchemaSpec>, Exportable {
    private FlowDistinguisherMethod distinguisherMethod;
    private Integer matchingPrecedence;
    private PriorityLevelConfigurationReference priorityLevelConfiguration;
    private List<PolicyRulesWithSubjects> rules;

    public FlowSchemaSpec() {
        // no-op
    }

    public FlowSchemaSpec(final FlowDistinguisherMethod distinguisherMethod,
                          final Integer matchingPrecedence,
                          final PriorityLevelConfigurationReference priorityLevelConfiguration,
                          final List<PolicyRulesWithSubjects> rules) {
        this.distinguisherMethod = distinguisherMethod;
        this.matchingPrecedence = matchingPrecedence;
        this.priorityLevelConfiguration = priorityLevelConfiguration;
        this.rules = rules;
    }

    public FlowDistinguisherMethod getDistinguisherMethod() {
        return distinguisherMethod;
    }

    public void setDistinguisherMethod(final FlowDistinguisherMethod distinguisherMethod) {
        this.distinguisherMethod = distinguisherMethod;
    }

    public Integer getMatchingPrecedence() {
        return matchingPrecedence;
    }

    public void setMatchingPrecedence(final Integer matchingPrecedence) {
        this.matchingPrecedence = matchingPrecedence;
    }

    public PriorityLevelConfigurationReference getPriorityLevelConfiguration() {
        return priorityLevelConfiguration;
    }

    public void setPriorityLevelConfiguration(final PriorityLevelConfigurationReference priorityLevelConfiguration) {
        this.priorityLevelConfiguration = priorityLevelConfiguration;
    }

    public List<PolicyRulesWithSubjects> getRules() {
        return rules;
    }

    public void setRules(final List<PolicyRulesWithSubjects> rules) {
        this.rules = rules;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                distinguisherMethod,
                matchingPrecedence,
                priorityLevelConfiguration,
                rules);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof FlowSchemaSpec)) {
            return false;
        }
        final FlowSchemaSpec __otherCasted = (FlowSchemaSpec) __other;
        return Objects.equals(distinguisherMethod, __otherCasted.distinguisherMethod) &&
            Objects.equals(matchingPrecedence, __otherCasted.matchingPrecedence) &&
            Objects.equals(priorityLevelConfiguration, __otherCasted.priorityLevelConfiguration) &&
            Objects.equals(rules, __otherCasted.rules);
    }

    public FlowSchemaSpec distinguisherMethod(final FlowDistinguisherMethod distinguisherMethod) {
        this.distinguisherMethod = distinguisherMethod;
        return this;
    }

    public FlowSchemaSpec matchingPrecedence(final Integer matchingPrecedence) {
        this.matchingPrecedence = matchingPrecedence;
        return this;
    }

    public FlowSchemaSpec priorityLevelConfiguration(final PriorityLevelConfigurationReference priorityLevelConfiguration) {
        this.priorityLevelConfiguration = priorityLevelConfiguration;
        return this;
    }

    public FlowSchemaSpec rules(final List<PolicyRulesWithSubjects> rules) {
        this.rules = rules;
        return this;
    }

    @Override
    public FlowSchemaSpec validate() {
        List<ValidationException.ValidationError> __errors_jsonSchema = null;
        if (priorityLevelConfiguration == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "priorityLevelConfiguration", "priorityLevelConfiguration",
                "Missing 'priorityLevelConfiguration' attribute.", true));
        }
        if (__errors_jsonSchema != null) {
            throw new ValidationException(__errors_jsonSchema);
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (distinguisherMethod != null ? "\"distinguisherMethod\":" + distinguisherMethod.asJson() : ""),
                    (matchingPrecedence != null ? "\"matchingPrecedence\":" + matchingPrecedence : ""),
                    (priorityLevelConfiguration != null ? "\"priorityLevelConfiguration\":" + priorityLevelConfiguration.asJson() : ""),
                    (rules != null ? "\"rules\":" + rules.stream().map(__it -> __it == null ? "null" : __it.asJson()).collect(joining(",", "[", "]")) : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
