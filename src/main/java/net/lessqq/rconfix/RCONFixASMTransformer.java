package net.lessqq.rconfix;

import java.util.Map;

import codechicken.lib.asm.ASMBlock;
import codechicken.lib.asm.ASMReader;
import codechicken.lib.asm.ModularASMTransformer;
import codechicken.lib.asm.ModularASMTransformer.MethodInjector;
import codechicken.lib.asm.ObfMapping;
import net.minecraft.launchwrapper.IClassTransformer;

public class RCONFixASMTransformer implements IClassTransformer {
    private ModularASMTransformer transformer = new ModularASMTransformer();

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
