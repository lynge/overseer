package matcher;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trigger
{

	private List<TriggerEntry> entries;
	private Pattern pattern;

	public Trigger(List<TriggerEntry> entries)
	{
		this.entries = entries;
		String or = "";
		StringBuilder regExp = new StringBuilder();
		for (TriggerEntry entry : entries)
		{
			regExp.append(or);
			regExp.append("(" + entry.getRegExp() + ")");
			or = "|";
		}
		pattern = Pattern.compile(regExp.toString());
	}

	public void trigger(String lookupString)
	{
		Matcher matcher = pattern.matcher(lookupString);
		if (matcher.matches())
		{
			for (int i = 0; i < matcher.groupCount(); i++)
			{
				if (matcher.group(i+1) != null)
				{
					entries.get(i).getHandler().handle();
				}
			}
		}
	}

}
