package io.thedogofchaos.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.client.ClientProxy;
import io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedProxy;

import com.lowdragmc.lowdraglib.Platform;
import com.tterrag.registrate.Registrate;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** “Life is a hideous thing, and from the background behind what we know of it peer daemoniacal hints of truth which make it sometimes a thousandfold more hideous.
 * <br>Science, already oppressive with its shocking revelations, will perhaps be the ultimate exterminator of our human species
 * —if separate species we be—
 * for its reserve of unguessed horrors could never be borne by mortal brains if loosed upon the world.”
 * <br>- H.P. Lovecraft
 */
@Mod(GregicAgrifactoryCore.MOD_ID)
public class GregicAgrifactoryCore {
    public static final String MOD_ID = "gregicagrifactory";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);

    public GregicAgrifactoryCore() {
        GregicAgrifactoryCore.init();
        DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> UnifiedProxy::new); // !: Keep this as safeRunForDist for now. Only switch to unsafeRunForDist when this coremod is stable.
    }

    public static void init() {
        LOGGER.info("We're loading {} on the {}", MOD_ID, Platform.platformName());
    }
}