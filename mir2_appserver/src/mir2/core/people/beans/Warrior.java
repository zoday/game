/**
 * miragine.com
 * @author mudsong@gmail.com
 */
package mir2.core.people.beans;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;

import mir2.common.utils.RandomNumberUtils;
import mir2.core.fight.enums.SkillType;
import mir2.core.fight.pool.FighterMessage;
import mir2.core.fight.pool.FighterUnit;

/**
 * 战士
 */
@Entity
public class Warrior extends Fighter {

	@Override
	public List<FighterMessage> active(FighterUnit passive) {
		int assault = RandomNumberUtils.nextInt(attrs.getAssaultPhysical()
				.getMin(), attrs.getAssaultPhysical().getMax());
		int hurt = passive.doAssaultPhysical(assault);

		FighterMessage message = new FighterMessage(this, passive,
				SkillType.ASSAULT_PHYSICAL, hurt);
		return Collections.singletonList(message);
	}

	@Override
	public int doAssaultPhysical(int assault) {
		float shield = attrs.getShieldPhysical().getValue();
		float absolve = shield / (shield + level * ABSOLVE_PHYSICAL_HURT);
		int hurt = (int) (assault * absolve);
		hp.reduce(hurt);
		return hurt;
	}

	@Override
	public int doAssaultMagic(int assault) {
		float shield = attrs.getShieldMagic().getValue();
		float absolve = shield / (shield + level * ABSOLVE_MAGIC_HURT);
		int hurt = (int) (assault * absolve);
		hp.reduce(hurt);
		return hurt;
	}

}