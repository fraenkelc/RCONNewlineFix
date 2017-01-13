list addNewline
ALOAD 0
GETFIELD net/minecraft/network/rcon/RConConsoleSource.buffer : Ljava/lang/StringBuffer;
INVOKEVIRTUAL java/lang/StringBuffer.length ()I
IFLE LELSE
ALOAD 0
GETFIELD net/minecraft/network/rcon/RConConsoleSource.buffer : Ljava/lang/StringBuffer;
BIPUSH 10
INVOKEVIRTUAL java/lang/StringBuffer.append (C)Ljava/lang/StringBuffer;
POP
LELSE