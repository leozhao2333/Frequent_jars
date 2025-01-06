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

package software.amazon.awssdk.services.datapipeline.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.SdkField;
import software.amazon.awssdk.core.SdkPojo;
import software.amazon.awssdk.core.protocol.MarshallLocation;
import software.amazon.awssdk.core.protocol.MarshallingType;
import software.amazon.awssdk.core.traits.LocationTrait;
import software.amazon.awssdk.utils.ToString;
import software.amazon.awssdk.utils.builder.CopyableBuilder;
import software.amazon.awssdk.utils.builder.ToCopyableBuilder;

/**
 * <p>
 * Tags are key/value pairs defined by a user and associated with a pipeline to control access. AWS Data Pipeline allows
 * you to associate ten tags per pipeline. For more information, see <a
 * href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling User Access
 * to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
 * </p>
 */
@Generated("software.amazon.awssdk:codegen")
public final class Tag implements SdkPojo, Serializable, ToCopyableBuilder<Tag.Builder, Tag> {
    private static final SdkField<String> KEY_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("key")
            .getter(getter(Tag::key)).setter(setter(Builder::key))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("key").build()).build();

    private static final SdkField<String> VALUE_FIELD = SdkField.<String> builder(MarshallingType.STRING).memberName("value")
            .getter(getter(Tag::value)).setter(setter(Builder::value))
            .traits(LocationTrait.builder().location(MarshallLocation.PAYLOAD).locationName("value").build()).build();

    private static final List<SdkField<?>> SDK_FIELDS = Collections.unmodifiableList(Arrays.asList(KEY_FIELD, VALUE_FIELD));

    private static final long serialVersionUID = 1L;

    private final String key;

    private final String value;

    private Tag(BuilderImpl builder) {
        this.key = builder.key;
        this.value = builder.value;
    }

    /**
     * <p>
     * The key name of a tag defined by a user. For more information, see <a
     * href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling User
     * Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
     * </p>
     * 
     * @return The key name of a tag defined by a user. For more information, see <a
     *         href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling
     *         User Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
     */
    public final String key() {
        return key;
    }

    /**
     * <p>
     * The optional value portion of a tag defined by a user. For more information, see <a
     * href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling User
     * Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
     * </p>
     * 
     * @return The optional value portion of a tag defined by a user. For more information, see <a
     *         href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling
     *         User Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
     */
    public final String value() {
        return value;
    }

    @Override
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    public static Builder builder() {
        return new BuilderImpl();
    }

    public static Class<? extends Builder> serializableBuilderClass() {
        return BuilderImpl.class;
    }

    @Override
    public final int hashCode() {
        int hashCode = 1;
        hashCode = 31 * hashCode + Objects.hashCode(key());
        hashCode = 31 * hashCode + Objects.hashCode(value());
        return hashCode;
    }

    @Override
    public final boolean equals(Object obj) {
        return equalsBySdkFields(obj);
    }

    @Override
    public final boolean equalsBySdkFields(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) obj;
        return Objects.equals(key(), other.key()) && Objects.equals(value(), other.value());
    }

    /**
     * Returns a string representation of this object. This is useful for testing and debugging. Sensitive data will be
     * redacted from this string using a placeholder value.
     */
    @Override
    public final String toString() {
        return ToString.builder("Tag").add("Key", key()).add("Value", value()).build();
    }

    public final <T> Optional<T> getValueForField(String fieldName, Class<T> clazz) {
        switch (fieldName) {
        case "key":
            return Optional.ofNullable(clazz.cast(key()));
        case "value":
            return Optional.ofNullable(clazz.cast(value()));
        default:
            return Optional.empty();
        }
    }

    @Override
    public final List<SdkField<?>> sdkFields() {
        return SDK_FIELDS;
    }

    private static <T> Function<Object, T> getter(Function<Tag, T> g) {
        return obj -> g.apply((Tag) obj);
    }

    private static <T> BiConsumer<Object, T> setter(BiConsumer<Builder, T> s) {
        return (obj, val) -> s.accept((Builder) obj, val);
    }

    public interface Builder extends SdkPojo, CopyableBuilder<Builder, Tag> {
        /**
         * <p>
         * The key name of a tag defined by a user. For more information, see <a
         * href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling User
         * Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
         * </p>
         * 
         * @param key
         *        The key name of a tag defined by a user. For more information, see <a
         *        href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html"
         *        >Controlling User Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder key(String key);

        /**
         * <p>
         * The optional value portion of a tag defined by a user. For more information, see <a
         * href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html">Controlling User
         * Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
         * </p>
         * 
         * @param value
         *        The optional value portion of a tag defined by a user. For more information, see <a
         *        href="http://docs.aws.amazon.com/datapipeline/latest/DeveloperGuide/dp-control-access.html"
         *        >Controlling User Access to Pipelines</a> in the <i>AWS Data Pipeline Developer Guide</i>.
         * @return Returns a reference to this object so that method calls can be chained together.
         */
        Builder value(String value);
    }

    static final class BuilderImpl implements Builder {
        private String key;

        private String value;

        private BuilderImpl() {
        }

        private BuilderImpl(Tag model) {
            key(model.key);
            value(model.value);
        }

        public final String getKey() {
            return key;
        }

        public final void setKey(String key) {
            this.key = key;
        }

        @Override
        public final Builder key(String key) {
            this.key = key;
            return this;
        }

        public final String getValue() {
            return value;
        }

        public final void setValue(String value) {
            this.value = value;
        }

        @Override
        public final Builder value(String value) {
            this.value = value;
            return this;
        }

        @Override
        public Tag build() {
            return new Tag(this);
        }

        @Override
        public List<SdkField<?>> sdkFields() {
            return SDK_FIELDS;
        }
    }
}
