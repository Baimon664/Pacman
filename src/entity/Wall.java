package entity;

import entity.base.Entity;
import logic.Sprites;

public class Wall extends Entity
{
	public int getSymbol() {
		return Sprites.BLUEWALL;
	}
}
