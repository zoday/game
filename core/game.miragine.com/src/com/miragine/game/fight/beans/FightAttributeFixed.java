/**
 * miragine.com
 * @author mudsong@gmail.com
 */
package com.miragine.game.fight.beans;

/**
 * 
 */
public abstract class FightAttributeFixed extends FightAttribute {
	
	/**
	 * ֵ
	 */
	protected int value;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
