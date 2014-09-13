package l2next.gameserver.network.serverpackets;

import l2next.gameserver.model.Player;
import l2next.gameserver.utils.Location;

/**
 * @author K1mel
 * @twitter http://twitter.com/k1mel_developer
 */
public class ExFlyMoveBroadcast extends L2GameServerPacket
{
	private int _objId;
	private int flyType;
	private Location _loc;
	private Location _destLoc;

	public ExFlyMoveBroadcast(Player player, int flyType, Location destLoc)
	{
		_objId = player.getObjectId();
		this.flyType = flyType;
		_loc = player.getLoc();
		_destLoc = destLoc;
	}

	@Override
	protected void writeImpl()
	{
		writeD(_objId);

		writeD(flyType);
		writeD(0x00); // TODO: [K1mel]

		writeD(_loc.getX());
		writeD(_loc.getY());
		writeD(_loc.getZ());

		writeD(0x00); // TODO: [K1mel]

		writeD(_destLoc.getX());
		writeD(_destLoc.getY());
		writeD(_destLoc.getZ());
	}
}