package shukaro.warptheory.net;

import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import shukaro.warptheory.net.packets.*;

public class WarpMessageToMessageCodec extends FMLIndexedMessageToMessageCodec<WarpPacket>
{
    public static final int BLINKEVENT = 1;
    public static final int WINDEVENT = 2;
    public static final int BLOODEVENT = 3;
    public static final int CLEAREVENT = 4;

    public WarpMessageToMessageCodec()
    {
        addDiscriminator(BLINKEVENT, EnderParticlesPacket.class);
        addDiscriminator(WINDEVENT, VelocityPacket.class);
        addDiscriminator(BLOODEVENT, BloodPacket.class);
        addDiscriminator(CLEAREVENT, ClearPacket.class);
    }

    @Override
    public void encodeInto(ChannelHandlerContext ctx, WarpPacket msg, ByteBuf target) throws Exception
    {
        msg.writeBytes(target);
    }

    @Override
    public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, WarpPacket msg)
    {
        msg.readBytes(source);
    }
}
