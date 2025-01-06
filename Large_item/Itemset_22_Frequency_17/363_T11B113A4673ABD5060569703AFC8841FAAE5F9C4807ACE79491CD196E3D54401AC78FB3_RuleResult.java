/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.awssdk.services.appconfigdata.endpoints.internal;

import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.endpoints.Endpoint;
import software.amazon.awssdk.utils.Validate;

@SdkInternalApi
public final class RuleResult {
    private static final RuleResult CARRY_ON = new RuleResult();
    private final String error;
    private final Endpoint endpoint;

    private RuleResult() {
        this.error = null;
        this.endpoint = null;
    }

    private RuleResult(String error) {
        this.error = Validate.paramNotNull(error, "error");
        this.endpoint = null;
    }

    private RuleResult(Endpoint endpoint) {
        this.error = null;
        this.endpoint = Validate.paramNotNull(endpoint, "endpoint");
    }

    public boolean canContinue() {
        return error == null && endpoint == null;
    }

    public boolean isResolved() {
        return !isUnresolved();
    }

    public boolean isUnresolved() {
        return error == null && endpoint == null;
    }

    public boolean isError() {
        return error != null;
    }

    public boolean isEndpoint() {
        return endpoint != null;
    }

    public String error() {
        return error;
    }

    public Endpoint endpoint() {
        return endpoint;
    }

    public static RuleResult error(String error) {
        return new RuleResult(error);
    }

    public static RuleResult carryOn() {
        return CARRY_ON;
    }

    public static RuleResult endpoint(Endpoint endpoint) {
        return new RuleResult(endpoint);
    }
}
