package net.lessqq.rconfix;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name(RConFixCore.MODID)
public class RConFixCore implements IFMLLoadingPlugin {

    public static final String MODID = "RCONNewlineFix";

    @Override
    public String[] getASMTransformerClass() {
        return new String[] { RCONFixASMTransformer.class.getName() };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> paramMap) {
        // nothing to do
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
