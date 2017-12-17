package net.lessqq.rconfix;

import codechicken.asm.ASMBlock;
import codechicken.asm.ASMReader;
import codechicken.asm.ModularASMTransformer;
import codechicken.asm.ObfMapping;
import codechicken.asm.transformers.MethodInjector;
import net.minecraft.launchwrapper.IClassTransformer;

import java.util.Map;

public class RCONFixASMTransformer implements IClassTransformer {
    private ModularASMTransformer transformer = new ModularASMTransformer("RConFixTransformer");

    public RCONFixASMTransformer() {
        Map<String, ASMBlock> blocks = ASMReader.loadResource("/assets/rconfix/asm/hooks.asm");
        transformer.add(new MethodInjector(new ObfMapping("net/minecraft/network/rcon/RConConsoleSource",
                "func_145747_a", "(Lnet/minecraft/util/text/ITextComponent;)V"), null, blocks.get("addNewline"), true));
    }

    @Override
    public byte[] transform(String name, String tname, byte[] bytes) {
        return transformer.transform(name, bytes);
    }
}
