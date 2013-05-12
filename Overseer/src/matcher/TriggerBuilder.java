package matcher;

import java.util.ArrayList;
import java.util.List;

public class TriggerBuilder
{

	private List<TriggerEntry> entries = new ArrayList<TriggerEntry>();

	public Trigger build()
	{
		Trigger trigger = new Trigger(entries);
		return trigger;
	}

	public TriggerBuilder addEntry(TriggerEntry triggerEntry)
	{
		if (triggerEntry == null)
		{
			return this;
		}
		entries.add(triggerEntry);
		return this;
	}

}
