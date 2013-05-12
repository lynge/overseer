package matcher;

import org.junit.Test;

public class TriggerBuilderTest
{
	
	@Test
	public void build() {
		TriggerBuilder builder = new TriggerBuilder();
		Trigger emptyTrigger = builder.build();
		emptyTrigger.trigger("entry");
	}
	
}
