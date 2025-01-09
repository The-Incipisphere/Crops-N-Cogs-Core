package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.Getter;
import lombok.NonNull;

@Getter // 08-01-2025: i was today years old when i found out that lombok annotations can be applied at the class level.
public class CropTextures {
    public static final CropTextures DEBUG = new CropTextures("debug");
    public static final CropTextures FOO = new CropTextures("foo");
    public static final CropTextures BAR = new CropTextures("bar");
    private final String textureSetName;

    private CropTextures(@NonNull String textureSetName) {
        // validation, make sure we’re not trying to define invalid shit to be passed into a ResourceLocation
        if (textureSetName.trim().isEmpty()) {
            throw new IllegalArgumentException("The texture set's name cannot be empty. Check your constants.");
        } else if (textureSetName.startsWith("_") || textureSetName.endsWith("_")) {
            throw new IllegalArgumentException("The texture set '" + textureSetName + "' cannot start or end with an underscore.");
        } else if (textureSetName.matches("[a-z0-9_.-]")) {
            throw new IllegalArgumentException("The texture set '" + textureSetName + "' must conform to the regex: [a-z0-9_.-]");
        }
        this.textureSetName = textureSetName;
    }
}
