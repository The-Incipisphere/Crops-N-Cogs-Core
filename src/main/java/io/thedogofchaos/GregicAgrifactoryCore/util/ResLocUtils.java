package io.thedogofchaos.GregicAgrifactoryCore.util;

import com.gregtechceu.gtceu.utils.FormattingUtil;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import net.minecraft.resources.ResourceLocation;

/**
 * This class contains utilities to do with {@link ResourceLocation}
 * <br><br>
 * The class name is short for '{@code ResourceLocationUtilities}'.
 */
public class ResLocUtils {
    public static ResourceLocation id(String path) {
        return new ResourceLocation(GregicAgrifactoryCore.MOD_ID, FormattingUtil.toLowerCaseUnder(path));
    }
}
