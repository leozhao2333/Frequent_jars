package org.openqa.selenium.devtools.v104.browser.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * Definition of PermissionDescriptor defined in the Permissions API:
 * https://w3c.github.io/permissions/#dictdef-permissiondescriptor.
 */
@org.openqa.selenium.Beta()
public class PermissionDescriptor {

    private final java.lang.String name;

    private final java.util.Optional<java.lang.Boolean> sysex;

    private final java.util.Optional<java.lang.Boolean> userVisibleOnly;

    private final java.util.Optional<java.lang.Boolean> allowWithoutSanitization;

    private final java.util.Optional<java.lang.Boolean> panTiltZoom;

    public PermissionDescriptor(java.lang.String name, java.util.Optional<java.lang.Boolean> sysex, java.util.Optional<java.lang.Boolean> userVisibleOnly, java.util.Optional<java.lang.Boolean> allowWithoutSanitization, java.util.Optional<java.lang.Boolean> panTiltZoom) {
        this.name = java.util.Objects.requireNonNull(name, "name is required");
        this.sysex = sysex;
        this.userVisibleOnly = userVisibleOnly;
        this.allowWithoutSanitization = allowWithoutSanitization;
        this.panTiltZoom = panTiltZoom;
    }

    /**
     * Name of permission.
     * See https://cs.chromium.org/chromium/src/third_party/blink/renderer/modules/permissions/permission_descriptor.idl for valid permission names.
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * For "midi" permission, may also specify sysex control.
     */
    public java.util.Optional<java.lang.Boolean> getSysex() {
        return sysex;
    }

    /**
     * For "push" permission, may specify userVisibleOnly.
     * Note that userVisibleOnly = true is the only currently supported type.
     */
    public java.util.Optional<java.lang.Boolean> getUserVisibleOnly() {
        return userVisibleOnly;
    }

    /**
     * For "clipboard" permission, may specify allowWithoutSanitization.
     */
    public java.util.Optional<java.lang.Boolean> getAllowWithoutSanitization() {
        return allowWithoutSanitization;
    }

    /**
     * For "camera" permission, may specify panTiltZoom.
     */
    public java.util.Optional<java.lang.Boolean> getPanTiltZoom() {
        return panTiltZoom;
    }

    private static PermissionDescriptor fromJson(JsonInput input) {
        java.lang.String name = null;
        java.util.Optional<java.lang.Boolean> sysex = java.util.Optional.empty();
        java.util.Optional<java.lang.Boolean> userVisibleOnly = java.util.Optional.empty();
        java.util.Optional<java.lang.Boolean> allowWithoutSanitization = java.util.Optional.empty();
        java.util.Optional<java.lang.Boolean> panTiltZoom = java.util.Optional.empty();
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "name":
                    name = input.nextString();
                    break;
                case "sysex":
                    sysex = java.util.Optional.ofNullable(input.nextBoolean());
                    break;
                case "userVisibleOnly":
                    userVisibleOnly = java.util.Optional.ofNullable(input.nextBoolean());
                    break;
                case "allowWithoutSanitization":
                    allowWithoutSanitization = java.util.Optional.ofNullable(input.nextBoolean());
                    break;
                case "panTiltZoom":
                    panTiltZoom = java.util.Optional.ofNullable(input.nextBoolean());
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new PermissionDescriptor(name, sysex, userVisibleOnly, allowWithoutSanitization, panTiltZoom);
    }
}
