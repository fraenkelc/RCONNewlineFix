package net.lessqq.rconfix;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.ModMetadata;

public class RConFixCoreContainer extends DummyModContainer {
    private static final ModMetadata md;

    public RConFixCoreContainer() {
        super(md);
    }
    static {
        md = new ModMetadata();
        md.modId = "rconfixcore";
        md.name = "RCONFixCore";
        md.description = "Adds newlines to multiline rcon replies";
        md.authorList = Arrays.asList("Christian Fraenkel");
        md.version = "1.0.1";
    }

    @Override
    public List<String> getOwnedPackages() {
        return ImmutableList.of("net.lessqq.rconfix");
    }

}