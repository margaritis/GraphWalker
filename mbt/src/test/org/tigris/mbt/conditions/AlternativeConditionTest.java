package test.org.tigris.mbt.conditions;

import org.tigris.mbt.conditions.AlternativeCondition;
import org.tigris.mbt.conditions.AlwaysCondition;
import org.tigris.mbt.conditions.NeverCondition;

import junit.framework.TestCase;

public class AlternativeConditionTest extends TestCase {

	public void testConstructor()
	{
		new AlternativeCondition();
	}

	public void testFulfillment()
	{
		AlternativeCondition condition = new AlternativeCondition();
		condition.add(new NeverCondition());
		assertEquals((double)0, condition.getFulfillment(), 0.01);
		condition.add(new NeverCondition());
		assertEquals((double)0, condition.getFulfillment(), 0.01);
		condition.add(new AlwaysCondition());
		assertEquals((double)1, condition.getFulfillment(), 0.01);
		condition.add(new AlwaysCondition());
		assertEquals((double)1, condition.getFulfillment(), 0.01);
		condition.add(new NeverCondition());
		assertEquals((double)1, condition.getFulfillment(), 0.01);
	}

	public void testIsFulfilled()
	{
		AlternativeCondition condition = new AlternativeCondition();
		condition.add(new NeverCondition());
		assertEquals(false, condition.isFulfilled());
		condition.add(new NeverCondition());
		assertEquals(false, condition.isFulfilled());
		condition.add(new AlwaysCondition());
		assertEquals(true, condition.isFulfilled());
		condition.add(new AlwaysCondition());
		assertEquals(true, condition.isFulfilled());
		condition.add(new NeverCondition());
		assertEquals(true, condition.isFulfilled());
	}
}
