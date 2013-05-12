package matcher;

public class TriggerEntry
{

	private String regExp;
	private TriggerHandler handler;

	public TriggerEntry(String regExp, TriggerHandler handler)
	{
		this.regExp = regExp;
		this.handler = handler;
	}

	public String getRegExp()
	{
		return regExp;
	}

	public TriggerHandler getHandler()
	{
		return handler;
	}

}
