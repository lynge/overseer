package matcher;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.Test;

public class TriggerBuilderTest
{
	
	@Test
	public void build() {
		TriggerBuilder builder = new TriggerBuilder();
		Trigger emptyTrigger = builder.build();
		emptyTrigger.trigger("entry");
	}
	
	@Test
	public void addTriggerEntryAndBuild() {
		TriggerEntry triggerEntry = null;
		Trigger trigger = new TriggerBuilder().addEntry(triggerEntry).build();
		trigger.trigger("something");
	}
	
	@Test
	public void addTriggerEntryThatIsTriggeredByString() {
		final AtomicBoolean handlerIsInvoked = new AtomicBoolean(false);
		String regexp = "aaa";
		TriggerHandler handler = new TriggerHandler() {
			@Override
			public void handle() {
				handlerIsInvoked.set(true);
			}
		};
		TriggerEntry triggerEntry = new TriggerEntry(regexp, handler);
		Trigger trigger = new TriggerBuilder().addEntry(triggerEntry).build();
		trigger.trigger(regexp);
		Assert.assertTrue("Handler was not invoked", handlerIsInvoked.get());
	}

	@Test
	public void addTwoTriggerEntriesAndTriggerSecondOneByString() {
		final AtomicBoolean handlerIsInvoked = new AtomicBoolean(false);
		String regexp = "aaa";
		TriggerHandler handler = new TriggerHandler() {
			@Override
			public void handle() {
			}
		};
		TriggerEntry triggerEntry = new TriggerEntry(regexp, handler);
		String regexp2 = "bbb";
		TriggerHandler handler2 = new TriggerHandler() {
			@Override
			public void handle() {
				handlerIsInvoked.set(true);
			}
		};
		TriggerEntry triggerEntry2 = new TriggerEntry(regexp2, handler2);
		Trigger trigger = new TriggerBuilder().addEntry(triggerEntry).addEntry(triggerEntry2).build();
		trigger.trigger(regexp2);
		Assert.assertTrue("Handler was not invoked", handlerIsInvoked.get());
	}

}
