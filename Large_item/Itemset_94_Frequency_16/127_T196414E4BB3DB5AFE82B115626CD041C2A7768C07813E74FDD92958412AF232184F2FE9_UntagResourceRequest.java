/*
 * Copyright 2019-2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
package com.amazonaws.services.amplify.model;

import java.io.Serializable;
import javax.annotation.Generated;

import com.amazonaws.AmazonWebServiceRequest;

/**
 * <p>
 * The request structure for the untag resource request.
 * </p>
 * 
 * @see <a href="http://docs.aws.amazon.com/goto/WebAPI/amplify-2017-07-25/UntagResource" target="_top">AWS API
 *      Documentation</a>
 */
@Generated("com.amazonaws:aws-java-sdk-code-generator")
public class UntagResourceRequest extends com.amazonaws.AmazonWebServiceRequest implements Serializable, Cloneable {

    /**
     * <p>
     * The Amazon Resource Name (ARN) to use to untag a resource.
     * </p>
     */
    private String resourceArn;
    /**
     * <p>
     * The tag keys to use to untag a resource.
     * </p>
     */
    private java.util.List<String> tagKeys;

    /**
     * <p>
     * The Amazon Resource Name (ARN) to use to untag a resource.
     * </p>
     * 
     * @param resourceArn
     *        The Amazon Resource Name (ARN) to use to untag a resource.
     */

    public void setResourceArn(String resourceArn) {
        this.resourceArn = resourceArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) to use to untag a resource.
     * </p>
     * 
     * @return The Amazon Resource Name (ARN) to use to untag a resource.
     */

    public String getResourceArn() {
        return this.resourceArn;
    }

    /**
     * <p>
     * The Amazon Resource Name (ARN) to use to untag a resource.
     * </p>
     * 
     * @param resourceArn
     *        The Amazon Resource Name (ARN) to use to untag a resource.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UntagResourceRequest withResourceArn(String resourceArn) {
        setResourceArn(resourceArn);
        return this;
    }

    /**
     * <p>
     * The tag keys to use to untag a resource.
     * </p>
     * 
     * @return The tag keys to use to untag a resource.
     */

    public java.util.List<String> getTagKeys() {
        return tagKeys;
    }

    /**
     * <p>
     * The tag keys to use to untag a resource.
     * </p>
     * 
     * @param tagKeys
     *        The tag keys to use to untag a resource.
     */

    public void setTagKeys(java.util.Collection<String> tagKeys) {
        if (tagKeys == null) {
            this.tagKeys = null;
            return;
        }

        this.tagKeys = new java.util.ArrayList<String>(tagKeys);
    }

    /**
     * <p>
     * The tag keys to use to untag a resource.
     * </p>
     * <p>
     * <b>NOTE:</b> This method appends the values to the existing list (if any). Use
     * {@link #setTagKeys(java.util.Collection)} or {@link #withTagKeys(java.util.Collection)} if you want to override
     * the existing values.
     * </p>
     * 
     * @param tagKeys
     *        The tag keys to use to untag a resource.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UntagResourceRequest withTagKeys(String... tagKeys) {
        if (this.tagKeys == null) {
            setTagKeys(new java.util.ArrayList<String>(tagKeys.length));
        }
        for (String ele : tagKeys) {
            this.tagKeys.add(ele);
        }
        return this;
    }

    /**
     * <p>
     * The tag keys to use to untag a resource.
     * </p>
     * 
     * @param tagKeys
     *        The tag keys to use to untag a resource.
     * @return Returns a reference to this object so that method calls can be chained together.
     */

    public UntagResourceRequest withTagKeys(java.util.Collection<String> tagKeys) {
        setTagKeys(tagKeys);
        return this;
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceArn() != null)
            sb.append("ResourceArn: ").append(getResourceArn()).append(",");
        if (getTagKeys() != null)
            sb.append("TagKeys: ").append(getTagKeys());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;

        if (obj instanceof UntagResourceRequest == false)
            return false;
        UntagResourceRequest other = (UntagResourceRequest) obj;
        if (other.getResourceArn() == null ^ this.getResourceArn() == null)
            return false;
        if (other.getResourceArn() != null && other.getResourceArn().equals(this.getResourceArn()) == false)
            return false;
        if (other.getTagKeys() == null ^ this.getTagKeys() == null)
            return false;
        if (other.getTagKeys() != null && other.getTagKeys().equals(this.getTagKeys()) == false)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getResourceArn() == null) ? 0 : getResourceArn().hashCode());
        hashCode = prime * hashCode + ((getTagKeys() == null) ? 0 : getTagKeys().hashCode());
        return hashCode;
    }

    @Override
    public UntagResourceRequest clone() {
        return (UntagResourceRequest) super.clone();
    }

}
