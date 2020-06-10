function initializeCoreMod() {
    return {
        'RConNewlineFix': {
            "target": {
                "type": "METHOD",
                "class": "net.minecraft.network.rcon.RConConsoleSource",
                "methodName": "func_145747_a",
                "methodDesc": "(Lnet/minecraft/util/text/ITextComponent;)V"
            },
            "transformer": function(methodNode) {
                var asmapi = Java.type('net.minecraftforge.coremod.api.ASMAPI');
                var Opcodes = Java.type('org.objectweb.asm.Opcodes');
                var MethodInsnNode = Java.type('org.objectweb.asm.tree.MethodInsnNode');
				var VarInsnNode = Java.type('org.objectweb.asm.tree.VarInsnNode');
				var FieldInsnNode = Java.type('org.objectweb.asm.tree.FieldInsnNode');
				var JumpInsnNode = Java.type('org.objectweb.asm.tree.JumpInsnNode');
				var LabelNode = Java.type('org.objectweb.asm.tree.LabelNode');
				var IntInsnNode = Java.type('org.objectweb.asm.tree.IntInsnNode');
				var InsnNode = Java.type('org.objectweb.asm.tree.InsnNode');
				var fieldName = asmapi.mapField('field_70009_b');

                var labelElse = new LabelNode()
                var insertNL = asmapi.listOf(
                    new VarInsnNode(Opcodes.ALOAD, 0),
                    new FieldInsnNode(Opcodes.GETFIELD, 'net/minecraft/network/rcon/RConConsoleSource', fieldName, 'Ljava/lang/StringBuffer;'),
                    new MethodInsnNode(Opcodes.INVOKEVIRTUAL, 'java/lang/StringBuffer', 'length', '()I'),
                    new JumpInsnNode(Opcodes.IFLE, labelElse),
                    new VarInsnNode(Opcodes.ALOAD, 0),
                    new FieldInsnNode(Opcodes.GETFIELD, 'net/minecraft/network/rcon/RConConsoleSource', fieldName, 'Ljava/lang/StringBuffer;'),
                    new IntInsnNode(Opcodes.BIPUSH, 10),
                    new MethodInsnNode(Opcodes.INVOKEVIRTUAL, 'java/lang/StringBuffer', 'append', '(C)Ljava/lang/StringBuffer;'),
                    new InsnNode(Opcodes.POP),
                    labelElse
                );
                methodNode.instructions.insert(insertNL);
                return methodNode;
            }
        }
    }
}