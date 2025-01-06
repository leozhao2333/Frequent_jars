package org.openqa.selenium.devtools.v104.cast.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

public class Sink {

    private final java.lang.String name;

    private final java.lang.String id;

    private final java.util.Optional<java.lang.String> session;

    public Sink(java.lang.String name, java.lang.String id, java.util.Optional<java.lang.String> session) {
        this.name = java.util.Objects.requireNonNull(name, "name is required");
        this.id = java.util.Objects.requireNonNull(id, "id is required");
        this.session = session;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getId() {
        return id;
    }

    /**
     * Text describing the current session. Present only if there is an active
     * session on the sink.
     */
    public java.util.Optional<java.lang.String> getSession() {
        return session;
    }

    private static Sink fromJson(JsonInput input) {
        java.lang.String name = null;
        java.lang.String id = null;
        java.util.Optional<java.lang.String> session = java.util.Optional.empty();
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "name":
                    name = input.nextString();
                    break;
                case "id":
                    id = input.nextString();
                    break;
                case "session":
                    session = java.util.Optional.ofNullable(input.nextString());
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new Sink(name, id, session);
    }
}
