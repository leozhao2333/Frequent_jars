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
package io.yupiik.kubernetes.bindings.v1_22_5.v1;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class LoadBalancerStatus implements Validable<LoadBalancerStatus>, Exportable {
    private List<LoadBalancerIngress> ingress;

    public LoadBalancerStatus() {
        // no-op
    }

    public LoadBalancerStatus(final List<LoadBalancerIngress> ingress) {
        this.ingress = ingress;
    }

    public List<LoadBalancerIngress> getIngress() {
        return ingress;
    }

    public void setIngress(final List<LoadBalancerIngress> ingress) {
        this.ingress = ingress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                ingress);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof LoadBalancerStatus)) {
            return false;
        }
        final LoadBalancerStatus __otherCasted = (LoadBalancerStatus) __other;
        return Objects.equals(ingress, __otherCasted.ingress);
    }

    public LoadBalancerStatus ingress(final List<LoadBalancerIngress> ingress) {
        this.ingress = ingress;
        return this;
    }

    @Override
    public LoadBalancerStatus validate() {
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (ingress != null ? "\"ingress\":" + ingress.stream().map(__it -> __it == null ? "null" : __it.asJson()).collect(joining(",", "[", "]")) : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
